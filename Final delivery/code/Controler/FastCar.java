package Proyecto.Code.src.Controler;

public class FastCar extends CarType {
    public FastCar() {
        this.priceMultiplier = 1.2;
        this.speedFactor = 20;
        this.capacity=4;
    }

    @Override
    public void applyTripSettings(Trip trip) {
    }

    @Override
    public String toString() {
        return "A good option if you go late ";
    }
}