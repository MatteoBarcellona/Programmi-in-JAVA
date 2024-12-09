import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.List;

public class InterfacciaGrafica {
    private GestorePrenotazioni gestore;
    private JFrame frame;
    private JTextField nomeField;
    private JTextField bigliettiField;
    private JComboBox<String> tipoBigliettoCombo;
    private JDateChooser dataChooser;  // Dichiarazione del JDateChooser
    private JTable table;
    private DefaultTableModel tableModel;

    public InterfacciaGrafica() {
        gestore = new GestorePrenotazioni(20.0);
        creaFinestra();
    }

    private void creaFinestra() {
        // Applica il tema moderno Nimbus
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = new JFrame("Gestione Prenotazioni Parco Divertimenti");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Pannello di prenotazione con un layout più elegante
        JPanel prenotazionePanel = new JPanel();
        prenotazionePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding per ogni elemento

        // Aggiungi i componenti al pannello di prenotazione
        int row = 0;
        prenotazionePanel.add(new JLabel("Nome Utente:"), setGridBagConstraints(gbc, 0, row));
        nomeField = new JTextField(20);
        prenotazionePanel.add(nomeField, setGridBagConstraints(gbc, 1, row));

        row++;
        prenotazionePanel.add(new JLabel("Numero Biglietti:"), setGridBagConstraints(gbc, 0, row));
        bigliettiField = new JTextField(20);
        prenotazionePanel.add(bigliettiField, setGridBagConstraints(gbc, 1, row));

        row++;
        prenotazionePanel.add(new JLabel("Data Visita:"), setGridBagConstraints(gbc, 0, row));
        dataChooser = new JDateChooser();
        prenotazionePanel.add(dataChooser, setGridBagConstraints(gbc, 1, row));

        row++;
        prenotazionePanel.add(new JLabel("Tipo Biglietto:"), setGridBagConstraints(gbc, 0, row));
        tipoBigliettoCombo = new JComboBox<>(new String[] {"Standard", "Premium"});
        prenotazionePanel.add(tipoBigliettoCombo, setGridBagConstraints(gbc, 1, row));

        row++;
        JButton prenotaButton = new JButton("Prenota");
        prenotaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prenotaBiglietti();
            }
        });
        prenotazionePanel.add(prenotaButton, setGridBagConstraints(gbc, 1, row));

        frame.add(prenotazionePanel, BorderLayout.NORTH);

        // Tabella per visualizzare le prenotazioni
        String[] columnNames = {"Nome Utente", "Biglietti", "Data", "Tipo Biglietto", "Costo Totale"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);
        table.setSelectionBackground(Color.CYAN);

        // Impostazioni per le linee nere tra le righe e le colonne
        table.setGridColor(Color.BLACK);  // Colore delle linee di griglia
        table.setShowGrid(true); // Mostra la griglia
        table.setIntercellSpacing(new Dimension(1, 1)); // Distanza tra le celle

        // Personalizza l'aspetto delle righe
        table.setDefaultRenderer(Object.class, new javax.swing.table.TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                // Crea un JLabel per ogni cella
                JLabel label = new JLabel();
                label.setText(value != null ? value.toString() : "");
                label.setOpaque(true); // Rende la cella opaca per poter cambiare il colore di sfondo

                // Imposta il colore di sfondo alternato per le righe
                if (row % 2 == 0) {
                    label.setBackground(Color.WHITE);  // Righe pari bianche
                } else {
                    label.setBackground(new Color(240, 240, 240));  // Righe dispari grigie
                }

                // Se la riga è selezionata, cambia il colore di sfondo
                if (isSelected) {
                    label.setBackground(Color.CYAN);  // Colore di sfondo per la riga selezionata
                }

                return label;  // Restituisce il componente personalizzato
            }
        });

        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Aggiornare la tabella
        aggiornaTabella();

        // Imposta la finestra
        frame.setSize(600, 400);  // Imposta una dimensione iniziale
        frame.setLocationRelativeTo(null);  // Centra la finestra
        frame.setVisible(true);
    }

    private GridBagConstraints setGridBagConstraints(GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        return gbc;
    }

    private void prenotaBiglietti() {
        String nomeUtente = nomeField.getText();
        int numeroBiglietti = Integer.parseInt(bigliettiField.getText());
        Date dataVisita = dataChooser.getDate();  // Ottenere la data dal JDateChooser
        String tipoBiglietto = (String) tipoBigliettoCombo.getSelectedItem();

        if (gestore.prenotaBiglietti(nomeUtente, numeroBiglietti, dataVisita, tipoBiglietto)) {
            JOptionPane.showMessageDialog(frame, "Prenotazione effettuata con successo!");
            aggiornaTabella();
        } else {
            JOptionPane.showMessageDialog(frame, "Errore nella prenotazione. Controlla i dati.");
        }
    }

    private void aggiornaTabella() {
        List<Prenotazione> prenotazioni = gestore.getPrenotazioni();
        tableModel.setRowCount(0);  // Svuota la tabella
        for (Prenotazione p : prenotazioni) {
            tableModel.addRow(new Object[] {
                    p.getNomeUtente(),
                    p.getNumeroBiglietti(),
                    p.getDataVisita(),
                    p.getTipoBiglietto(),
                    p.getCostoTotale()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfacciaGrafica();
            }
        });
    }
}
