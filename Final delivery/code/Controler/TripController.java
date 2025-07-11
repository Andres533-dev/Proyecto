package Proyecto.Code.src.Controler;

import Proyecto.Code.src.Model.TripData;
import Proyecto.Code.src.Model.User;

import java.io.*;
import java.util.*;

public class TripController {
    private String pickup;
    private String arrive;
    private ArrayList<Integer> streets;
    private ArrayList<Integer>carreer;
    private ArrayList<Integer> housesNumbers;
    private User user;
    private Car car;
    protected double price;
    protected double timeToUser;
    public TripController(User user,Car car) throws IOException {
        this.user = user;
        this.getDirections();
        this.convertDirections();
        this.car=car;
        Trip trip=new Trip(streets,carreer,housesNumbers,car);
        price=trip.getPrice(car,price);
        timeToUser=trip.timeToUser(car);

    }
    public void getDirections() throws IOException {
        TripData tripData = new TripData();
        pickup=tripData.getLastPickupAddress(user.getMail());
        arrive=tripData.getLastArrvieAddress(user.getMail());
    }
    public void convertDirections(){
        String[]directions=new String[]{pickup,arrive};
        streets=new ArrayList<>();
        carreer=new ArrayList<>();
        housesNumbers=new ArrayList<>();
        for(int i=0;i<2;i++){
            String[] parts = directions[i].split("#",2);
            if(directions[i].contains("Cra")){
                // Extraer la parte que contiene el streetNumber y houseNumber (Y-Z)
                String cr=parts[0].split(" ",2)[1].trim();
                String st = parts[1].split("-",2)[0].trim();
                int careerNumber=Integer.parseInt(cr);
                int streetNumber = Integer.parseInt(st);
                streets.add(streetNumber);
                carreer.add(careerNumber);
            }
            else if(directions[i].contains("Cl")){
                // Extraer la parte que contiene el streetNumber y houseNumber (Y-Z)
                String cr=parts[1].split("-",2)[0].trim();
                String st = parts[0].split(" ",2)[1].trim();
                int careerNumber=Integer.parseInt(cr);
                int streetNumber = Integer.parseInt(st);
                streets.add(streetNumber);
                carreer.add(careerNumber);
            }
            String hn = parts[1].split("-",2)[1];
            int houseNumber = Integer.parseInt(hn);
            housesNumbers.add(houseNumber);
        }
    }
    public void getPrice() {

    }
}
