package exceptions;

import service.ServiceRequestStatus;

public class InvalidServiceRequestStateException extends RuntimeException {

    public InvalidServiceRequestStateException(ServiceRequestStatus current, ServiceRequestStatus target) {
        super("Cannot change ServiceRequest status from " + current + " to " + target);
    }
}
