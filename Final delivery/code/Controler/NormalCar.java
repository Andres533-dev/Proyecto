package Proyecto.Code.src.Controler;

public class NormalCar extends CarType {
    public NormalCar() {
        this.priceMultiplier = 1.0; // Precio normal
        this.speedFactor = 0;
        this.capacity = 4;
    }
    @Override
    public void applyTripSettings(Trip trip) {

    }

    @Override
    public String toString() {
        return "A good balance between price and quality";
    }
}