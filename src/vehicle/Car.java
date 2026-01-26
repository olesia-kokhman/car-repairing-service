package vehicle;

public class Car extends Vehicle {

    private final FuelType fuelType;

    public Car(String plateNumber,
               String model,
               int year,
               int mileageKm,
               FuelType fuelType) {

        super(plateNumber, model, year, mileageKm);
        this.fuelType = fuelType;
    }

    public Car(String plateNumber, String model, int year, int mileageKm) {
        this(plateNumber, model, year, mileageKm, FuelType.PETROL);
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "vehicle.Car{" +
                "plateNumber='" + getPlateNumber() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", mileageKm=" + getMileage() +
                ", fuelType=" + fuelType +
                '}';
    }
}
