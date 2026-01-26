package vehicle;

import service.ServiceRequest;

public class MileageCostCalculator implements CostCalculator {
    private final double base;
    private final double per1000Km;

    public MileageCostCalculator(double base, double per1000Km) {
        this.base = base;
        this.per1000Km = per1000Km;
    }

    @Override
    public double calculate(ServiceRequest request) {
        int mileage = request.getCar().getMileage();
        return base + (mileage / 1000) * per1000Km;
    }
}
