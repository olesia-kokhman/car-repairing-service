package service;

public class Payment {
    private String method;
    private double amountPaid;
    private boolean successful;

    public Payment(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public void pay(double invoiceTotal, double amountPaid) {
        this.amountPaid = amountPaid;
        this.successful = amountPaid >= invoiceTotal;
    }

    @Override
    public String toString() {
        return "service.Payment{" +
                "method='" + method + '\'' +
                ", amountPaid=" + amountPaid +
                ", successful=" + successful +
                '}';
    }
}
