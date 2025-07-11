package Proyecto.Code.src.View;
import Proyecto.Code.src.Model.User;

import javax.swing.*;
import java.io.IOException;

public class DirectionsElections extends Create {
    private Selection choose;
    private Pickup pickup;
    private Arrive arrive;
    private User user;

    public DirectionsElections(User user) throws IOException {
        this.user = user;
        String[]labelText=new String[]{"Make a trip","Pickup","Arrive","Next"};
        choose=new Selection(labelText);
        super("Direction election");
        this.makeListener();
    }

    @Override
    protected JPanel createPanel() {
        return choose.setUpPanel();
    }

    public boolean isTripCompleted() {
        return pickup != null && pickup.succesful && arrive != null && arrive.succesful;
    }

    public void makeListener() {
        choose.buttons.get(0).addActionListener(e -> {
            try {
                if (pickup == null || !pickup.succesful) {
                    pickup = new Pickup(user);
                    Create.showPanel("Pick Up");
                }
            }
            catch (Exception ex) {
                System.out.println("There is an error in Direction elections at the moment to call Pick up: " + ex.getMessage());
            }
        });

        choose.buttons.get(1).addActionListener(e -> {
            try {
                if (arrive == null || !arrive.succesful) {
                    arrive = new Arrive(user);
                    Create.showPanel("Arrive");
                }
            } catch (Exception ex) {
                System.out.println("There is an error in Direction elections at the moment to call Arrive: " + ex.getMessage());
            }
        });

        choose.buttons.get(2).addActionListener(e -> {
            try{
                if(pickup != null && pickup.succesful && arrive != null && arrive.succesful){
                    new DriverSelection(user);
                    Create.showPanel("Driver Selection");
                }
            } catch (IOException ex) {
                System.out.println("There is an error in Direction elections at the moment to driver Selection: " + ex.getMessage());
            }
        });
    }
}