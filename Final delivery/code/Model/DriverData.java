package Proyecto.Code.src.Model;

import Proyecto.Code.src.Controler.Car;

import java.io.*;
import java.util.*;

public class DriverData {
    private ArrayList<String> informationDriver;
    public DriverData(String typeCar) {
        informationDriver = new ArrayList<>();
        foundDriverInformation(typeCar);
    }
    public void foundDriverInformation(String typeCar){
        boolean isDriver = true;
        try (BufferedReader br = new BufferedReader(new FileReader("Drivers.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null && informationDriver.size()!=4){
                if (linea.contains("Name:")) {
                    String[] partes = linea.split(":", 2);
                    informationDriver.add(partes[1]);
                }
                else if(linea.contains("TypeCar:")){
                    String[] partes = linea.split(":", 2);
                    if(partes[1].equalsIgnoreCase(typeCar)){
                        informationDriver.add(partes[1]);
                        isDriver = true;
                    }
                    else{
                        informationDriver.clear();
                        isDriver = false;
                    }
                }
                else if(linea.contains("Color:") && isDriver){
                    String[] partes = linea.split(":", 2);
                    informationDriver.add(partes[1]);
                }
                else if(linea.contains("LicensePlate:") && isDriver){
                    String[] partes = linea.split(":", 2);
                    informationDriver.add(partes[1]);
                }
            }
        }
        catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public ArrayList<String> getDriverInformation(String charge){
        if(charge.equals("Driver")||charge.equals("Client")){
            return informationDriver;
        }
        else if(charge.equals("User")){
            ArrayList<String> toUser = new ArrayList<>();
            toUser.add(informationDriver.get(1));
            return toUser;
        }
        return null;
    }
}
