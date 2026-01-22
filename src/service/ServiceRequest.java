package service;

import documents.DiagnosisReport;
import vehicle.Car;
import vehicle.parts.VehiclePart;

public class ServiceRequest {
    private int id;
    private Customer customer;
    private Car car;
    private String problemDescription;
    private ServiceRequestStatus status;

    private DiagnosisReport diagnosis;
    private VehiclePart usedPart;

    public ServiceRequest(int id, Customer customer, Car car, String problemDescription) {
        this.id = id;
        this.customer = customer;
        this.car = car;
        this.problemDescription = problemDescription;
        this.status = ServiceRequestStatus.NEW;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public ServiceRequestStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceRequestStatus status) {
        if (status != null) {
            this.status = status;
        }
    }

    public DiagnosisReport getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(DiagnosisReport diagnosis) {
        this.diagnosis = diagnosis;
    }

    public VehiclePart getUsedPart() {
        return usedPart;
    }

    public void setUsedPart(VehiclePart usedPart) {
        this.usedPart = usedPart;
    }

    @Override
    public String toString() {
        return "service.ServiceRequest{" +
                "id=" + id +
                ", customer=" + customer +
                ", car=" + car +
                ", problemDescription='" + problemDescription + '\'' +
                ", status=" + status +
                ", diagnosis=" + diagnosis +
                ", usedPart=" + usedPart +
                '}';
    }
}
