package vehicle.parts;

import vehicle.Priceable;

import java.util.Objects;

public abstract class VehiclePart implements Priceable {
    private final String partName;
    private double price;

    public static final int DEFAULT_WARRANTY_MONTHS = 6;

    protected VehiclePart(String partName, double price) {
        this.partName = partName;
        this.price = price;
    }

    public String getPartName() { return partName; }

    public void setPrice(double price) { this.price = price; }

    public abstract String category();

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "partName='" + partName + '\'' +
                ", price=" + price +
                ", category='" + category() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehiclePart that)) return false;
        return Double.compare(that.price, price) == 0 && Objects.equals(partName, that.partName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partName, price);
    }
}
