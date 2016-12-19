package sofysmo.testCalculator.exceptions;

/**
 * Created by sofysmo on 19.12.16.
 */
public class PersistException extends RuntimeException{
    public PersistException(String message){
        super(message);
    }
    public  PersistException(Exception e){
        super(e);
    }
}
