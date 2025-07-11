package Proyecto.Code.src.Controler;

import Proyecto.Code.src.Model.DriverData;
import java.util.ArrayList;

public class DriverController {
    protected ArrayList<String> informationDriver;
    protected double price;
    protected double timeToUser;

    protected Car car;
    public DriverController(String typeCar,String charge) {
        this.getDriver(typeCar,charge);

    }
    public DriverController(String charge,double priceMultiplier,ArrayList<Integer> ubication,int speedFactor) {
        this.toTrip(priceMultiplier,ubication,speedFactor,charge);
    }
    public void getPrice(double price) {
        this.price = price;
    }
    public void getTimeToUser(double timeToUser) {
        this.timeToUser = timeToUser;
    }
    public String  getToString(){
        return car.getCarType().toString()+"Price:"+price+"\n "+"capacity:"+car.getCarType().capacity+"Time to pick up:"+timeToUser;
    }
    public void getDriver(String typeCar, String charge) {
            DriverData driver=new DriverData(typeCar);
            informationDriver=driver.getDriverInformation(charge);
    }
    protected void saveCar(Car car) {
        this.car = car;
    }
    protected void toTrip(double priceMultiplier,ArrayList<Integer> ubication,int speedFactor,String charge) {
        if(charge.equals("Trip")) {
            priceMultiplier=car.getCarType().priceMultiplier;
            ubication=car.getUbication();
            speedFactor=car.getCarType().speedFactor;
        }

    }
    public int getCar(String charge){
        if(charge.equals("User")){
            return car.getCarType().getCapacity();
        }
        return 0;
    }

}
