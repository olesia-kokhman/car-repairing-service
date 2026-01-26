package documents;

import java.time.LocalDateTime;

public class Invoice extends Document {
    private double laborHours;
    private double hourlyRate;
    private double partsCost;
    private double total;

    public Invoice(int invoiceNumber, int requestId, double laborHours, double hourlyRate, double partsCost) {
        super(invoiceNumber, requestId, null, LocalDateTime.now());
        this.laborHours = laborHours;
        this.hourlyRate = hourlyRate;
        this.partsCost = partsCost;
        recalc();
    }

    public Invoice(int invoiceNumber,
                   int requestId,
                   String createdByEmployeeId,
                   LocalDateTime createdAt,
                   double laborHours,
                   double hourlyRate,
                   double partsCost) {

        super(invoiceNumber, requestId, createdByEmployeeId, createdAt);
        this.laborHours = laborHours;
        this.hourlyRate = hourlyRate;
        this.partsCost = partsCost;
        recalc();
    }

    private void recalc() {
        total = (laborHours * hourlyRate) + partsCost;
    }

    public int getInvoiceNumber() {
        return getDocumentNumber();
    }
    public int getRequestId() {
        return super.getRequestId();
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

    @Override
    public String toPrint() {
        return toString();
    }

    @Override
    public String toString() {
        return "documents.Invoice{" +
                "invoiceNumber=" + getDocumentNumber() +
                ", requestId=" + getRequestId() +
                ", laborHours=" + laborHours +
                ", hourlyRate=" + hourlyRate +
                ", partsCost=" + partsCost +
                ", total=" + total +
                ", createdByEmployeeId='" + getCreatedByEmployeeId() + '\'' +
                ", createdAt=" + getCreatedAt() +
                '}';
    }
}
