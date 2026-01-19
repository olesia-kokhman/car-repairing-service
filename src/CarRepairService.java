public class CarRepairService {
    private ServiceAdvisor advisor;
    private Mechanic mechanic;

    public CarRepairService(ServiceAdvisor advisor, Mechanic mechanic) {
        this.advisor = advisor;
        this.mechanic = mechanic;
    }

    public ServiceAdvisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(ServiceAdvisor advisor) {
        this.advisor = advisor;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Invoice process(ServiceRequest request) {
        advisor.accept(request);

        DiagnosisReport report = mechanic.diagnose(request);
        request.setDiagnosis(report);

        advisor.notifyCustomer(request.getCustomer(), "Diagnosis ready: " + report.getIssueFound());

        double partsCost = 0.0;

        if (report.isNeedsPart()) {
            SparePart part = createPartByName(report.getRequiredPartName());
            request.setUsedPart(part);
            partsCost = part.getPrice();

            advisor.notifyCustomer(request.getCustomer(), "Part will be used: " + part.getName());
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

    private SparePart createPartByName(String partName) {
        if (partName == null || partName.isEmpty()) {
            return new SparePart("Unknown Part", 0.0);
        }

        if (partName.equalsIgnoreCase("Brake Pads")) {
            return new SparePart("Brake Pads", 1200.0);
        }

        if (partName.equalsIgnoreCase("Oil Filter")) {
            return new SparePart("Oil Filter", 300.0);
        }

        return new SparePart(partName, 500.0);
    }

    @Override
    public String toString() {
        return "CarRepairService{" +
                "advisor=" + advisor +
                ", mechanic=" + mechanic +
                '}';
    }
}
