import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;

public class MainFrame extends JFrame {
    private Login login;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private Torneo torneo;
    private Squadra squadra;
    private Partita partita;
    private boolean isAdmin;

    public MainFrame() {
        login = new Login();
        torneo = new Torneo();

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        setTitle("Gestione Torneo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardPanel.add(createLoginPanel(), "Login");
        cardPanel.add(createMainPanel(), "Main");

        getContentPane().add(cardPanel);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Accedi");

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (login.verificaAccesso(username, password)) {
                    isAdmin = login.isAdmin(username);
                    if (isAdmin) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Benvenuto Admin!");
                    } else {
                        JOptionPane.showMessageDialog(MainFrame.this, "Benvenuto Utente!");
                    }
                    cardLayout.show(cardPanel, "Main");  // Correzione: usa cardPanel per la navigazione
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this, "Credenziali errate");
                }
            }
        });

        return loginPanel;
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Benvenuti nella gestione del Torneo", SwingConstants.CENTER);
        mainPanel.add(label, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Aggiungi il pannello di gestione delle squadre
        tabbedPane.addTab("Gestione Squadre", createSquadrePanel());

        // Aggiungi il pannello delle partite e classifica
        tabbedPane.addTab("Partite e Classifica", createPartiteClassificaPanel());

        // Aggiungi il pannello di report
        tabbedPane.addTab("Report", createReportPanel());

        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        // Pulsante per fare il logout
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostra il pannello di login e resetta eventuali dati
                cardLayout.show(cardPanel, "Login");  // Correzione: usa cardPanel per la navigazione
            }
        });
        mainPanel.add(logoutButton, BorderLayout.SOUTH);

        return mainPanel;
    }

    // Pannello per la gestione delle squadre
    // Pannello per la gestione delle squadre
    private JPanel createSquadrePanel() {
        JPanel squadrePanel = new JPanel();
        squadrePanel.setLayout(new BorderLayout());

        // Lista di squadre
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> squadreList = new JList<>(model);
        squadrePanel.add(new JScrollPane(squadreList), BorderLayout.CENTER);

        // Pannello per aggiungere, modificare ed eliminare squadre
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new GridLayout(1, 4));  // Aggiungi spazio per il nuovo pulsante

        JButton addButton = new JButton("Aggiungi Squadra");
        JButton modifyButton = new JButton("Modifica Squadra");
        JButton removeButton = new JButton("Elimina Squadra");
        JButton infoButton = new JButton("Visualizza Info");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Inserisci nome della squadra:");
                if (nome != null && !nome.isEmpty()) {
                    String logoSquadra = "";
                    int numg=0;
                    Squadra squadra = new Squadra(nome, logoSquadra, numg);
                    torneo.aggiungiSquadra(squadra);
                    model.addElement(squadra.getNome());
                }
            }
        });

        // Modifica del pulsante "Modifica Squadra"
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSquadra = squadreList.getSelectedValue();
                if (selectedSquadra != null) {
                    // Chiedi il nuovo nome della squadra
                    String nuovoNome = JOptionPane.showInputDialog("Nuovo nome della squadra:", selectedSquadra);
                    if (nuovoNome != null && !nuovoNome.isEmpty()) {
                        // Modifica il nome della squadra nella lista
                        for (Squadra squadra : torneo.getSquadre()) {
                            if (squadra.getNome().equals(selectedSquadra)) {
                                squadra.setNome(nuovoNome);  // Aggiorna il nome della squadra
                                break;
                            }
                        }

                        // Aggiorna anche la JList, rimuovendo l'elemento precedente e aggiungendo quello nuovo
                        model.removeElement(selectedSquadra);  // Rimuovi la vecchia squadra dalla lista
                        model.addElement(nuovoNome);  // Aggiungi la nuova squadra
                        squadreList.setSelectedValue(nuovoNome, true);  // Seleziona la nuova squadra
                    }
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSquadra = squadreList.getSelectedValue();
                if (selectedSquadra != null) {
                    // Elimina la squadra
                    for (Squadra squadra : torneo.getSquadre()) {
                        if (squadra.getNome().equals(selectedSquadra)) {
                            torneo.rimuoviSquadra(squadra);
                            break;
                        }
                    }
                    model.removeElement(selectedSquadra);
                }
            }
        });

        // Visualizza informazioni della squadra selezionata
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSquadra = squadreList.getSelectedValue();
                if (selectedSquadra != null) {
                    // Trova la squadra nel torneo
                    for (Squadra squadra : torneo.getSquadre()) {
                        if (squadra.getNome().equals(selectedSquadra)) {
                            // Mostra le informazioni in una finestra di dialogo
                            StringBuilder info = new StringBuilder();
                            info.append("Nome: ").append(squadra.getNome()).append("\n");
                            info.append("Giocatori:\n");
                            for (Giocatore giocatore : squadra.getGiocatori()) {
                                info.append("- ").append(giocatore.getNome()).append("\n");
                            }
                            JOptionPane.showMessageDialog(MainFrame.this, info.toString(), "Informazioni Squadra", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
                }
            }
        });

        actionsPanel.add(addButton);
        actionsPanel.add(modifyButton);
        actionsPanel.add(removeButton);  // Aggiungi il pulsante di rimozione della squadra
        actionsPanel.add(infoButton);  // Aggiungi il pulsante di visualizzazione informazioni

        squadrePanel.add(actionsPanel, BorderLayout.SOUTH);

        // Pannello per aggiungere e rimuovere giocatori
        JPanel playerActionsPanel = new JPanel();
        playerActionsPanel.setLayout(new GridLayout(1, 3));

        // Aggiungi Giocatore
        JButton addPlayerButton = new JButton("Aggiungi Giocatore");
        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeGiocatore = JOptionPane.showInputDialog("Inserisci nome del giocatore:");
                if (nomeGiocatore != null && !nomeGiocatore.isEmpty()) {
                    String selectedSquadra = squadreList.getSelectedValue();
                    if (selectedSquadra != null) {
                        for (Squadra squadra : torneo.getSquadre()) {
                            if (squadra.getNome().equals(selectedSquadra)) {
                                Giocatore nuovoGiocatore = new Giocatore(nomeGiocatore);
                                squadra.aggiungiGiocatore(nuovoGiocatore);
                                break;
                            }
                        }
                    }
                }
            }
        });

        // Rimuovi Giocatore
        JButton removePlayerButton = new JButton("Rimuovi Giocatore");
        removePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSquadra = squadreList.getSelectedValue();
                if (selectedSquadra != null) {
                    // Trova la squadra selezionata
                    for (Squadra squadra : torneo.getSquadre()) {
                        if (squadra.getNome().equals(selectedSquadra)) {
                            // Mostra una finestra per selezionare il giocatore da eliminare
                            String[] giocatoriNames = new String[squadra.getGiocatori().size()];
                            int index = 0;
                            for (Giocatore giocatore : squadra.getGiocatori()) {
                                giocatoriNames[index++] = giocatore.getNome();
                            }
                            String giocatoreDaRimuovere = (String) JOptionPane.showInputDialog(
                                    MainFrame.this,
                                    "Seleziona il giocatore da rimuovere:",
                                    "Rimuovi Giocatore",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    giocatoriNames,
                                    giocatoriNames[0]
                            );

                            if (giocatoreDaRimuovere != null) {
                                // Rimuovi il giocatore selezionato dalla squadra
                                squadra.rimuoviGiocatore(giocatoreDaRimuovere);
                                break;
                            }
                        }
                    }
                }
            }
        });

        playerActionsPanel.add(addPlayerButton);
        playerActionsPanel.add(removePlayerButton);

        squadrePanel.add(playerActionsPanel, BorderLayout.NORTH);

        return squadrePanel;
    }


    // Pannello per la gestione delle partite e della classifica
    private JPanel createPartiteClassificaPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crea una JTable per il calendario
        String[] colonne = {"Casa", "Ospite", "Gol Casa", "Gol Ospite"};
        DefaultTableModel tableModel = new DefaultTableModel(colonne, 0);
        JTable tabellaCalendario = new JTable(tableModel);

        // Riempire la tabella con le partite simulate
        JButton generaCalendarioButton = new JButton("Genera Calendario");
        generaCalendarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pulisci il modello precedente
                tableModel.setRowCount(0);

                // Genera le partite in base alle squadre nel torneo
                List<Partita> partite = torneo.generaCalendario();  // Torneo restituirà una lista di Partite, non String
                for (Partita partita : partite) {
                    tableModel.addRow(new Object[]{
                            partita.getSquadraCasa().getNome(),
                            partita.getSquadraTrasferta().getNome(),
                            partita.getGolCasa(),
                            partita.getGolTrasferta()
                    });
                }
            }
        });

        // Pulsante per simulare i risultati delle partite
        JButton simulaRisultatiButton = new JButton("Simula Risultati");
        simulaRisultatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    // Genera risultati casuali per le partite
                    int golCasa = (int) (Math.random() * 5);  // Genera gol casuali per la squadra di casa
                    int golOspite = (int) (Math.random() * 5);  // Genera gol casuali per la squadra ospite

                    tableModel.setValueAt(golCasa, i, 2);  // Aggiorna la colonna Gol Casa
                    tableModel.setValueAt(golOspite, i, 3);  // Aggiorna la colonna Gol Ospite

                    // Ottieni le squadre dalla tabella e aggiorna i risultati nel torneo
                    String squadraCasa = (String) tableModel.getValueAt(i, 0);
                    String squadraOspite = (String) tableModel.getValueAt(i, 1);
                    torneo.aggiornaRisultato(squadraCasa, squadraOspite, golCasa, golOspite);  // Aggiorna nel torneo
                }
            }
        });

        // Pulsante per scaricare il file
        JButton scaricaFileButton = new JButton("Scarica File");
        scaricaFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Chiamare il metodo per salvare il report in un file
                    torneo.salvaReportSuFile();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(panel, "Errore nel salvataggio del file: " + ex.getMessage());
                }
            }
        });


        // Aggiungi componenti al pannello
        panel.add(new JScrollPane(tabellaCalendario), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(generaCalendarioButton);
        buttonPanel.add(simulaRisultatiButton);
        buttonPanel.add(scaricaFileButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }


    // Pannello per il report
    private JPanel createReportPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea reportArea = new JTextArea("Report del Torneo");
        reportArea.setEditable(false);
        panel.add(new JScrollPane(reportArea), BorderLayout.CENTER);

        JButton exportButton = new JButton("Esporta Report");
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Esporta il report in un file CSV o testo
                torneo.generaReport();
            }
        });
        panel.add(exportButton, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }


    public void caricaDati() {
        try (BufferedReader reader = new BufferedReader(new FileReader("dati_torneo.txt"))) {
            String line;
            // Carica le squadre
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) { // Squadra
                    String nomeSquadra = data[0];
                    String nomelogo = data[0];
                    int numeroGiocatori = Integer.parseInt(data[1]);
                    Squadra squadra = new Squadra(nomeSquadra,nomelogo, numeroGiocatori);
                    torneo.aggiungiSquadra(squadra);
                } else if (data.length == 4) { // Partita
                    String squadraCasa = data[0];
                    String squadraOspite = data[1];
                    int golCasa = Integer.parseInt(data[2]);
                    int golOspite = Integer.parseInt(data[3]);

                    // Crea le squadre per la partita (se non esistono già)
                    Squadra casa = torneo.getSquadraByName(squadraCasa);
                    Squadra ospite = torneo.getSquadraByName(squadraOspite);

                    if (casa != null && ospite != null) {
                        Partita partita = new Partita(casa, ospite);
                        partita.setGolCasa(golCasa);
                        partita.setGolTrasferta(golOspite);
                        torneo.aggiungiPartita(partita);
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Dati caricati con successo!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore nel caricamento dei dati.");
        }
    }

    public void salvaDati() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dati_torneo.txt"))) {
            // Salva le squadre
            for (Squadra squadra : torneo.getSquadre()) {
                writer.write(squadra.getNome() + "," + squadra.getGiocatori() + "\n");
            }

            // Salva le partite
            for (Partita partita : torneo.getPartite()) {
                writer.write(partita.getSquadraCasa().getNome() + "," +
                        partita.getSquadraTrasferta().getNome() + "," +
                        partita.getGolCasa() + "," +
                        partita.getGolTrasferta() + "\n");
            }

            JOptionPane.showMessageDialog(null, "Dati salvati con successo!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore nel salvataggio dei dati.");
        }
    }
}
