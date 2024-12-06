import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TorneoGUI extends JFrame {
    private JTable tabellaClassifica;
    private DefaultTableModel modelloTabella;
    private Torneo torneo;

    public TorneoGUI(Torneo torneo) {
        this.torneo = torneo; // Associa l'oggetto Torneo
        setTitle("Classifica Torneo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creazione del modello della tabella
        modelloTabella = new DefaultTableModel();
        modelloTabella.addColumn("Squadra");
        modelloTabella.addColumn("Punti");
        modelloTabella.addColumn("Differenza Reti");
        modelloTabella.addColumn("Gol Fatti");
        modelloTabella.addColumn("Gol Subiti");

        // Creazione della JTable
        tabellaClassifica = new JTable(modelloTabella);
        JScrollPane scrollPane = new JScrollPane(tabellaClassifica);
        add(scrollPane, BorderLayout.CENTER);

        // Pannello per aggiungere nuove squadre
        JPanel pannelloAggiungiSquadra = new JPanel();
        pannelloAggiungiSquadra.setLayout(new FlowLayout());

        JTextField nomeSquadraField = new JTextField(15);
        JTextField puntiField = new JTextField(5);
        JTextField golFattiField = new JTextField(5);
        JTextField golSubitiField = new JTextField(5);

        pannelloAggiungiSquadra.add(new JLabel("Nome Squadra:"));
        pannelloAggiungiSquadra.add(nomeSquadraField);
        pannelloAggiungiSquadra.add(new JLabel("Punti:"));
        pannelloAggiungiSquadra.add(puntiField);
        pannelloAggiungiSquadra.add(new JLabel("Gol Fatti:"));
        pannelloAggiungiSquadra.add(golFattiField);
        pannelloAggiungiSquadra.add(new JLabel("Gol Subiti:"));
        pannelloAggiungiSquadra.add(golSubitiField);

        JButton aggiungiButton = new JButton("Aggiungi Squadra");
        aggiungiButton.addActionListener(e -> {
            String nomeSquadra = nomeSquadraField.getText();
            int punti = Integer.parseInt(puntiField.getText());
            int golFatti = Integer.parseInt(golFattiField.getText());
            int golSubiti = Integer.parseInt(golSubitiField.getText());
            int giocatori=0;

            String logoSquadra = "";
            Squadra nuovaSquadra = new Squadra(nomeSquadra, logoSquadra, giocatori);
            nuovaSquadra.setPunti(punti);
            nuovaSquadra.setGolFatti(golFatti);
            nuovaSquadra.setGolSubiti(golSubiti);

            torneo.aggiungiSquadra(nuovaSquadra);  // Aggiungi la squadra al torneo
            aggiornaClassifica(torneo);  // Aggiorna la tabella con la nuova squadra
        });

        pannelloAggiungiSquadra.add(aggiungiButton);
        add(pannelloAggiungiSquadra, BorderLayout.NORTH);

        // Mostra la finestra
        setVisible(true);
    }

    // Metodo per aggiornare la classifica nella tabella
    private void aggiornaClassifica(Torneo torneo) {
        // Pulisce il modello della tabella
        modelloTabella.setRowCount(0);

        // Ottieni la classifica ordinata
        torneo.aggiornaClassifica();
        List<Squadra> classifica = torneo.getClassifica();

        // Aggiungi le righe alla tabella
        for (Squadra squadra : classifica) {
            modelloTabella.addRow(new Object[]{
                    squadra.getNome(),
                    squadra.getPunti(),
                    squadra.getGolFatti() - squadra.getGolSubiti(), // Differenza reti
                    squadra.getGolFatti(),
                    squadra.getGolSubiti()
            });
        }
    }

    public static void main(String[] args) {
        // Creazione del torneo
        Torneo torneo = new Torneo();

        // Creazione dell'interfaccia grafica
        new TorneoGUI(torneo);
    }
}
