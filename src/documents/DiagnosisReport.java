package documents;

import java.time.LocalDateTime;

public class DiagnosisReport extends Document {
    private String issueFound;
    private double laborHours;
    private boolean needsPart;
    private String requiredPartName;

    public DiagnosisReport(String issueFound, double laborHours, boolean needsPart, String requiredPartName) {
        super(0, 0, null, LocalDateTime.now());
        this.issueFound = issueFound;
        this.laborHours = laborHours;
        this.needsPart = needsPart;
        this.requiredPartName = requiredPartName;
    }

    @Override
    public String toPrint() {
        return toString();
    }

    public DiagnosisReport(int reportNumber,
                           int requestId,
                           String createdByEmployeeId,
                           LocalDateTime createdAt,
                           String issueFound,
                           double laborHours,
                           boolean needsPart,
                           String requiredPartName) {

        super(reportNumber, requestId, createdByEmployeeId, createdAt);
        this.issueFound = issueFound;
        this.laborHours = laborHours;
        this.needsPart = needsPart;
        this.requiredPartName = requiredPartName;
    }

    public String getIssueFound() {
        return issueFound;
    }

    public void setIssueFound(String issueFound) {
        this.issueFound = issueFound;
    }

    public double getLaborHours() {
        return laborHours;
    }

    public void setLaborHours(double laborHours) {
        this.laborHours = laborHours;
    }

    public boolean isNeedsPart() {
        return needsPart;
    }

    public void setNeedsPart(boolean needsPart) {
        this.needsPart = needsPart;
    }

    public String getRequiredPartName() {
        return requiredPartName;
    }

    public void setRequiredPartName(String requiredPartName) {
        this.requiredPartName = requiredPartName;
    }

    @Override
    public String toString() {
        return "documents.DiagnosisReport{" +
                "reportNumber=" + getDocumentNumber() +
                ", requestId=" + getRequestId() +
                ", issueFound='" + issueFound + '\'' +
                ", laborHours=" + laborHours +
                ", needsPart=" + needsPart +
                ", requiredPartName='" + requiredPartName + '\'' +
                ", createdByEmployeeId='" + getCreatedByEmployeeId() + '\'' +
                ", createdAt=" + getCreatedAt() +
                '}';
    }
}
