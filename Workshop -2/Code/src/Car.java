package Proyecto.Code.src;
/* 
This file is the creation of the mother class car

Author: Andres Murillo <afmurillot@udistrital.edu.co> - Abr/2025
*/
public class Car {
    private int capacity;
    private String color;
    private String model;
    private String licensePlate;
    /*
    Creation of the constructor and realize the variable inicialitation  
    */
    public Car(){
        this.color=color;
        this.model=model;
        this.licensePlate=licensePlate;
        this.capacity=capacity;
    }
    /**
    Creating a getters that analize a variable carElection, this variable will be true if the user select a car to make a trip
    * @param car election: boolean to use.
    */
    public String getColor(boolean carElection) {
        if(carElection){
            return color;
        }
        return "No car selected";

    }
    public String getModel(boolean carElection) {
        if(carElection){
        return model;
        }
        return "No car selected"; //In case that the user dont choose a car
    }
    public String getLicensePlate(boolean carElection) {
        if(carElection){
        return licensePlate;
        }
        return "No car selected";
    }
    public int getCapacity(boolean carElection) {
        if(carElection){
        return capacity;
        }
        return 0;//In case that the user dont choose a car
    }
    /**
     Creating a setter that allows to change the variable if the input are avalible and if the carge of the person is correctly
     * @param newColor: a string variable that indicates the color of the car
     * @param charge: the carge of the person who wants to change the variable color
     */
    public void setColor(String newColor, String charge){
        if(charge.equals("Owner") || charge.equals("admin"))
            this.color=newColor;
    }
    public void setCapacity(int newCapacity, String charge) {
        if(charge.equals("Owner") || charge.equals("admin"))
        this.capacity = newCapacity;
    }
      public void setModel(String newModel, String charge) {
        if(charge.equals("Owner") || charge.equals("admin"))
        this.model = newModel;
    }

    public void setLicensePlate(String newLicensePlate, String charge) {
        if(charge.equals("Owner") || charge.equals("admin"))
        this.licensePlate = newLicensePlate;
    }
}