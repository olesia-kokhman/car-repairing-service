public class Mechanic {
    private String name;
    private double hourlyRate;

    public Mechanic(String name, double hourlyRate) {
        this.name = name;
        this.hourlyRate = hourlyRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

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
        return "Mechanic{" +
                "name='" + name + '\'' +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}
