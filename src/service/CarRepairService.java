package service;

import documents.DiagnosisReport;
import documents.Invoice;
import vehicle.parts.BrakePads;
import vehicle.parts.VehiclePart;

import java.util.List;

public class CarRepairService {

    private final List<ServiceAdvisor> advisors;
    private final List<Mechanic> mechanics;

    public CarRepairService(List<ServiceAdvisor> advisors, List<Mechanic> mechanics) {
        this.advisors = advisors;
        this.mechanics = mechanics;
    }

    public Invoice process(ServiceRequest request) {
        ServiceAdvisor advisor = chooseAdvisor();
        Mechanic mechanic = chooseMechanic();

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

    private ServiceAdvisor chooseAdvisor() {
        if (advisors == null || advisors.isEmpty()) {
            throw new IllegalStateException("No service advisors available");
        }
        return advisors.get(0);
    }

    private Mechanic chooseMechanic() {
        if (mechanics == null || mechanics.isEmpty()) {
            throw new IllegalStateException("No mechanics available");
        }
        return mechanics.get(0);
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
                "advisors=" + advisors +
                ", mechanics=" + mechanics +
                '}';
    }
}
