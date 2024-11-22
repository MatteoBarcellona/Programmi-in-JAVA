import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class LibreriaGUI {
    private CatalogoLibri catalogo;
    private JFrame frame;
    private JTextField titoloField, autoreField, isbnField, annoField;
    private JTable table;
    private boolean tabellaMostrata = false; // Stato per il pulsante "Mostra Tutti"

    public LibreriaGUI() {
        catalogo = new CatalogoLibri();

        // Creazione della finestra principale
        frame = new JFrame("📚 Libreria - Gestione Catalogo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(240, 248, 255)); // Azzurro chiaro

        // Creazione dei pannelli
        JPanel inputPanel = createInputPanel();
        JPanel buttonPanel = createButtonPanel();
        JScrollPane tableScrollPane = createTablePanel();

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(tableScrollPane, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 4, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("📖 Inserisci Nuovo Libro"));
        panel.setBackground(new Color(245, 245, 245)); // Grigio chiaro

        panel.add(new JLabel("Titolo:"));
        titoloField = new JTextField();
        panel.add(titoloField);

        panel.add(new JLabel("Autore:"));
        autoreField = new JTextField();
        panel.add(autoreField);

        panel.add(new JLabel("ISBN:"));
        isbnField = new JTextField();
        panel.add(isbnField);

        panel.add(new JLabel("Anno:"));
        annoField = new JTextField();
        panel.add(annoField);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("🔧 Azioni"));
        panel.setBackground(new Color(255, 250, 240)); // Bianco caldo

        JButton aggiungiButton = new JButton("➕ Aggiungi");
        aggiungiButton.setFont(new Font("Arial", Font.BOLD, 14));
        aggiungiButton.setBackground(new Color(144, 238, 144)); // Verde chiaro
        aggiungiButton.addActionListener(e -> aggiungiLibro());
        panel.add(aggiungiButton);

        JButton cercaButton = new JButton("🔍 Cerca");
        cercaButton.setFont(new Font("Arial", Font.BOLD, 14));
        cercaButton.setBackground(new Color(173, 216, 230)); // Azzurro
        cercaButton.addActionListener(e -> cercaLibro());
        panel.add(cercaButton);

        JButton mostraTuttiButton = new JButton("📋 Mostra / Nascondi Tutti");
        mostraTuttiButton.setFont(new Font("Arial", Font.BOLD, 14));
        mostraTuttiButton.setBackground(new Color(255, 239, 213)); // Arancio chiaro
        mostraTuttiButton.addActionListener(e -> mostraNascondiLibri());
        panel.add(mostraTuttiButton);

        JButton rimuoviButton = new JButton("🗑️ Rimuovi");
        rimuoviButton.setFont(new Font("Arial", Font.BOLD, 14));
        rimuoviButton.setBackground(new Color(255, 182, 193)); // Rosa
        rimuoviButton.addActionListener(e -> rimuoviLibro());
        panel.add(rimuoviButton);

        return panel;
    }

    private JScrollPane createTablePanel() {
        table = new JTable(new DefaultTableModel(new String[]{"Titolo", "Autore", "ISBN", "Anno"}, 0)) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);

        // Renderer per alternare colori di righe
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(245, 245, 245)); // Alternanza di colori
                } else {
                    c.setBackground(new Color(173, 216, 230)); // Selezione blu chiaro
                }
                return c;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("📚 Catalogo Libri"));
        return scrollPane;
    }

    private void aggiungiLibro() {
        try {
            String titolo = titoloField.getText();
            String autore = autoreField.getText();
            String isbn = isbnField.getText();
            int anno = Integer.parseInt(annoField.getText());

            catalogo.aggiungiLibro(new Libro(titolo, autore, isbn, anno));
            JOptionPane.showMessageDialog(frame, "📖 Libro aggiunto con successo!");
            mostraTuttiLibri();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "⚠️ Errore: Anno deve essere un numero!");
        }
    }

    private void cercaLibro() {
        String query = JOptionPane.showInputDialog(frame, "Inserisci titolo o autore da cercare:", "🔍 Cerca Libro", JOptionPane.QUESTION_MESSAGE);

        if (query == null || query.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "⚠️ Inserisci un termine valido per la ricerca!", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Libro> risultati = catalogo.cercaLibro(query.trim());
        if (risultati.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "📋 Nessun libro trovato per la ricerca: " + query, "Risultato", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "📚 Libro trovato!", "Risultato", JOptionPane.INFORMATION_MESSAGE);
            aggiornaTabella(risultati);
        }
    }

    private void mostraNascondiLibri() {
        if (tabellaMostrata) {
            // Nasconde tutti i libri (svuota la tabella)
            aggiornaTabella(List.of());
            tabellaMostrata = false;
        } else {
            // Mostra tutti i libri nel catalogo
            mostraTuttiLibri();
            tabellaMostrata = true;
        }
    }

    private void mostraTuttiLibri() {
        aggiornaTabella(catalogo.getLibri());
    }

    private void rimuoviLibro() {
        String isbn = isbnField.getText();
        if (catalogo.rimuoviLibro(isbn)) {
            JOptionPane.showMessageDialog(frame, "🗑️ Libro rimosso con successo!");
            mostraTuttiLibri();
        } else {
            JOptionPane.showMessageDialog(frame, "⚠️ Errore: ISBN non trovato!");
        }
    }

    private void aggiornaTabella(List<Libro> libri) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Libro libro : libri) {
            model.addRow(new Object[]{
                    libro.getTitolo(),
                    libro.getAutore(),
                    libro.getIsbn(),
                    libro.getAnnoPubblicazione()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LibreriaGUI::new);
    }
}
