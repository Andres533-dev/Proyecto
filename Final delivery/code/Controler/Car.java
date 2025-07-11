/* 
This file is the creation of the mother class car

Author: Andres Murillo <afmurillot@udistrital.edu.co> - Abr/2025
*/
package Proyecto.Code.src.Controler;


import java.util.*;

public class Car {
    protected ArrayList<Integer> ubication;
    private int capacity;
    private String color;
    private CarType type;  // Reemplaza a model
    private String licensePlate;

    // Factory Method para crear carros según tipo
    public static Car createCar(ArrayList<String> informationDriver,String charge) {
        Car car = new Car();
        car.setUpUbication();
        car.setColor(informationDriver.get(2), charge);
        car.setLicensePlate(informationDriver.get(3), charge);
        car.type = CarTypeFactory.createCarType(informationDriver.get(1));
        car.capacity = car.type.getCapacity();  // Capacidad se determina por el tipo
        return car;
    }

    // Constructor ahora privado para forzar uso del factory
    private Car() {}

    // Métodos existentes (adaptados)
    public String getColor() {
        return color;
    }

    public String getTypeDescription() {
        return type.toString();
    }
    public int getCapacity() {
        return capacity;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public ArrayList<Integer> getUbication() {
        return ubication;
    }
    public void setUpUbication() {
        ubication = new ArrayList<>();
        Random aleatory = new Random(System.currentTimeMillis());
        int street = aleatory.nextInt(20)+1;
        int career = aleatory.nextInt(20)+1;
        int houseNumber = aleatory.nextInt(30)+1;
        ubication.add(street);
        ubication.add(career);
        ubication.add(houseNumber);
    }
    public void setColor(String newColor, String charge) {
        if(charge.equals("Owner") || charge.equals("admin"))
            this.color = newColor;
    }

    public void setLicensePlate(String newLicensePlate, String charge) {
        if(charge.equals("Owner") || charge.equals("admin"))
            this.licensePlate = newLicensePlate;
    }

    protected CarType getCarType() {
        return type;
    }
}