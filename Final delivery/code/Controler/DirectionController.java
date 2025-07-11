package Proyecto.Code.src.Controler;

import java.io.IOException;
import java.util.ArrayList;

import Proyecto.Code.src.Model.User;
import Proyecto.Code.src.Model.TripData;

public class DirectionController {
    protected int streetNumber;
    protected int careerNumber;
    protected int houseNumber;
    public int correctDirection;
    public boolean isNumber;
    private User user;
    private TripData trip;

    public DirectionController(ArrayList<String> answers, String[] labelTexts, User user, String directionType) {
        this.correctDirection = 0;
        this.isNumber = true;
        this.user = user;
        this.trip = new TripData();
        this.setUpInformation(answers, labelTexts);
        this.getStreet();
        this.getCareer();
        this.getHouseNumber();

        if (correctDirection == 3) {
            this.saveDirectionToTrip(labelTexts, directionType);
        }
    }

    public void setUpInformation(ArrayList<String> answers, String[] labelTexts) {
        try {
            if (labelTexts[0].contains("Career")) {
                this.careerNumber = Integer.parseInt(answers.get(0));
                this.streetNumber = Integer.parseInt(answers.get(1));
            }
            else {
                this.streetNumber = Integer.parseInt(answers.get(0));
                this.careerNumber = Integer.parseInt(answers.get(1));
            }
            this.houseNumber = Integer.parseInt(answers.get(2));
            isNumber = true;
        }
        catch (NumberFormatException e) {
            isNumber = false;
        }
    }

    public void getStreet() {
        if (isNumber && 1 <= streetNumber && streetNumber <= 246) {
            correctDirection++;
        }
    }

    public void getCareer() {
        if (isNumber && 1 <= careerNumber && careerNumber <= 161) {
            correctDirection++;
        }
    }

    public void getHouseNumber() {
        if (isNumber && 1 <= houseNumber && houseNumber <= 99) {
            correctDirection++;
        }
    }

    public String toString(String[] labelText) {
        if (labelText[0].contains("Street")) {
            return "Cl " + this.streetNumber + " #" + this.careerNumber + "-" + this.houseNumber;
        }
        else {
            return "Cra " + this.careerNumber + " #" + this.streetNumber + "-" + this.houseNumber;
        }
    }

    private void saveDirectionToTrip(String[] labelTexts, String directionType) {
        try {
            String direction = this.toString(labelTexts);
            if (directionType.equalsIgnoreCase("Pickup")) {
                trip.createFolderAndFile(user.getMail());
                trip.saveDirectionToFile(user.getMail(), direction, directionType);
            }
            else{
                if(direction.equals(trip.getLastPickupAddress(user.getMail()))){
                    correctDirection=-1;
                }
                else{
                    trip.saveDirectionToFile(user.getMail(), direction, directionType);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al guardar la dirección: " + e.getMessage());
        }
    }
}