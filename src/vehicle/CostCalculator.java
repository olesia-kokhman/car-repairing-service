package vehicle;

import service.ServiceRequest;

public interface CostCalculator {
    double calculate(ServiceRequest request);
}
