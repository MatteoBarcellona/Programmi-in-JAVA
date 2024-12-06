import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCartApp {
    private ShoppingCart cart;
    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel totalLabel;
    private JLabel discountLabel;

    public ShoppingCartApp() {
        cart = new ShoppingCart();
        initializeUI();
    }

    private void initializeUI() {
        JFrame frame = new JFrame("Carrello della Spesa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Table for displaying products
        tableModel = new DefaultTableModel(new String[]{"Nome", "Prezzo Unitario", "Quantità", "Totale"}, 0);
        table = new JTable(tableModel);

        // Input fields
        JTextField nameField = new JTextField(10);
        JTextField priceField = new JTextField(10);
        JTextField quantityField = new JTextField(10);

        // Buttons
        JButton addButton = new JButton("Aggiungi");
        JButton removeButton = new JButton("Rimuovi");
        JButton updateButton = new JButton("Modifica Quantità");
        JButton clearButton = new JButton("Svuota Carrello");

        // Labels
        totalLabel = new JLabel("Totale: 0.00€");
        discountLabel = new JLabel("Totale con Sconto: 0.00€");

        // Panel for inputs
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Prezzo:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Quantità:"));
        inputPanel.add(quantityField);
        inputPanel.add(addButton);

        // Add action listeners
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());
            cart.addProduct(new Product(name, price, quantity));
            refreshTable();
        });

        removeButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Nome del prodotto da rimuovere:");
            cart.removeProduct(name);
            refreshTable();
        });

        updateButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Nome del prodotto da modificare:");
            int quantity = Integer.parseInt(JOptionPane.showInputDialog("Nuova quantità:"));
            cart.updateProductQuantity(name, quantity);
            refreshTable();
        });

        clearButton.addActionListener(e -> {
            cart = new ShoppingCart();
            refreshTable();
        });

        // Layout
        JPanel controlPanel = new JPanel();
        controlPanel.add(removeButton);
        controlPanel.add(updateButton);
        controlPanel.add(clearButton);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.add(totalLabel);
        bottomPanel.add(discountLabel);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.add(bottomPanel, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Product product : cart.getProducts()) {
            tableModel.addRow(new Object[]{product.getName(), product.getUnitPrice(), product.getQuantity(), product.getTotalPrice()});
        }
        totalLabel.setText("Totale: " + cart.calculateTotal() + "€");
        discountLabel.setText("Totale con Sconto: " + cart.applyDiscount() + "€");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShoppingCartApp::new);
    }
}
