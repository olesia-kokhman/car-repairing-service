package service;

import documents.DiagnosisReport;
import exceptions.InvalidServiceRequestStateException;
import vehicle.Car;
import vehicle.parts.VehiclePart;

public class ServiceRequest {
    private final int id;
    private final Customer customer;
    private final Car car;

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
    public Customer getCustomer() {
        return customer;
    }
    public Car getCar() {
        return car;
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
        if (status == null) return;

        if (this.status == ServiceRequestStatus.CLOSED) {
            throw new InvalidServiceRequestStateException(this.status, status);
        }

        this.status = status;
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
