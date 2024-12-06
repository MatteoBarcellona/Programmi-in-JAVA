import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

public class CarrelloGUI {
    private Carrello carrello;
    private JTable tabella;
    private DefaultTableModel modelloTabella;
    private JLabel totaleLabel;
    private JLabel scontoLabel;

    public CarrelloGUI() {
        carrello = new Carrello();
        creaInterfaccia();
    }

    private void creaInterfaccia() {
        JFrame frame = new JFrame("Carrello della Spesa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        frame.setLayout(new BorderLayout());

        JPanel pannelloInput = new JPanel(new FlowLayout());

        JTextField nomeField = new JTextField(10);
        JTextField prezzoField = new JTextField(5);
        JTextField quantitaField = new JTextField(5);

        JButton aggiungiButton = new JButton("Aggiungi");
        JButton rimuoviButton = new JButton("Rimuovi");
        JButton modificaButton = new JButton("Modifica");
        JButton svuotaCarrelloButton = new JButton("Svuota Carrello");

        pannelloInput.add(new JLabel("Nome:"));
        pannelloInput.add(nomeField);
        pannelloInput.add(new JLabel("Prezzo:"));
        pannelloInput.add(prezzoField);
        pannelloInput.add(new JLabel("Quantità:"));
        pannelloInput.add(quantitaField);
        pannelloInput.add(aggiungiButton);
        pannelloInput.add(rimuoviButton);
        pannelloInput.add(modificaButton);
        pannelloInput.add(svuotaCarrelloButton);

        String[] colonne = {"Nome", "Prezzo", "Quantità", "Totale"};
        DefaultTableModel modelloTabella = new DefaultTableModel(colonne, 0);
        JTable tabella = new JTable(modelloTabella);
        JScrollPane scrollPane = new JScrollPane(tabella);

        JLabel totaleLabel = new JLabel("Totale: 0.00€");
        JLabel totaleConScontoLabel = new JLabel("Totale con Sconto: 0.00€");

        JPanel pannelloTotali = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pannelloTotali.add(totaleLabel);
        pannelloTotali.add(totaleConScontoLabel);

        aggiungiButton.addActionListener(e -> {
            String nome = nomeField.getText().trim();
            String prezzoText = prezzoField.getText().trim();
            String quantitaText = quantitaField.getText().trim();

            if (nome.isEmpty() || prezzoText.isEmpty() || quantitaText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Tutti i campi devono essere compilati.", "Errore", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                double prezzo = Double.parseDouble(prezzoText);
                int quantita = Integer.parseInt(quantitaText);

                if (prezzo <= 0 || quantita <= 0) {
                    JOptionPane.showMessageDialog(frame, "Prezzo e quantità devono essere positivi.", "Errore", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                carrello.aggiungiProdotto(new Prodotto(nome, prezzo, quantita));
                aggiornaTabella(modelloTabella, totaleLabel, totaleConScontoLabel);

                nomeField.setText("");
                prezzoField.setText("");
                quantitaField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Prezzo e quantità devono essere numeri validi.", "Errore", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Azione per il pulsante "Rimuovi"
        rimuoviButton.addActionListener(e -> {
            int selectedRow = tabella.getSelectedRow();
            if (selectedRow != -1) {
                String nome = (String) modelloTabella.getValueAt(selectedRow, 0);
                carrello.rimuoviProdotto(nome);
                aggiornaTabella(modelloTabella, totaleLabel, totaleConScontoLabel);
            } else {
                JOptionPane.showMessageDialog(frame, "Seleziona un prodotto da rimuovere.", "Errore", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Azione per il pulsante "Modifica"
        modificaButton.addActionListener(e -> {
            int selectedRow = tabella.getSelectedRow();
            if (selectedRow != -1) {
                String nome = (String) modelloTabella.getValueAt(selectedRow, 0);
                String nuovaQuantita = JOptionPane.showInputDialog(frame, "Inserisci la nuova quantità per " + nome + ":");
                try {
                    int quantita = Integer.parseInt(nuovaQuantita);
                    if (quantita <= 0) {
                        JOptionPane.showMessageDialog(frame, "La quantità deve essere maggiore di zero.", "Errore", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    carrello.modificaQuantita(nome, quantita);
                    aggiornaTabella(modelloTabella, totaleLabel, totaleConScontoLabel);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "La quantità deve essere un numero valido.", "Errore", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Seleziona un prodotto da modificare.", "Errore", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Azione per il pulsante "Svuota Carrello"
        svuotaCarrelloButton.addActionListener(e -> {
            carrello.svuotaCarrello();
            aggiornaTabella(modelloTabella, totaleLabel, totaleConScontoLabel);
        });

        // Aggiunta dei pannelli al frame principale
        frame.add(pannelloInput, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(pannelloTotali, BorderLayout.SOUTH);

        // Mostra la finestra
        frame.setVisible(true);
    }

    // Metodo per aggiornare la tabella e le etichette dei totali
    private void aggiornaTabella(DefaultTableModel modelloTabella, JLabel totaleLabel, JLabel totaleConScontoLabel) {
        modelloTabella.setRowCount(0); // Svuota la tabella

        for (Prodotto prodotto : carrello.getProdotti()) {
            Object[] riga = {
                    prodotto.getNome(),
                    prodotto.getPrezzo(),
                    prodotto.getQuantita(),
                    prodotto.calcolaTotale()
            };
            modelloTabella.addRow(riga);
        }

        double totale = carrello.calcolaTotale();
        totaleLabel.setText("Totale: " + String.format("%.2f", totale) + "€");

        double totaleConSconto = carrello.calcolaTotaleConSconto();
        totaleConScontoLabel.setText("Totale con Sconto: " + String.format("%.2f", totaleConSconto) + "€");
    }

    private void aggiornaTabella() {
        modelloTabella.setRowCount(0);
        for (Prodotto prodotto : carrello.getProdotti()) {
            modelloTabella.addRow(new Object[]{
                    prodotto.getNome(),
                    prodotto.getPrezzo(),
                    prodotto.getQuantita(),
                    prodotto.calcolaTotale()
            });
        }
        totaleLabel.setText("Totale: " + carrello.calcolaTotale() + "€");
        scontoLabel.setText("Totale con Sconto: " + carrello.calcolaTotaleConSconto() + "€");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CarrelloGUI::new);
    }
}