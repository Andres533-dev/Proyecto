package Proyecto.Code.src.Controler;

public class CarTypeFactory {
    public static CarType createCarType(String type) {
        if (type.equals("Xl")) {
            return new CarXL();
        } else if (type.equals("Normal")) {
            return new NormalCar();
        } else if(type.equals("Fast")) {
            return new FastCar();
        }
        throw new IllegalArgumentException("Tipo de auto desconocido: " + type);
    }
}
