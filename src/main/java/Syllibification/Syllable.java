package Syllibification;

public class Syllable {
    private final String syllable;

    /**
     * A constructor of {@link Syllable} class which takes a String as an input and initializes syllable variable with given input.
     *
     * @param syllable String input.
     */
    public Syllable(String syllable) {
        this.syllable = syllable;
    }

    /**
     * Getter for the syllable variable.
     *
     * @return the syllable variable.
     */
    public String getText() {
        return syllable;
    }
}
