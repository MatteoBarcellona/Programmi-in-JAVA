import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class PrenotazioneGUI {

    private SistemaPrenotazioni sistema;
    private JFrame frame;
    private JTextArea areaTesto;
    private JPanel panelCentro;
    private JPanel panelCalendar;

    public PrenotazioneGUI(SistemaPrenotazioni sistema) {
        this.sistema = sistema;

        // Creazione della finestra principale
        frame = new JFrame("Sistema Prenotazione Voli");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Centra la finestra

        // Layout generale
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(0xF1F1F1));  // Colore di sfondo chiaro

        // Pannello laterale con i bottoni
        JPanel panelMenu = createMenuPanel();
        frame.add(panelMenu, BorderLayout.WEST);

        // Area centrale con calendario e area di testo
        panelCentro = new JPanel(new BorderLayout());

        // Creazione area informazioni con altezza aumentata
        areaTesto = new JTextArea();
        areaTesto.setEditable(false);
        areaTesto.setBackground(new Color(0xE8F6F3)); // Colore chiaro per la zona di testo
        areaTesto.setFont(new Font("Arial", Font.PLAIN, 14));
        areaTesto.setBorder(BorderFactory.createTitledBorder("Informazioni"));

        // Scroll per l'area di testo
        JScrollPane scrollText = new JScrollPane(areaTesto);
        scrollText.setPreferredSize(new Dimension(0, 200));  // Altezza aumentata a 200px

        // Pannello per il calendario dei voli
        panelCalendar = createVoloCalendar();
        JScrollPane scrollCalendar = new JScrollPane(panelCalendar);
        scrollCalendar.setBorder(BorderFactory.createTitledBorder("Calendario Voli"));

        // Aggiunta al pannello centrale
        panelCentro.add(scrollCalendar, BorderLayout.CENTER);
        panelCentro.add(scrollText, BorderLayout.SOUTH);

        frame.add(panelCentro, BorderLayout.CENTER);

        // Aggiungi footer con "Fatto da Matteo"
        JPanel footerPanel = createFooterPanel();
        frame.add(footerPanel, BorderLayout.SOUTH);

        // Mostra la finestra
        frame.setVisible(true);
    }


    private JPanel createMenuPanel() {
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
        panelMenu.setBackground(new Color(0x0077B6));  // Blu chiaro per il menu laterale
        panelMenu.setPreferredSize(new Dimension(230, 0));

        // Pulsanti del menu
        JButton btnGestioneVoli = createMenuButton("Gestione Voli");
        JButton btnPrenotazioni = createMenuButton("Gestione Prenotazioni");
        JButton btnRicercaVoli = createMenuButton("Ricerca Voli");
        JButton btnEsportaVoli = createMenuButton("Esporta Voli");
        JButton btnEsportaPrenotazioni = createMenuButton("Esporta Prenotazioni");

        // Aggiungi l'azione ai pulsanti di esportazione
        btnEsportaVoli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistema.esportaVoli();  // Chiama il metodo di esportazione dei voli
            }
        });

        btnEsportaPrenotazioni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistema.esportaPrenotazioni();  // Chiama il metodo di esportazione delle prenotazioni
            }
        });

        panelMenu.add(Box.createVerticalStrut(20)); // Spaziatura iniziale
        panelMenu.add(btnGestioneVoli);
        panelMenu.add(Box.createVerticalStrut(15)); // Distanza tra i pulsanti
        panelMenu.add(btnPrenotazioni);
        panelMenu.add(Box.createVerticalStrut(15)); // Distanza tra i pulsanti
        panelMenu.add(btnRicercaVoli);
        panelMenu.add(Box.createVerticalStrut(15)); // Distanza tra i pulsanti
        panelMenu.add(btnEsportaVoli);  // Aggiungi il pulsante per esportare i voli
        panelMenu.add(Box.createVerticalStrut(15)); // Distanza tra i pulsanti
        panelMenu.add(btnEsportaPrenotazioni); // Aggiungi il pulsante per esportare le prenotazioni

        return panelMenu;
    }


    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(0x0096C7));  // Blu scuro per il bottone
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setMaximumSize(new Dimension(230, 50));  // Larghezza e altezza uniformi

        // Aggiungi effetto hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0x00B4D8)); // Colore più chiaro al passaggio
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0x0096C7)); // Torna al colore originale
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.equals("Gestione Voli")) {
                    gestioneVoli();
                } else if (text.equals("Gestione Prenotazioni")) {
                    gestionePrenotazioni();
                } else {
                    ricercaVoli();
                }
            }
        });

        return button;
    }

    private void gestioneVoli() {
        String codiceVolo = JOptionPane.showInputDialog(frame, "Codice Volo:", "Aggiungi Volo", JOptionPane.PLAIN_MESSAGE);
        String destinazione = JOptionPane.showInputDialog(frame, "Destinazione:", "Aggiungi Volo", JOptionPane.PLAIN_MESSAGE);
        String dataStr = JOptionPane.showInputDialog(frame, "Data (gg/MM/yyyy):", "Aggiungi Volo", JOptionPane.PLAIN_MESSAGE);

        // Validazione della data
        if (isValidDate(dataStr)) {
            // Se la data è valida, procedi con la creazione del volo
            int postiMax = Integer.parseInt(JOptionPane.showInputDialog(frame, "Posti Massimi:", "Aggiungi Volo", JOptionPane.PLAIN_MESSAGE));

            // Verifica che il numero di posti sia positivo e maggiore di zero
            if (postiMax <= 0) {
                JOptionPane.showMessageDialog(frame, "Errore: Il numero di posti massimi deve essere maggiore di zero.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Aggiungi il volo al sistema
            sistema.aggiungiVolo(codiceVolo, destinazione, convertToDate(dataStr), postiMax);

            // Messaggio di successo
            JOptionPane.showMessageDialog(frame, "Volo aggiunto con successo!", "Successo", JOptionPane.INFORMATION_MESSAGE);
            aggiornaVistaVoli();  // Aggiorna la vista per mostrare i voli disponibili
        } else {
            JOptionPane.showMessageDialog(frame, "Errore: Data non valida! Assicurati che sia nel formato dd/MM/yyyy e non nel passato.", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }





    private boolean isValidDate(String dataStr) {
        // Verifica formato della data
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);  // Disabilita la tolleranza per date non valide come 32/13/2024
        try {
            Date date = format.parse(dataStr);
            // Verifica che la data non sia nel passato
            if (date.before(new Date())) {
                return false;  // La data è nel passato
            }
            return true;
        } catch (ParseException e) {
            return false;  // Il formato della data non è valido
        }
    }

    private Date convertToDate(String dataStr) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.parse(dataStr);
        } catch (ParseException e) {
            return null;  // Restituisce null in caso di errore
        }
    }

    private boolean isValidPosti(int posti) {
        // Verifica che il numero di posti sia positivo
        return posti > 0;
    }

    private void gestionePrenotazioni() {
        // Ottieni l'ID dell'utente
        int idUtente = Integer.parseInt(JOptionPane.showInputDialog(frame, "ID Utente:", "Prenotazione", JOptionPane.PLAIN_MESSAGE));
        // Ottieni il codice del volo
        String codiceVolo = JOptionPane.showInputDialog(frame, "Codice Volo:", "Prenotazione", JOptionPane.PLAIN_MESSAGE);
        // Ottieni il numero di posti da prenotare
        int posti = Integer.parseInt(JOptionPane.showInputDialog(frame, "Posti da prenotare:", "Prenotazione", JOptionPane.PLAIN_MESSAGE));

        // Verifica che il numero di posti sia valido (positivo)
        if (posti <= 0) {
            JOptionPane.showMessageDialog(frame, "Errore: Il numero di posti deve essere maggiore di zero.", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ottieni il volo con il codice fornito
        Volo volo = sistema.getVolo(codiceVolo);

        // Controlla se il volo esiste
        if (volo == null) {
            JOptionPane.showMessageDialog(frame, "Errore: Il volo con il codice inserito non esiste.", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Controlla se ci sono abbastanza posti disponibili
        if (volo.getPostiDisponibili() < posti) {
            JOptionPane.showMessageDialog(frame, "Errore: Non ci sono abbastanza posti disponibili.", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Procedi con la prenotazione
        sistema.prenotarePosti(idUtente, codiceVolo, posti);

        // Messaggio di successo
        JOptionPane.showMessageDialog(frame, "Prenotazione effettuata con successo per il volo: " + codiceVolo, "Successo", JOptionPane.INFORMATION_MESSAGE);
        areaTesto.append("Prenotazione effettuata per il volo: " + codiceVolo + " con " + posti + " posti.\n");
    }


    private void ricercaVoli() {
        String destinazione = JOptionPane.showInputDialog(frame, "Inserisci destinazione:", "Ricerca Volo", JOptionPane.PLAIN_MESSAGE);
        JCheckBox disponibilitaCheckBox = new JCheckBox("Solo voli con posti disponibili");

        // Mostra la checkbox per il filtro di disponibilità
        int option = JOptionPane.showConfirmDialog(frame, disponibilitaCheckBox, "Filtra per disponibilità", JOptionPane.OK_CANCEL_OPTION);

        areaTesto.setText("");  // Pulisci l'area di testo

        for (Volo volo : sistema.getVoliDisponibili()) {
            // Se il filtro è selezionato, mostra solo i voli con posti disponibili
            if (disponibilitaCheckBox.isSelected()) {
                if (volo.getPostiDisponibili() > 0) {
                    areaTesto.append(volo.toString() + "\n");
                }
            } else {
                if (volo.getDestinazione().equalsIgnoreCase(destinazione)) {
                    areaTesto.append(volo.toString() + "\n");
                }
            }
        }
    }


    private JPanel createVoloCalendar() {
        JPanel panelCalendar = new JPanel();
        panelCalendar.setLayout(new BoxLayout(panelCalendar, BoxLayout.Y_AXIS));
        panelCalendar.setBackground(Color.WHITE);
        return panelCalendar;
    }

    private void aggiornaVistaVoli() {
        sistema.ordinaVoliPerData(); // Ordina prima i voli per data
        panelCalendar.removeAll();  // Rimuovi tutti gli attuali voli nella vista

        int rowColorToggle = 0;
        for (Volo volo : sistema.getVoliDisponibili()) {
            JPanel row = new JPanel(new BorderLayout());
            row.setBackground(rowColorToggle % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
            row.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            JLabel label = new JLabel(volo.toString(), JLabel.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            row.add(label, BorderLayout.CENTER);
            panelCalendar.add(row);
            rowColorToggle++;
        }

        panelCalendar.revalidate();
        panelCalendar.repaint();
    }





    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.BLACK);
        footerPanel.setPreferredSize(new Dimension(0, 30)); // Altezza 30px
        JLabel footerLabel = new JLabel("Fatto da Matteo");
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        footerPanel.setLayout(new BorderLayout());
        footerPanel.add(footerLabel, BorderLayout.CENTER);
        return footerPanel;
    }



    public static void main(String[] args) {
        SistemaPrenotazioni sistema = new SistemaPrenotazioni();
        PrenotazioneGUI gui = new PrenotazioneGUI(sistema);
    }
}
