import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class NegozioVideogiochi extends JFrame {
    private ArrayList<Videogioco> catalogo = new ArrayList<>();
    private ArrayList<Videogioco> carrello = new ArrayList<>();

    private JTable tabellaCatalogo;
    private JTable tabellaCarrello;
    private DefaultTableModel modelloCatalogo;
    private DefaultTableModel modelloCarrello;

    private JLabel totaleCarrelloLabel;

    public NegozioVideogiochi() {
        setTitle("Negozio di Videogiochi");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Applica un tema moderno
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        initUI();
    }

    private void initUI() {
        // Pannello principale
        JPanel pannelloCatalogo = new JPanel(new BorderLayout());
        pannelloCatalogo.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
                "Catalogo Videogiochi di Matteo Barcellona",
                0, 0, new Font("SansSerif", Font.BOLD, 18), Color.DARK_GRAY));

        // Form di inserimento
        JPanel pannelloForm = new JPanel(new GridLayout(6, 2, 5, 5));
        pannelloForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pannelloForm.setBackground(new Color(230, 230, 250));

        JTextField titoloField = new JTextField();
        JTextField sviluppatoreField = new JTextField();
        JTextField prezzoField = new JTextField();
        JTextField scontoField = new JTextField();
        JLabel copertinaPreview = new JLabel("Nessuna immagine selezionata", SwingConstants.CENTER);
        copertinaPreview.setOpaque(true);
        copertinaPreview.setBackground(new Color(240, 240, 240));
        JButton selezionaCopertinaBtn = new JButton("Seleziona Copertina");
        JButton aggiungiBtn = new JButton("Aggiungi Videogioco");

        selezionaCopertinaBtn.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                copertinaPreview.setText(fileChooser.getSelectedFile().getAbsolutePath());
                copertinaPreview.setBackground(Color.WHITE);
            }
        });

        pannelloForm.add(new JLabel("Titolo:"));
        pannelloForm.add(titoloField);
        pannelloForm.add(new JLabel("Sviluppatore:"));
        pannelloForm.add(sviluppatoreField);
        pannelloForm.add(new JLabel("Prezzo (€):"));
        pannelloForm.add(prezzoField);
        pannelloForm.add(new JLabel("Sconto (%):"));
        pannelloForm.add(scontoField);
        pannelloForm.add(new JLabel("Copertina:"));
        pannelloForm.add(selezionaCopertinaBtn);
        pannelloForm.add(new JLabel());
        pannelloForm.add(aggiungiBtn);

        // Tabella Catalogo
        String[] colonneCatalogo = {"Titolo", "Sviluppatore", "Prezzo", "Prezzo Scontato", "Copertina"};
        modelloCatalogo = new DefaultTableModel(colonneCatalogo, 0);
        tabellaCatalogo = new JTable(modelloCatalogo);
        tabellaCatalogo.setRowHeight(60);

        // Impostazione delle linee grigie nelle tabelle
        tabellaCatalogo.setGridColor(Color.LIGHT_GRAY);
        tabellaCatalogo.setShowGrid(true);
        tabellaCatalogo.setIntercellSpacing(new Dimension(1, 1));
        tabellaCatalogo.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public void setValue(Object value) {
                if (value instanceof String) {
                    setIcon(new ImageIcon(new ImageIcon((String) value).getImage().getScaledInstance(110, 50, Image.SCALE_SMOOTH)));
                } else {
                    setText("");
                }
            }
        });

        pannelloCatalogo.add(pannelloForm, BorderLayout.NORTH);
        pannelloCatalogo.add(new JScrollPane(tabellaCatalogo), BorderLayout.CENTER);

        // Pannello Carrello
        JPanel pannelloCarrello = new JPanel(new BorderLayout());
        pannelloCarrello.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
                "Carrello",
                0, 0, new Font("SansSerif", Font.BOLD, 18), Color.DARK_GRAY));

        String[] colonneCarrello = {"Titolo", "Prezzo Scontato"};
        modelloCarrello = new DefaultTableModel(colonneCarrello, 0);
        tabellaCarrello = new JTable(modelloCarrello);

        // Impostazione delle linee grigie nel carrello
        tabellaCarrello.setGridColor(Color.LIGHT_GRAY);
        tabellaCarrello.setShowGrid(true);
        tabellaCarrello.setIntercellSpacing(new Dimension(1, 1));

        totaleCarrelloLabel = new JLabel("Totale: €0.00", SwingConstants.CENTER);
        totaleCarrelloLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        totaleCarrelloLabel.setOpaque(true);
        totaleCarrelloLabel.setBackground(new Color(240, 255, 255));

        JButton svuotaCarrelloBtn = new JButton("Svuota Carrello");
        svuotaCarrelloBtn.setBackground(new Color(255, 99, 71));
        svuotaCarrelloBtn.setForeground(Color.WHITE);
        svuotaCarrelloBtn.addActionListener(e -> {
            carrello.clear();
            aggiornaCarrello();
        });

        pannelloCarrello.add(new JScrollPane(tabellaCarrello), BorderLayout.CENTER);
        pannelloCarrello.add(svuotaCarrelloBtn, BorderLayout.NORTH);
        pannelloCarrello.add(totaleCarrelloLabel, BorderLayout.SOUTH);

        // Aggiungi componenti principali
        add(pannelloCatalogo, BorderLayout.CENTER);
        add(pannelloCarrello, BorderLayout.EAST);

        // Eventi Pulsanti
        aggiungiBtn.addActionListener(e -> {
            String titolo = titoloField.getText();
            String sviluppatore = sviluppatoreField.getText();
            double prezzo = Double.parseDouble(prezzoField.getText());
            double sconto = Double.parseDouble(scontoField.getText());
            String copertina = copertinaPreview.getText();

            Videogioco videogioco = new Videogioco(titolo, sviluppatore, prezzo, sconto, copertina);
            catalogo.add(videogioco);
            aggiornaCatalogo();
        });

        tabellaCatalogo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tabellaCatalogo.getSelectedRow();
                Videogioco selezionato = catalogo.get(row);
                carrello.add(selezionato);
                aggiornaCarrello();
            }
        });
    }

    private void aggiornaCatalogo() {
        modelloCatalogo.setRowCount(0);
        for (Videogioco videogioco : catalogo) {
            modelloCatalogo.addRow(new Object[]{
                    videogioco.getTitolo(),
                    videogioco.getSviluppatore(),
                    videogioco.getPrezzo(),
                    videogioco.calcolaPrezzoScontato(),
                    videogioco.getCopertina()
            });
        }
    }

    private void aggiornaCarrello() {
        modelloCarrello.setRowCount(0);
        double totale = 0;
        for (Videogioco videogioco : carrello) {
            totale += videogioco.calcolaPrezzoScontato();
            modelloCarrello.addRow(new Object[]{
                    videogioco.getTitolo(),
                    videogioco.calcolaPrezzoScontato()
            });
        }
        totaleCarrelloLabel.setText("Totale: €" + String.format("%.2f", totale));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NegozioVideogiochi().setVisible(true);
        });
    }
}
