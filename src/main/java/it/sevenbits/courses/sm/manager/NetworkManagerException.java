package it.sevenbits.courses.sm.manager;

public class NetworkManagerException extends Exception {

    public NetworkManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NetworkManagerException(String message) {
        super(message);
    }
}
