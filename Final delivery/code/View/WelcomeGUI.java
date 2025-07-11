package Proyecto.Code.src.View;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class WelcomeGUI extends Create{
    private Selection selection;
    public ArrayList<JButton> buttons;
    private String[] labelTexts;
    public WelcomeGUI() throws IOException {
        String[] labelsText = {"Welcome", "Sign Up", "Log In"};
        this.selection =new Selection(labelsText);
        super("Welcome");
        this.makeListener();
        // Texto para el label y botones

    }
    @Override
    public JPanel createPanel() {
        return selection.setUpPanel();
    }


    public void makeListener(){
        buttons= selection.buttons;
        this.buttons.get(0).addActionListener(e->{
            try{
                Create.showPanel("Sign Up");
            }
            catch (Exception ex){
                System.out.println("Se ha presentado el error en Welcome: " + ex.getMessage());
            }
        });

        this.buttons.get(1).addActionListener(e->{
            try{
                Create.showPanel("Log In");
            }
            catch (Exception ex){
                System.out.println("Se ha presentado el error en Welcome: " + ex.getMessage());
            }
        });
    }


}