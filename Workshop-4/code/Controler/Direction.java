import java.util.Scanner;
public class Direction {
    protected int    roadType;
    protected int    streetNumber;
    protected int    careerNumber;
    protected int    houseNumber;
    public Direction(int roadType, int streetNumber, int careerNumber, int houseNumber){
        this.roadType =roadType;
        this.streetNumber=streetNumber;
        this.careerNumber=careerNumber;
        this.houseNumber = houseNumber;
    }
    Scanner input = new Scanner(System.in);
    public int getStreet(int streetElection) {
            if (1 <= streetElection && streetElection <= 246) {
                streetNumber = streetElection;
            }
        return this.streetNumber;
    }
    public int getCareer(int careerElection){
            if (1 <= careerElection && careerElection <= 161) {
                careerNumber = careerElection;
            }
        return this.careerNumber;
    }
    public int getHouseNumber(int houseNumerElection) {
            if (1 <= houseNumerElection && houseNumerElection <= 99) {
                houseNumber = houseNumerElection;
            }
        return houseNumber;
    }
    public String toString(String roadType,int streetNumber ,int careerNumber,int houseNumber){
        if(this.roadType==1){
            return "This is the direction: Cl" + this.streetNumber + " #" + this.careerNumber + "-"+this.houseNumber ;
        }
        else {
            return "This is the direction: Cra" +" " +this.careerNumber + " #" + this.streetNumber + "-" +this.houseNumber ;
        }
    }
}