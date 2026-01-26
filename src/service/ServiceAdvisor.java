package service;

public class ServiceAdvisor extends Employee implements Notifiable {

    private int deskNumber;
    private String languages;

    public ServiceAdvisor(String name) {
        super(
                "A-0001",
                name,
                2021,
                "+380000000000",
                name.toLowerCase().replace(" ", ".") + "@service.local",
                true,
                0.0,
                RateType.SALARY
        );

        this.deskNumber = 1;
        this.languages = "UA";
    }

    public ServiceAdvisor(String employeeId,
                          String name,
                          int hireYear,
                          String phone,
                          String email,
                          boolean active,
                          double baseRate,
                          RateType rateType,
                          int deskNumber,
                          String languages) {

        super(employeeId, name, hireYear, phone, email, active, baseRate, rateType);
        this.deskNumber = deskNumber;
        this.languages = languages;
    }

    public int getDeskNumber() { return deskNumber; }
    public void setDeskNumber(int deskNumber) { this.deskNumber = deskNumber; }

    public String getLanguages() { return languages; }
    public void setLanguages(String languages) { this.languages = languages; }

    public void accept(ServiceRequest request) {
        request.setStatus(ServiceRequestStatus.IN_PROGRESS);
        System.out.println("Advisor " + getName() + " accepted request#" + request.getId());
    }

    @Override
    public void notifyCustomer(Customer customer, String message) {
        System.out.println("Notify " + customer.getFullName() + ": " + message);
    }

    public void close(ServiceRequest request) {
        request.setStatus(ServiceRequestStatus.CLOSED);
        System.out.println("Advisor " + getName() + " closed request#" + request.getId());
    }

    @Override
    public String toString() {
        return "service.ServiceAdvisor{" +
                "employeeId='" + getEmployeeId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", baseRate=" + getBaseRate() +
                ", rateType=" + getRateType() +
                ", deskNumber=" + deskNumber +
                ", languages='" + languages + '\'' +
                '}';
    }
}
