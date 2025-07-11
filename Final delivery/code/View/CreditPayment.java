package Proyecto.Code.src.View;

import Proyecto.Code.src.Controler.CreditPaymentController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class CreditPayment extends Create {
    private Form form;
    private double price;
    protected boolean successful;

    public CreditPayment(double price) throws IOException {
        this.price = price;
        this.successful = false;
        String[] labelTexts = new String[]{"Card Number", "Expiration Date", "CVV"};
        this.form = new Form(labelTexts);
        super("Credit Card Payment");
        this.makeListeners();
    }

    @Override
    protected JPanel createPanel() {
        return form.setUpPanel();
    }

    public void makeListeners() {
        form.backButton.addActionListener(e -> {
            try {
                Create.showPanel("Payment Selection");
            } catch (Exception ex) {
                System.out.println("Error going back: " + ex.getMessage());
            }
        });

        form.submitButton.addActionListener(e -> {
            try {
                ArrayList<String> paymentData = form.getFormData();
                CreditPaymentController validator=new CreditPaymentController(paymentData);
                int validationStatus=validator.validationStatus;

                if(validationStatus==0) {
                    JOptionPane.showMessageDialog(null, "All payment information is invalid or incomplete");
                }
                else if(validationStatus==1) {
                    JOptionPane.showMessageDialog(null, "All fields are filled but only card number is valid");
                }
                else if(validationStatus==2) {
                    JOptionPane.showMessageDialog(null,"CVV is invalid");
                }
                else if(validationStatus==3) {
                    JOptionPane.showMessageDialog(null, "Successful payment");
                }
                else if(validationStatus==4) {
                    JOptionPane.showMessageDialog(null,
                            "Payment processed successfully!\n" +
                                    "Amount: $" + String.format("%.2f", price));

                }
            } catch (Exception ex) {
                System.out.println("Error processing payment: " + ex.getMessage());
                JOptionPane.showMessageDialog(null,
                        "Error processing payment",
                        "Payment Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
