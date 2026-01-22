package service;

import documents.DiagnosisReport;
import documents.Invoice;
import vehicle.parts.BrakePads;
import vehicle.parts.VehiclePart;

public class CarRepairService {
    private ServiceAdvisor advisor;
    private Mechanic mechanic;

    public CarRepairService(ServiceAdvisor advisor, Mechanic mechanic) {
        this.advisor = advisor;
        this.mechanic = mechanic;
    }

    public Invoice process(ServiceRequest request) {
        advisor.accept(request);

        DiagnosisReport report = mechanic.diagnose(request);
        request.setDiagnosis(report);

        advisor.notifyCustomer(
                request.getCustomer(),
                "Diagnosis ready: " + report.getIssueFound()
        );

        double partsCost = 0.0;

        if (report.isNeedsPart()) {
            VehiclePart part = createPart(report.getRequiredPartName());
            request.setUsedPart(part);

            if (part != null) {
                partsCost = part.getPrice();
                advisor.notifyCustomer(
                        request.getCustomer(),
                        "Part will be used: " + part.getPartName()
                );
            }
        }

        request.setStatus(ServiceRequestStatus.READY);

        int invoiceNumber = 5000 + request.getId();

        return new Invoice(
                invoiceNumber,
                request.getId(),
                report.getLaborHours(),
                mechanic.getHourlyRate(),
                partsCost
        );
    }

    private VehiclePart createPart(String partName) {
        if (partName == null || partName.isBlank()) {
            return null;
        }

        return new BrakePads(1200.0);
    }

    @Override
    public String toString() {
        return "service.CarRepairService{" +
                "advisor=" + advisor +
                ", mechanic=" + mechanic +
                '}';
    }
}
