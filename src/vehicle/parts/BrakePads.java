package vehicle.parts;

public class BrakePads extends VehiclePart {
    public BrakePads(double price) {
        super("Brake Pads", price);
    }

    @Override
    public String category() {
        return "BRAKES";
    }
}
