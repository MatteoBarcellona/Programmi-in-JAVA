import java.util.*;

public class Investitore {
    private String nome;
    private double saldo;
    private Map<String, Integer> portafoglio;
    private List<String> cronologiaTransazioni;

    public Investitore(String nome, double saldoIniziale) {
        this.nome = nome;
        this.saldo = saldoIniziale;
        this.portafoglio = new HashMap<>();
        this.cronologiaTransazioni = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void aggiornaSaldo(double importo) {
        saldo += importo;
    }

    public Map<String, Integer> getPortafoglio() {
        return portafoglio;
    }

    public void registraTransazione(String transazione) {
        cronologiaTransazioni.add(transazione);
    }

    public List<String> getCronologiaTransazioni() {
        return cronologiaTransazioni;
    }

    public double calcolaValorePortafoglio(Map<String, Azione> azioni) {
        double valoreTotale = 0;
        for (Map.Entry<String, Integer> entry : portafoglio.entrySet()) {
            String ticker = entry.getKey();
            int quantita = entry.getValue();
            if (azioni.containsKey(ticker)) {
                valoreTotale += azioni.get(ticker).getPrezzo() * quantita;
            }
        }
        return valoreTotale;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Soldi: " + saldo;
    }
}
