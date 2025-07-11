package Proyecto.Code.src.Controler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/*
public class FormController {
    SwingUtilities.invokeLater(() -> {
        button.addActionListener(e -> {
            List<String> answers = new ArrayList<>();
            for (JTextField textField : fields) {
                answers.add(textField.getText());
            }
            JLabel email = new JLabel("Email");
            JLabel name = new JLabel("Name");
            JLabel typeRoad = new JLabel("Type of road");
            JLabel cardNumber = new JLabel("Card number");
            if (labels.getFirst().equals(email)) {
                try {
                    Login login = new Login(answers);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input.");
                }
            } else if (labels.getFirst().equals(name)) {
                try {
                    SignUp signUp = new SignUp(answers);
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input.");
                }
            } else if (labels.getFirst().equals(typeRoad)) {
                try {
                    int roadType = Integer.parseInt(answers.get(0));
                    int streetNumber = Integer.parseInt(answers.get(1));
                    int careerNumber = Integer.parseInt(answers.get(2));
                    int houseNumber = Integer.parseInt(answers.get(3));
                    Direction direction = new Direction(roadType, streetNumber, careerNumber, houseNumber);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input.");
                }
            } else if (labels.getFirst().equals(cardNumber)) {
                try {
                    CreditCard creditCard = new CreditCard(answers);
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input.");
                }
            }
        });
    });
}
*/