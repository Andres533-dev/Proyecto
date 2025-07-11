package Proyecto.Code.src.View;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CashPayment extends Create {
    private Selection selection;
    private double price;

    public CashPayment(double price) throws IOException {
        this.price = price;
        String[] labelsText = {"Please give to the driver the cash corresponding to: $" + String.format("%.2f", price), "Continue"};
        this.selection = new Selection(labelsText);
        super("Cash Payment");
        this.makeListeners();
    }

    @Override
    protected JPanel createPanel() throws IOException {
        return selection.setUpPanel();
    }

    private void makeListeners() {
        selection.buttons.get(0).addActionListener(e -> {
            try {
                // Navigate to confirmation or next screen
                Create.showPanel("Payment Confirmation");
            } catch (Exception ex) {
                System.out.println("Error continuing from cash payment: " + ex.getMessage());
                JOptionPane.showMessageDialog(null,
                        "Error processing payment",
                        "Payment Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void setPrice(double price) {
        this.price = price;
        // Update the label text if price changes
        JLabel instructionLabel = (JLabel) selection.setUpPanel().getComponent(0);
        instructionLabel.setText("Please give to the driver the cash corresponding to: $" + String.format("%.2f", price));
    }
}