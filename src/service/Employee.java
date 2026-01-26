package service;

public abstract class Employee {
    private final String employeeId;
    private final String name;
    private final int hireYear;

    private String phone;
    private String email;

    private boolean active;

    private double baseRate;
    private RateType rateType;

    protected Employee(String employeeId,
                       String name,
                       int hireYear,
                       String phone,
                       String email,
                       boolean active,
                       double baseRate,
                       RateType rateType) {
        this.employeeId = employeeId;
        this.name = name;
        this.hireYear = hireYear;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.baseRate = baseRate;
        this.rateType = rateType;
    }

    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public int getHireYear() { return hireYear; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public double getBaseRate() { return baseRate; }
    public void setBaseRate(double baseRate) { this.baseRate = baseRate; }

    public RateType getRateType() { return rateType; }
    public void setRateType(RateType rateType) { this.rateType = rateType; }

    public int getYearsInCompany(int currentYear) {
        return Math.max(0, currentYear - hireYear);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", hireYear=" + hireYear +
                ", active=" + active +
                ", baseRate=" + baseRate +
                ", rateType=" + rateType +
                '}';
    }
}
