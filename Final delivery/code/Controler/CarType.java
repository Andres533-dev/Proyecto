
package Proyecto.Code.src.Controler;

public abstract class CarType {
    protected double priceMultiplier;
    protected int speedFactor;
    protected int capacity;// km/h adicionales

    public abstract void applyTripSettings(Trip trip);
    public int getSpeedFactor() {
        return speedFactor;
    }

    public int getCapacity() {
        return capacity;
    }
}