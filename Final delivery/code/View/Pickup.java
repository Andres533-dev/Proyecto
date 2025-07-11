package Proyecto.Code.src.View;

import Proyecto.Code.src.Controler.DirectionController;
import Proyecto.Code.src.Controler.DirectionTypeController;
import Proyecto.Code.src.Model.User;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Pickup extends Create {
    private Form form;
    protected boolean succesful;
    private User user;

    public Pickup(User user) throws IOException {
        this.user = user;
        DirectionTypeController dc = new DirectionTypeController();
        String[] labelTexts = dc.typeDirectionLabels();
        form = new Form(labelTexts);
        super("Pick Up");
        this.succesful = false;
        this.makeListeners(labelTexts);
    }

    @Override
    public JPanel createPanel() {
        return form.setUpPanel();
    }

    public void makeListeners(String[] labelTexts) {
        form.backButton.addActionListener(e -> {
            try {
                Create.showPanel("Direction election");
            } catch (Exception ex) {
                System.out.println("Error al ingresar dirección: " + ex.getMessage());
            }
        });

        form.submitButton.addActionListener(e -> {
            try {
                ArrayList<String> answers = form.getFormData();
                DirectionController directionsController = new DirectionController(answers, labelTexts, user, "Pickup");
                int result = directionsController.correctDirection;
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "The address is incorrect");
                } else if (result == 1) {
                    JOptionPane.showMessageDialog(null, "The career and the house number is incorrect");
                }
                else if (result == 2) {
                    JOptionPane.showMessageDialog(null, "The house number is incorrect");
                }
                else if (result == 3) {
                    JOptionPane.showMessageDialog(null, "The address has been added");
                    this.succesful = true;
                    form.submitButton.setEnabled(false);
                }
            } catch (Exception ex) {
                System.out.println("Error adding the adress: " + ex.getMessage());
            }
        });
    }
}
