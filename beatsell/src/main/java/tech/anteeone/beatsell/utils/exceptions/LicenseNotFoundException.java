package tech.anteeone.beatsell.utils.exceptions;

public class LicenseNotFoundException extends Exception {

    public LicenseNotFoundException(){
        super();
    }

    public LicenseNotFoundException(String message){
        super(message);
    }

    public LicenseNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    public LicenseNotFoundException(Throwable cause){
        super(cause);
    }

}