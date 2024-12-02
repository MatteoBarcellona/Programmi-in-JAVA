import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {
    private static Biblioteca biblioteca;

    // GUI Components
    private static JFrame frame;
    private static JTextArea textAreaLibri;
    private static JTextArea textAreaUtenti;
    private static JTextArea textAreaPrestiti;
    private static JTextField txtTitolo, txtAutore, txtAnno, txtGenere, txtEmail, txtNome, txtCognome;
    private static JComboBox<Libro> comboLibri, comboLibriRimuovi;

    public static void main(String[] args) {
        biblioteca = new Biblioteca();
        frame = new JFrame("Gestione Biblioteca");
        frame.setSize(1000, 600); // Ingrandito per una visualizzazione migliore
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel navPanel = new JPanel(new GridLayout(1, 4));
        navPanel.setBackground(new Color(230, 230, 250)); // Colore di sfondo più soft

        JButton btnLibri = new JButton("Gestione Libri");
        JButton btnUtenti = new JButton("Gestione Utenti");
        JButton btnPrestiti = new JButton("Gestione Prestiti");
        JButton btnReport = new JButton("Report");

        navPanel.add(btnLibri);
        navPanel.add(btnUtenti);
        navPanel.add(btnPrestiti);
        navPanel.add(btnReport);

        frame.add(navPanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new CardLayout());
        JPanel gestioneLibriPanel = creaGestioneLibriPanel();
        JPanel gestioneUtentiPanel = creaGestioneUtentiPanel();
        JPanel gestionePrestitiPanel = creaGestionePrestitiPanel();

        mainPanel.add(gestioneLibriPanel, "Libri");
        mainPanel.add(gestioneUtentiPanel, "Utenti");
        mainPanel.add(gestionePrestitiPanel, "Prestiti");

        frame.add(mainPanel, BorderLayout.CENTER);

        btnLibri.addActionListener(e -> switchPanel(mainPanel, "Libri"));
        btnUtenti.addActionListener(e -> switchPanel(mainPanel, "Utenti"));
        btnPrestiti.addActionListener(e -> switchPanel(mainPanel, "Prestiti"));
        btnReport.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Sezione Report non ancora implementata."));

        frame.setVisible(true);
    }

    private static JPanel creaGestioneLibriPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel panelAggiungi = new JPanel(new GridLayout(5, 2, 10, 10));
        panelAggiungi.setBackground(new Color(230, 230, 250));

        panelAggiungi.add(new JLabel("Titolo:"));
        txtTitolo = new JTextField();
        panelAggiungi.add(txtTitolo);

        panelAggiungi.add(new JLabel("Autore:"));
        txtAutore = new JTextField();
        panelAggiungi.add(txtAutore);

        panelAggiungi.add(new JLabel("Anno:"));
        txtAnno = new JTextField();
        panelAggiungi.add(txtAnno);

        panelAggiungi.add(new JLabel("Genere:"));
        txtGenere = new JTextField();
        panelAggiungi.add(txtGenere);

        JButton btnAggiungi = new JButton("Aggiungi Libro");
        btnAggiungi.addActionListener(e -> aggiungiLibro());
        panelAggiungi.add(btnAggiungi);

        panel.add(panelAggiungi, BorderLayout.NORTH);

        textAreaLibri = new JTextArea(10, 50);
        textAreaLibri.setEditable(false);
        panel.add(new JScrollPane(textAreaLibri), BorderLayout.CENTER);

        JPanel panelRimuovi = new JPanel(new GridLayout(2, 2, 10, 10));
        panelRimuovi.setBackground(new Color(230, 230, 250));

        panelRimuovi.add(new JLabel("Seleziona Libro da Rimuovere:"));
        comboLibriRimuovi = new JComboBox<>();
        panelRimuovi.add(comboLibriRimuovi);

        JButton btnRimuovi = new JButton("Rimuovi Libro");
        btnRimuovi.addActionListener(e -> rimuoviLibro());
        panelRimuovi.add(btnRimuovi);

        panel.add(panelRimuovi, BorderLayout.SOUTH);

        return panel;
    }

    private static JPanel creaGestioneUtentiPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel panelAggiungi = new JPanel(new GridLayout(4, 2, 10, 10));
        panelAggiungi.setBackground(new Color(230, 230, 250));

        panelAggiungi.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panelAggiungi.add(txtNome);

        panelAggiungi.add(new JLabel("Cognome:"));
        txtCognome = new JTextField();
        panelAggiungi.add(txtCognome);

        panelAggiungi.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panelAggiungi.add(txtEmail);

        JButton btnAggiungi = new JButton("Aggiungi Utente");
        btnAggiungi.addActionListener(e -> aggiungiUtente());
        panelAggiungi.add(btnAggiungi);

        panel.add(panelAggiungi, BorderLayout.NORTH);

        textAreaUtenti = new JTextArea(10, 50);
        textAreaUtenti.setEditable(false);
        panel.add(new JScrollPane(textAreaUtenti), BorderLayout.CENTER);

        return panel;
    }

    private static JPanel creaGestionePrestitiPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel panelPrestito = new JPanel(new GridLayout(2, 2, 10, 10));
        panelPrestito.setBackground(new Color(230, 230, 250));

        panelPrestito.add(new JLabel("Seleziona Libro:"));
        comboLibri = new JComboBox<>();
        panelPrestito.add(comboLibri);

        JButton btnPrestito = new JButton("Effettua Prestito");
        btnPrestito.addActionListener(e -> effettuaPrestito());
        panelPrestito.add(btnPrestito);

        panel.add(panelPrestito, BorderLayout.NORTH);

        textAreaPrestiti = new JTextArea(10, 50);
        textAreaPrestiti.setEditable(false);
        panel.add(new JScrollPane(textAreaPrestiti), BorderLayout.CENTER);

        return panel;
    }

    private static void aggiungiLibro() {
        String titolo = txtTitolo.getText().trim();
        String autore = txtAutore.getText().trim();
        String annoStr = txtAnno.getText().trim();
        String genere = txtGenere.getText().trim();

        if (titolo.isEmpty() || autore.isEmpty() || annoStr.isEmpty() || genere.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Tutti i campi sono obbligatori.");
            return;
        }

        try {
            int anno = Integer.parseInt(annoStr);
            Libro libro = new Libro(titolo, autore, anno, genere);
            biblioteca.aggiungiLibro(libro);
            aggiornaListaLibri();
            JOptionPane.showMessageDialog(frame, "Libro aggiunto con successo!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "L'anno deve essere un numero valido.");
        }
    }

    private static void rimuoviLibro() {
        Libro libro = (Libro) comboLibriRimuovi.getSelectedItem();
        if (libro != null) {
            biblioteca.rimuoviLibro(libro);
            aggiornaListaLibri();
            JOptionPane.showMessageDialog(frame, "Libro rimosso con successo!");
        } else {
            JOptionPane.showMessageDialog(frame, "Seleziona un libro valido.");
        }
    }

    private static void aggiungiUtente() {
        String nome = txtNome.getText().trim();
        String cognome = txtCognome.getText().trim();
        String email = txtEmail.getText().trim();

        if (nome.isEmpty() || cognome.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Tutti i campi sono obbligatori.");
            return;
        }

        Utente utente = new Utente(nome, cognome, email);
        biblioteca.registraUtente(utente);
        aggiornaListaUtenti();
        JOptionPane.showMessageDialog(frame, "Utente aggiunto con successo!");
    }

    private static void effettuaPrestito() {
        Libro libro = (Libro) comboLibri.getSelectedItem();
        if (libro == null || biblioteca.getUtenti().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Non ci sono libri o utenti disponibili.");
            return;
        }

        Utente utente = biblioteca.getUtenti().get(0);
        if (biblioteca.prestitoLibro(libro, utente)) {
            aggiornaListaPrestiti();
            aggiornaListaLibri();
            JOptionPane.showMessageDialog(frame, "Prestito effettuato con successo!");
        } else {
            JOptionPane.showMessageDialog(frame, "Prestito non riuscito.");
        }
    }

    private static void aggiornaListaLibri() {
        textAreaLibri.setText("");
        comboLibri.removeAllItems();
        comboLibriRimuovi.removeAllItems();

        for (Libro libro : biblioteca.getLibri()) {
            textAreaLibri.append(libro.toString() + "\n");
            comboLibri.addItem(libro);
            comboLibriRimuovi.addItem(libro);
        }
    }

    private static void aggiornaListaUtenti() {
        textAreaUtenti.setText("");
        for (Utente utente : biblioteca.getUtenti()) {
            textAreaUtenti.append(utente.toString() + "\n");
        }
    }

    private static void aggiornaListaPrestiti() {
        textAreaPrestiti.setText("");
        for (Prestito prestito : biblioteca.getPrestiti()) {
            textAreaPrestiti.append(prestito.toString() + "\n");
        }
    }

    private static void switchPanel(JPanel mainPanel, String cardName) {
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, cardName);
    }
}
