package tech.anteeone.beatsell.utils.exceptions;

public class BeatNotFoundException extends Exception {

    public BeatNotFoundException(){
        super();
    }

    public BeatNotFoundException(String message){
        super(message);
    }

    public BeatNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    public BeatNotFoundException(Throwable cause){
        super(cause);
    }
}
