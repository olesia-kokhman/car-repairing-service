public class Car {
    private String plateNumber;
    private String model;
    private int year;
    private int mileageKm;

    public Car(String plateNumber, String model, int year, int mileageKm) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.year = year;
        this.mileageKm = mileageKm;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileageKm() {
        return mileageKm;
    }

    public void setMileageKm(int mileageKm) {
        this.mileageKm = mileageKm;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileageKm=" + mileageKm +
                '}';
    }
}
