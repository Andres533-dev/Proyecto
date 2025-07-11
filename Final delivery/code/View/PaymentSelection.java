package Proyecto.Code.src.View;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class PaymentSelection extends Create {
    private Selection selection;
    public ArrayList<JButton> buttons;
    private double price;

    public PaymentSelection() throws IOException {
        String[] labelsText = {"Select a payment method", "Credit Card", "Cash"};
        this.selection = new Selection(labelsText);
        super("Payment Selection");
        this.makeListeners();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public JPanel createPanel() throws IOException {
        return selection.setUpPanel();
    }

    public void makeListeners() {
        buttons = selection.buttons;

        // Credit Card button listener
        this.buttons.get(0).addActionListener(e -> {
            try {
                // Pass the price to credit card payment
                CreditPayment creditCardPayment = new CreditPayment(price);
                creditCardPayment.setPrice(price);
                Create.showPanel("Credit Card Payment");
            } catch (Exception ex) {
                System.out.println("Error in PaymentSelection (Credit Card): " + ex.getMessage());
            }
        });

        // Cash button listener
        this.buttons.get(1).addActionListener(e -> {
            try {
                // Pass the price to cash payment
                CashPayment cashPayment = new CashPayment(price);
                cashPayment.setPrice(price);
                Create.showPanel("Cash Payment");
            } catch (Exception ex) {
                System.out.println("Error in PaymentSelection (Cash): " + ex.getMessage());
            }
        });
    }
}