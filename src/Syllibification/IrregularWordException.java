package Syllibification;

/*Identifies that word is irregular/loan/foreign.*/
public class IrregularWordException extends Exception {
    public IrregularWordException(String message) {
        super(message);
    }
}
