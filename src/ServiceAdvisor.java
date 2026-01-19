public class ServiceAdvisor {
    private String name;

    public ServiceAdvisor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void accept(ServiceRequest request) {
        request.setStatus(ServiceRequestStatus.IN_PROGRESS);
        System.out.println("Advisor " + name + " accepted request#" + request.getId());
    }

    public void notifyCustomer(Customer customer, String message) {
        System.out.println("Notify " + customer.getFullName() + ": " + message);
    }

    public void close(ServiceRequest request) {
        request.setStatus(ServiceRequestStatus.CLOSED);
        System.out.println("Advisor " + name + " closed request#" + request.getId());
    }

    @Override
    public String toString() {
        return "ServiceAdvisor{" +
                "name='" + name + '\'' +
                '}';
    }
}
