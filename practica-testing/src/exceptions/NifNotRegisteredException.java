package exceptions;

public class NifNotRegisteredException extends Exception {
    public NifNotRegisteredException() {
        super("NIF not registered");
    }
}
