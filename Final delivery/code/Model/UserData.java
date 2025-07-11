package Proyecto.Code.src.Model;

import java.io.*;
import java.util.ArrayList;

public class UserData {
    private ArrayList<String> information;
    public UserData(ArrayList<String> answers) {
        information = answers;
    }
    public void addUser(){
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("Users.txt",true))) {
            String[] typeInformation={"Name:","Last Name:","Mail:","Password:"};
            for(int i=0;i<=3;i++){
                escritor.write(typeInformation[i]+information.get(i));
                escritor.newLine();
            }
            escritor.newLine();
            System.out.println("Archivo escrito exitosamente");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    public int searchUser(){
        int userExists=0;
        try (BufferedReader br = new BufferedReader(new FileReader("Users.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null && userExists<2) {
                if(linea.contains("Mail:")){
                    String[] partes = linea.split(":", 2);
                    if(partes[1].equals(information.get(2))) {
                        userExists++;
                    }
                }
                else if(linea.contains("Password:")){
                    String[] partes = linea.split(":", 2);
                    if(partes[1].equals(information.get(3))) {
                        userExists++;
                    }
                }
            }
            return userExists;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return -1;
           }
    }
}
