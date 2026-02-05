package exceptions;

public class NoStaffAvailableException extends RuntimeException {
    public NoStaffAvailableException(String role) {
        super("No available staff for role: " + role);
    }
}
