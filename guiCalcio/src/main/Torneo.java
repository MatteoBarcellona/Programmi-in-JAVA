import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Torneo {
    private List<Squadra> squadre;
    private List<Partita> partite;
    private List<Squadra> classifica;
    private List<Torneo> torneo;

    public Torneo() {
        this.squadre = new ArrayList<>();
        this.partite = new ArrayList<>();
        this.classifica = new ArrayList<>();
        this.torneo = new ArrayList<>();
    }

    // Aggiunge una squadra al torneo
    public void aggiungiSquadra(Squadra squadra) {
        squadre.add(squadra);
    }

    // Rimuove una squadra dal torneo
    public void rimuoviSquadra(Squadra squadra) {
        if (squadre.remove(squadra)) {
            System.out.println("La squadra " + squadra.getNome() + " è stata rimossa.");
        } else {
            System.out.println("La squadra " + squadra.getNome() + " non esiste nel torneo.");
        }
    }

    // Restituisce un array di squadre
    public Squadra[] getSquadre() {
        return squadre.toArray(new Squadra[0]);
    }


    // Genera un calendario round-robin (tutti contro tutti)
    public List<Partita> generaCalendario() {
        List<Partita> calendario = new ArrayList<>();

        // Crea tutte le combinazioni di partite tra squadre
        for (int i = 0; i < squadre.size(); i++) {
            for (int j = i + 1; j < squadre.size(); j++) {
                Squadra squadraCasa = squadre.get(i);
                Squadra squadraTrasferta = squadre.get(j);
                Partita partita = new Partita(squadraCasa, squadraTrasferta); // Crea una nuova partita
                calendario.add(partita); // Aggiungi la partita al calendario
            }
        }

        return calendario; // Restituisce la lista di partite
    }


    // Simula risultati casuali per le partite e aggiorna i punti
    public void simulaPartite() {
        Random random = new Random();
        for (Partita partita : partite) {
            int golCasa = random.nextInt(5); // Gol casuali per la squadra di casa
            int golTrasferta = random.nextInt(5); // Gol casuali per la squadra ospite
            partita.setGolCasa(golCasa);
            partita.setGolTrasferta(golTrasferta);
            aggiornaPunti(partita); // Aggiorna i punti delle squadre
        }
    }

    public Squadra getSquadraByName(String nome) {
        for (Squadra squadra : squadre) {
            if (squadra.getNome().equals(nome)) {
                return squadra;
            }
        }
        return null; // Se non trovata
    }




    // Aggiorna i punti delle squadre in base ai risultati
    private void aggiornaPunti(Partita partita) {
        Squadra casa = partita.getSquadraCasa();
        Squadra trasferta = partita.getSquadraTrasferta();
        int golCasa = partita.getGolCasa();
        int golTrasferta = partita.getGolTrasferta();

        casa.setGolFatti(casa.getGolFatti() + golCasa);
        trasferta.setGolFatti(trasferta.getGolFatti() + golTrasferta);

        casa.setGolSubiti(casa.getGolSubiti() + golTrasferta);
        trasferta.setGolSubiti(trasferta.getGolSubiti() + golCasa);

        if (golCasa > golTrasferta) {
            casa.setPunti(casa.getPunti() + 3);
        } else if (golCasa < golTrasferta) {
            trasferta.setPunti(trasferta.getPunti() + 3);
        } else {
            casa.setPunti(casa.getPunti() + 1);
            trasferta.setPunti(trasferta.getPunti() + 1);
        }
    }

    // Ordina la classifica delle squadre
    public void aggiornaClassifica() {
        classifica = new ArrayList<>(squadre);
        classifica.sort((s1, s2) -> {
            if (s2.getPunti() != s1.getPunti()) {
                return Integer.compare(s2.getPunti(), s1.getPunti());
            }
            int differenzaReti1 = s1.getGolFatti() - s1.getGolSubiti();
            int differenzaReti2 = s2.getGolFatti() - s2.getGolSubiti();
            if (differenzaReti1 != differenzaReti2) {
                return Integer.compare(differenzaReti2, differenzaReti1);
            }
            return s1.getNome().compareTo(s2.getNome());
        });
    }

    // Mostra la classifica in formato leggibile
    public String mostraClassifica() {
        aggiornaClassifica();
        StringBuilder risultato = new StringBuilder();
        risultato.append(String.format("%-20s %-10s %-15s %-10s\n", "Squadra", "Punti", "Diff. Reti", "Gol Fatti"));
        for (Squadra squadra : classifica) {
            risultato.append(String.format("%-20s %-10d %-15d %-10d\n",
                    squadra.getNome(),
                    squadra.getPunti(),
                    squadra.getGolFatti() - squadra.getGolSubiti(),
                    squadra.getGolFatti()));
        }
        return risultato.toString();
    }

    // Mostra tutte le partite con i risultati
    public String mostraPartite() {
        StringBuilder sb = new StringBuilder();
        for (Partita partita : partite) {
            sb.append(String.format("%-20s %d - %d %-20s\n",
                    partita.getSquadraCasa().getNome(),
                    partita.getGolCasa(),
                    partita.getGolTrasferta(),
                    partita.getSquadraTrasferta().getNome()));
        }
        return sb.toString();
    }

    // Genera un report completo del torneo
    public void generaReport() {
        System.out.println("=== Report del Torneo ===\n");
        System.out.println("Classifica:\n");
        System.out.println(mostraClassifica());
        System.out.println("Partite giocate:\n");
        System.out.println(mostraPartite());
    }

    // Gestisce un risultato specifico tra due squadre
    public void gestisciRisultato(String nomeCasa, String nomeTrasferta, int golCasa, int golTrasferta) {
        Squadra casa = null, trasferta = null;
        for (Squadra squadra : squadre) {
            if (squadra.getNome().equals(nomeCasa)) {
                casa = squadra;
            } else if (squadra.getNome().equals(nomeTrasferta)) {
                trasferta = squadra;
            }
        }
        if (casa == null || trasferta == null) {
            System.out.println("Errore: Squadra non trovata.");
            return;
        }
        Partita partita = new Partita(casa, trasferta);
        partita.setGolCasa(golCasa);
        partita.setGolTrasferta(golTrasferta);
        aggiornaPunti(partita);
    }


    public void aggiornaRisultato(String squadraCasa, String squadraOspite, int golCasa, int golOspite) {
        // Trova le squadre nel torneo
        Squadra squadra1 = null;
        Squadra squadra2 = null;

        // Cerca le squadre in base ai loro nomi
        for (Squadra squadra : squadre) {
            if (squadra.getNome().equals(squadraCasa)) {
                squadra1 = squadra;
            }
            if (squadra.getNome().equals(squadraOspite)) {
                squadra2 = squadra;
            }
        }

        // Se le squadre sono state trovate, aggiorna i risultati
        if (squadra1 != null && squadra2 != null) {
            // Aggiorna i gol fatti e subiti
            squadra1.setGolFatti(squadra1.getGolFatti() + golCasa);
            squadra1.setGolSubiti(squadra1.getGolSubiti() + golOspite);
            squadra2.setGolFatti(squadra2.getGolFatti() + golOspite);
            squadra2.setGolSubiti(squadra2.getGolSubiti() + golCasa);

            // Aggiorna i punti in base al risultato
            if (golCasa > golOspite) {
                squadra1.setPunti(squadra1.getPunti() + 3); // 3 punti per la vittoria
            } else if (golOspite > golCasa) {
                squadra2.setPunti(squadra2.getPunti() + 3); // 3 punti per la vittoria
            } else {
                squadra1.setPunti(squadra1.getPunti() + 1); // 1 punto per pareggio
                squadra2.setPunti(squadra2.getPunti() + 1); // 1 punto per pareggio
            }
        }
    }


    public void salvaReportSuFile() throws IOException {
        // Crea il file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report_torneo.txt"))) {
            writer.write("=== Report del Torneo ===\n\n");

            // Scrivi la classifica
            writer.write("Classifica:\n");
            writer.write(String.format("%-20s %-10s %-15s %-10s\n", "Squadra", "Punti", "Differenza Reti", "Gol Fatti"));
            for (Squadra squadra : classifica) {
                writer.write(String.format("%-20s %-10d %-15d %-10d\n",
                        squadra.getNome(),
                        squadra.getPunti(),
                        squadra.getGolFatti() - squadra.getGolSubiti(),
                        squadra.getGolFatti()));
            }

            writer.write("\n");

            // Scrivi le partite
            writer.write("Partite giocate:\n");
            for (Partita partita : partite) {
                writer.write(String.format("%-20s %d - %d %-20s\n",
                        partita.getSquadraCasa().getNome(),
                        partita.getGolCasa(),
                        partita.getGolTrasferta(),
                        partita.getSquadraTrasferta().getNome()));
            }
        }

        JOptionPane.showMessageDialog(null, "Report salvato con successo!");
    }



    public List<Squadra> getClassifica() {
        return classifica;
    }

    public List<Partita> generaPartite() {
        return partite;
    }

    public Partita[] getPartite() {
        return partite.toArray(new Partita[0]);
    }

    public void aggiungiPartita(Partita partita) {
        partite.add(partita);
    }
}
