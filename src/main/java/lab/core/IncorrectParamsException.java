package lab.core;

/**
 * Exception indicate that the passed params are not a correct numbers
 *
 * @author BarbaraKorpak 1.2
 */
public class IncorrectParamsException extends Exception {

    /**
     * Exception catching method.
     * 
     * @param message  text to be displayed
     */
    public IncorrectParamsException(String message) {
        super(message);
    }
    
}
