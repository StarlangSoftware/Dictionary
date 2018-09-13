package Syllibification;


/**
 * Identifies that word is irregular/loan/foreign.
 */
public class IrregularWordException extends Exception {
    /**
     * The IrregularWordException method takes a String message as an input and call its super class {@link Exception} with that message.
     *
     * @param message String input.
     */
    public IrregularWordException(String message) {
        super(message);
    }
}
