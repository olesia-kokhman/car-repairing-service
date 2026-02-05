package exceptions;

public class PartNotAvailableException extends RuntimeException {
    public PartNotAvailableException(String partName) {
        super("Required part not available: " + partName);
    }
}
