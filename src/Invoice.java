public class Invoice {
    private int invoiceNumber;
    private int requestId;

    private double laborHours;
    private double hourlyRate;
    private double partsCost;
    private double total;

    public Invoice(int invoiceNumber, int requestId, double laborHours, double hourlyRate, double partsCost) {
        this.invoiceNumber = invoiceNumber;
        this.requestId = requestId;
        this.laborHours = laborHours;
        this.hourlyRate = hourlyRate;
        this.partsCost = partsCost;
        recalc();
    }

    private void recalc() {
        total = (laborHours * hourlyRate) + partsCost;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public double getLaborHours() {
        return laborHours;
    }

    public void setLaborHours(double laborHours) {
        this.laborHours = laborHours;
        recalc();
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
        recalc();
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
        recalc();
    }

    public double getTotal() {
        return total;
    }

    public String print() {
        double laborCost = laborHours * hourlyRate;
        return "Invoice#" + invoiceNumber + " for request#" + requestId
                + "\n  laborCost=" + laborCost
                + "\n  partsCost=" + partsCost
                + "\n  TOTAL=" + total;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber=" + invoiceNumber +
                ", requestId=" + requestId +
                ", laborHours=" + laborHours +
                ", hourlyRate=" + hourlyRate +
                ", partsCost=" + partsCost +
                ", total=" + total +
                '}';
    }
}
