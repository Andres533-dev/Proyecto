import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Trip {
    private int distance;
    private double price;
    private List<Direction>directions;

    public Trip(int distance, double price) {
        this.distance = distance;
        this.price = price;
        this.directions=new ArrayList<>();
    }
    public Direction createDirection(Scanner input) {
        System.out.println("Please enter the number of your type of road: ");
        System.out.println("1.Street");
        System.out.println("2.Career");
        int roadElection = input.nextInt();
        System.out.println("Please enter the street number between 1 and 246: ");
        int streetElection = input.nextInt();
        System.out.println("Please enter the career number between 1 and 161: ");
        int careerElection = input.nextInt();
        System.out.println("Please enter the number of house between 1 and 99: ");
        int houseNumberElection = input.nextInt();
        return new Direction(roadElection,streetElection,careerElection,houseNumberElection);
    }
    public void addDirection(Direction direction){
        directions.add(direction);
    }
    public Direction getDirection(int index){
        return directions.get(index);
    }
    public int getDistance() {
        Direction inicialDirection=getDirection(0);
        Direction finalDirection=getDirection(1);
        int streetDistance=(finalDirection.streetNumber-inicialDirection.streetNumber)*50;
        int careerDistance=(finalDirection.careerNumber-inicialDirection.careerNumber)*25;
        int houseDistance=(finalDirection.houseNumber-inicialDirection.houseNumber)*5;
        distance=streetDistance+careerDistance+houseDistance;
        return distance;
    }
    public double getPrice(){
        price=distance*10;
        return price;
    }
}