import java.util.*;

public class Mercato {
    private Map<String, Azione> azioni;
    private Map<String, Investitore> investitori;

    public Mercato() {
        this.azioni = new HashMap<>();
        this.investitori = new HashMap<>();
    }

    public void aggiungiAzione(String nomeSocieta, String ticker, double prezzoIniziale) throws Exception {
        if (azioni.containsKey(ticker)) {
            throw new Exception("azione con ticker " + ticker + " già esistente!");
        }
        azioni.put(ticker, new Azione(nomeSocieta, ticker, prezzoIniziale));
    }

    public void registraInvestitore(String nome, double saldoIniziale) throws Exception {
        if (investitori.containsKey(nome)) {
            throw new Exception("investitore con nome " + nome + " già registrato!");
        }
        investitori.put(nome, new Investitore(nome, saldoIniziale));
    }

    public void acquistaAzione(String nomeInvestitore, String ticker, int quantita) throws Exception {
        if (!investitori.containsKey(nomeInvestitore)) {
            throw new Exception("investitore non trovato.");
        }
        if (!azioni.containsKey(ticker)) {
            throw new Exception("azione non trovata.");
        }

        Investitore investitore = investitori.get(nomeInvestitore);
        Azione azione = azioni.get(ticker);
        double costoTotale = azione.getPrezzo() * quantita;

        if (investitore.getSaldo() < costoTotale) {
            throw new Exception("saldo insufficiente.");
        }

        investitore.aggiornaSaldo(-costoTotale);
        investitore.getPortafoglio().put(ticker,
                investitore.getPortafoglio().getOrDefault(ticker, 0) + quantita);
        investitore.registraTransazione("acquisto: " + quantita + "x " + ticker + " a " + azione.getPrezzo());
    }

    public void vendiAzione(String nomeInvestitore, String ticker, int quantita) throws Exception {

        if (!investitori.containsKey(nomeInvestitore)) {
            throw new Exception("investitore non trovato.");
        }

        if (!azioni.containsKey(ticker)) {
            throw new Exception("azione non trovato.");
        }


        Investitore investitore = investitori.get(nomeInvestitore);
        if (!investitore.getPortafoglio().containsKey(ticker) || investitore.getPortafoglio().get(ticker) < quantita) {
            throw new Exception("quantità di azioni insufficiente.");
        }

        Azione azione = azioni.get(ticker);
        double ricavoTotale = azione.getPrezzo() * quantita;

        investitore.aggiornaSaldo(ricavoTotale);
        investitore.getPortafoglio().put(ticker, investitore.getPortafoglio().get(ticker) - quantita);
        if (investitore.getPortafoglio().get(ticker) == 0) {
            investitore.getPortafoglio().remove(ticker);
        }
        investitore.registraTransazione("vendita: " + quantita + "x " + ticker + " a " + azione.getPrezzo());
    }

    public void aggiornaPrezzi() {
        Random random = new Random();
        for (Azione azione : azioni.values()) {
            double variazione = (random.nextDouble() * 2 - 1) * 5;
            double nuovoPrezzo = Math.max(1, azione.getPrezzo() + azione.getPrezzo() * variazione / 100);
            azione.aggiornaPrezzo(nuovoPrezzo);
        }
    }

    public void mostraInvestitori() {
        for (Investitore investitore : investitori.values()) {
            System.out.println(investitore + ", valore portafoglio: " +
                    investitore.calcolaValorePortafoglio(azioni));
        }
    }

    public void mostraAzioni() {
        for (Azione azione : azioni.values()) {
            System.out.println(azione);
        }
    }
}
