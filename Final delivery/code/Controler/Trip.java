package Proyecto.Code.src.Controler;

import java.util.ArrayList;
public class Trip {
    protected double travelDistance;
    protected double userDistance;

    public Trip(ArrayList<Integer>street,ArrayList<Integer>career,ArrayList<Integer>houseNumber,Car car) {
        this.getDistance(street,career,houseNumber);
        this.userCarDistance(street,career,houseNumber,car);
    }
    public void getDistance(ArrayList<Integer>street,ArrayList<Integer>career,ArrayList<Integer>houseNumber) {
        int streetDistance=Math.abs((street.get(1) - street.get(0))*50);
        int careerDistance=Math.abs((career.get(1) - career.get(0))*25);
        int houseDistance=Math.abs((houseNumber.get(1) - houseNumber.get(0))*5);
        travelDistance=streetDistance+careerDistance+houseDistance;
    }
    public void userCarDistance(ArrayList<Integer>street,ArrayList<Integer>career,ArrayList<Integer>houseNumber,Car car) {
       int streetDistance=Math.abs((street.getFirst() - car.ubication.getFirst())*50);
       int careerDistance=Math.abs((career.getFirst() - car.ubication.get(1))*25);
       int houseDistance=Math.abs((houseNumber.getFirst() -car.ubication.get(2))*5);
       userDistance=streetDistance+careerDistance+houseDistance;
    }
    public double timeToArrive(Car car){
        return ((travelDistance / 10+car.getCarType().getSpeedFactor()))/60;
    }
    public double timeToUser(Car car){
        return ((userDistance / 10+car.getCarType().getSpeedFactor()))/60;

    }
    public double getBasePrice(double price){
        price=(travelDistance /10)*100;
        return price;
    }
    public double getPrice(Car car,double price){
        price = this.getBasePrice(price) * car.getCarType().priceMultiplier;
        return price;
    }
}
