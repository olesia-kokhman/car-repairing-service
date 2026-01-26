package documents;

import java.time.LocalDateTime;

public abstract class Document implements Printable {
    private int documentNumber;
    private int requestId;

    private String createdByEmployeeId;
    private LocalDateTime createdAt;

    protected Document(int documentNumber, int requestId, String createdByEmployeeId, LocalDateTime createdAt) {
        this.documentNumber = documentNumber;
        this.requestId = requestId;
        this.createdByEmployeeId = createdByEmployeeId;
        this.createdAt = createdAt;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getCreatedByEmployeeId() {
        return createdByEmployeeId;
    }

    public void setCreatedByEmployeeId(String createdByEmployeeId) {
        this.createdByEmployeeId = createdByEmployeeId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public abstract String print();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "documentNumber=" + documentNumber +
                ", requestId=" + requestId +
                ", createdByEmployeeId='" + createdByEmployeeId + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
