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

    @Override
    public String toPrint() {
        return toString();
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
