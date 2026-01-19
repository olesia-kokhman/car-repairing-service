public class DiagnosisReport {
    private String issueFound;
    private double laborHours;
    private boolean needsPart;
    private String requiredPartName;

    public DiagnosisReport(String issueFound, double laborHours, boolean needsPart, String requiredPartName) {
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
        return "DiagnosisReport{" +
                "issueFound='" + issueFound + '\'' +
                ", laborHours=" + laborHours +
                ", needsPart=" + needsPart +
                ", requiredPartName='" + requiredPartName + '\'' +
                '}';
    }
}
