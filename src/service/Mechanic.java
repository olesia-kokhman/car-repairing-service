package service;

import documents.DiagnosisReport;

public class Mechanic extends Employee {

    private String specialization;
    private String certificationLevel;

    public Mechanic(String name, double hourlyRate) {
        super(
                "M-0001",
                name,
                2020,
                "+380000000000",
                name.toLowerCase().replace(" ", ".") + "@service.local",
                true,
                hourlyRate,
                RateType.HOURLY
        );

        this.specialization = "General";
        this.certificationLevel = "Middle";
    }

    public Mechanic(String employeeId,
                    String name,
                    int hireYear,
                    String phone,
                    String email,
                    boolean active,
                    double hourlyRate,
                    String specialization,
                    String certificationLevel) {

        super(employeeId, name, hireYear, phone, email, active, hourlyRate, RateType.HOURLY);
        this.specialization = specialization;
        this.certificationLevel = certificationLevel;
    }

    public double getHourlyRate() {
        return getBaseRate();
    }

    public void setHourlyRate(double hourlyRate) {
        setBaseRate(hourlyRate);
        setRateType(RateType.HOURLY);
    }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getCertificationLevel() { return certificationLevel; }
    public void setCertificationLevel(String certificationLevel) { this.certificationLevel = certificationLevel; }

    public DiagnosisReport diagnose(ServiceRequest request) {
        String desc = request.getProblemDescription();
        if (desc == null) desc = "";
        desc = desc.toLowerCase();

        if (desc.contains("brake")) {
            return new DiagnosisReport("Worn brake pads", 1.5, true, "Brake Pads");
        } else if (desc.contains("oil")) {
            return new DiagnosisReport("Oil change needed", 0.8, true, "Oil Filter");
        } else {
            return new DiagnosisReport("General inspection", 1.0, false, "");
        }
    }

    @Override
    public String toString() {
        return "service.Mechanic{" +
                "employeeId='" + getEmployeeId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", hourlyRate=" + getBaseRate() +
                ", specialization='" + specialization + '\'' +
                ", certificationLevel='" + certificationLevel + '\'' +
                '}';
    }
}
