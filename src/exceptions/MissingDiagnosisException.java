package exceptions;

public class MissingDiagnosisException extends RuntimeException {
    public MissingDiagnosisException(int requestId) {
        super("ServiceRequest #" + requestId + " has no diagnosis");
    }
}
