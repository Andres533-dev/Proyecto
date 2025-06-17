package Proyecto.Code.src;
import java.util.Scanner;
public class Direction {
    private String roadType;
    private int    streetNumber;
    private int    careerNumber;
    private int    houseNumber;
    public Direction(String roadType, int streetNumber, int careerNumber, int houseNumber){
        this.roadType = roadType;
        this.streetNumber=streetNumber;
        this.careerNumber=careerNumber;
        this.houseNumber = houseNumber;
    }
    Scanner input = new Scanner(System.in);
    public String getRoad() {
        while(true){
            System.out.println("Please enter the number of your type of road: ");
            System.out.println("1.Street");
            System.out.println("2.Career");
            int selection = input.nextInt();
            if(selection == 1){
                roadType = "Street";
                break;
            }
            else if(selection == 2){
                roadType = "Career";
                break;
            }
            else
                System.out.println("Please enter a valid option: ");

        }
        return roadType;
    }
    public int getStreet() {
        while(true) {
            System.out.println("Please enter the street number between 1 and 246: ");
            int election = input.nextInt();
            if (1 <= election && election <= 246) {
                streetNumber = election;
                break;
            }
        }
        return this.streetNumber;
    }
    public int getCareer(){
        while(true){
            System.out.println("Please enter the career number between 1 and 161: ");
            int election = input.nextInt();
            if (1 <= election && election <= 161) {
                careerNumber = election;
                break;
            }
        }
        return this.careerNumber;
    }
    public int getHouseNumber() {
        while(true) {
            System.out.println("Please enter the number of house between 1 and 99: ");
            int election = input.nextInt();
            if (1 <= election && election <= 99) {
                houseNumber = election;
                break;
            }
        }
        return houseNumber;
    }
    public String toString(String roadType,int streetNumber ,int careerNumber){

        if(roadType.equals("Street")){
            return "This is the direction: Cl" + this.streetNumber + " #" + this.careerNumber ;
        }
        else{
            return "This is the direction: Cra" +" " +this.careerNumber + " #" + this.streetNumber ;
        }
    }
}