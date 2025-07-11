
package Proyecto.Code.src.Controler;

import Proyecto.Code.src.Model.User;

import javax.swing.*;
import java.io.IOException;

/*
Subclass from User since they both require credentials to login (mail and password) &
  basic info for communication (name and number)
*/
public class Driver {

	//Own attributes
		private String name;
        private Car car;
		private String string;
		private double price;
		private double timeToUser;
		
	public Driver(String typeCar, User user) throws IOException {
        DriverController driver=new DriverController(typeCar,"Driver");
		this.name = driver.informationDriver.getFirst();
        this.car=Car.createCar(driver.informationDriver,"Owner");
		TripController trip=new TripController(user,car);
		this.price = trip.price; // Añadir precio
		this.timeToUser = trip.timeToUser;
		driver.saveCar(car);
	}
	public String toString() {
		return "Car Type: " + car.getTypeDescription() +
				"\n Capacity: " + car.getCapacity() +
				"\n Price: $" + price +
				"\n ETA: " + String.format("%.2f", timeToUser) + " mins";
	}
	public int getCar(String charge) {
		if(charge.equals("User")) {
			return car.getCarType().getCapacity();
		}
		else {
			return 0;
		}
	}
	public String getPrice(String charge) {
		if(charge.equals("User")) {
			return String.format("%.2f", price);
		}
		else {
			return "0";
		}
	}
	public String getTimeToUser(String charge) {
		if(charge.equals("User")) {

			return String.format("%.2f", timeToUser);

		}
		else {
			return "0";
		}
	}
}
