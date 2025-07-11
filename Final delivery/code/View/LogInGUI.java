package Proyecto.Code.src.View;

import Proyecto.Code.src.Controler.LogInController;
import Proyecto.Code.src.Model.User;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class LogInGUI extends Create{
    private Form form;

    public LogInGUI() throws IOException {
        String[] labelTexts = new String[]{"Mail", "Password"};
        this.form = new Form(labelTexts);
        super("Log In");
        this.makeListeners();
    }

    @Override
    protected JPanel createPanel() {
        return form.setUpPanel();
    }

    public void makeListeners(){
        form.backButton.addActionListener(e->{
            try{
                Create.showPanel("Welcome");
            }
            catch (Exception ex){
                System.out.println("Se ha presentado el error: " + ex.getMessage());
            }
        });

        form.submitButton.addActionListener(e->{
            try{
                ArrayList<String>answers = form.getFormData();
                LogInController logIn = new LogInController(answers);
                int success=logIn.success;
                if(success==0){
                    JOptionPane.showMessageDialog(null,"There is no information");
                }
                else if(success==1){
                    JOptionPane.showMessageDialog(null,"The information´format is wrong");
                }
                else if(success==2) {
                    JOptionPane.showMessageDialog(null,"The Password doesnt have the correct format");
                }
                else if(success==3) {
                    JOptionPane.showMessageDialog(null,"The Information doesnt match with a existing user ");
                }
                else if(success==4) {
                    JOptionPane.showMessageDialog(null,"The log in has been successful ");
                    // Crear el usuario con la información del login y pasarlo a DirectionsElections
                    User user = new User(answers.get(0), answers.get(1));
                    new DirectionsElections(user);
                    Create.showPanel("Direction election");
                }
            }
            catch (Exception ex){
                System.out.println("Se ha presentado el error en log in: " + ex.getMessage());
            }
        });
    }
}

    /*
    public String[] getData() {
        return form.getFormData();
    }
    public JButton getSubmitButton() {
        return form.button;
    }
    a
     */


