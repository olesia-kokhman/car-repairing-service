package vehicle.parts;

public abstract class VehiclePart {
    private String partName;
    private double price;

    protected VehiclePart(String partName, double price) {
        this.partName = partName;
        this.price = price;
    }

    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract String category();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "partName='" + partName + '\'' +
                ", price=" + price +
                ", category='" + category() + '\'' +
                '}';
    }
}
