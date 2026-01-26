package vehicle;

public abstract class Vehicle {
    private String plateNumber;
    private final String model;
    private final int year;
    private int mileage;

    protected Vehicle(String plateNumber, String model, int year, int mileage) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public String getPlateNumber() { return plateNumber; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public int getMileage() { return mileage; }

    public void setMileage(int mileage) { this.mileage = mileage; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }

    public int age(int currentYear) {
        return Math.max(0, currentYear - year);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "plateNumber='" + plateNumber + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                '}';
    }
}
