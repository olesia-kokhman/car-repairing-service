package documents;

import java.time.LocalDateTime;

public abstract class Document implements Printable {
    private final int documentNumber;
    private final int requestId;

    private final String createdByEmployeeId;
    private final LocalDateTime createdAt;

    protected Document(int documentNumber, int requestId, String createdByEmployeeId, LocalDateTime createdAt) {
        this.documentNumber = documentNumber;
        this.requestId = requestId;
        this.createdByEmployeeId = createdByEmployeeId;
        this.createdAt = createdAt;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }
    public int getRequestId() {
        return requestId;
    }
    public String getCreatedByEmployeeId() {
        return createdByEmployeeId;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    protected abstract String body();

    @Override
    public final String toPrint() {
        return header() + "\n" + body();
    }

    protected String header() {
        return getClass().getSimpleName().toUpperCase()
                + " #" + documentNumber
                + "\nRequest: #" + requestId
                + "\nCreated by: " + (createdByEmployeeId == null ? "UNKNOWN" : createdByEmployeeId)
                + "\nCreated at: " + createdAt
                + "\n--------------------------------";
    }

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
