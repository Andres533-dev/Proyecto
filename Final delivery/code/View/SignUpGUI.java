package Proyecto.Code.src.View;

import Proyecto.Code.src.Controler.SignUpController;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class SignUpGUI extends Create{
    private Form form;

    public SignUpGUI() throws IOException {
        String[] labelTexts = new String[]{"Name", "Last Name", "Mail", "Password"};
        this.form = new Form(labelTexts);
        super("Sign Up");
        this.makeListener();

    }
    @Override
    public JPanel createPanel() {
        return form.setUpPanel();
    }

    public void makeListener(){
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
                ArrayList<String>answers =form.getFormData();
                SignUpController sign =new SignUpController(answers);
                int success=sign.success;
                if(success==0){
                    JOptionPane.showMessageDialog(null,"There is no information");
                }
                else if(success==1){
                    JOptionPane.showMessageDialog(null,"The information´format is wrong");
                }
                else if(success==2) {
                    JOptionPane.showMessageDialog(null,"The Last name, Mail and Password doesnt have the correct format");
                }
                else if(success==3) {
                    JOptionPane.showMessageDialog(null,"The Mail and Password doesnt have the correct format");
                }
                else if(success==4) {
                    JOptionPane.showMessageDialog(null,"The Password doesnt have the correct format");
                }
                else if(success==5) {
                    JOptionPane.showMessageDialog(null,"The User already exists,pleas log in ");
                }
                else if(success==6) {
                    JOptionPane.showMessageDialog(null,"The sign up has been successful ");
                }
            }
            catch (Exception ex){
                System.out.println("Se ha presentado el error en sign up: " + ex.getMessage());
            }
        });
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
}
