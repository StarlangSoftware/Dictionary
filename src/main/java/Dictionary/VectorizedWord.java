package Dictionary;

import Math.Vector;

public class VectorizedWord extends Word {
    private Vector vector;

    /**
     * A constructor of  {@link VectorizedWord} class which takes a String and a {@link Vector} as inputs and calls its
     * super class {@link Word} with name and also initializes vector variable with given input.
     *
     * @param name   Strin input.
     * @param vector {@link Vector} type input.
     */
    public VectorizedWord(String name, Vector vector) {
        super(name);
        this.vector = vector;
    }

    /**
     * Getter for the vector variable.
     *
     * @return the vector variable.
     */
    public Vector getVector() {
        return vector;
    }
}
