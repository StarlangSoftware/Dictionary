package Dictionary;

public class ExceptionalWord extends Word {
    private String root;
    private Pos pos;

    /**
     * A constructor of {@link ExceptionalWord} class which takes a {@link Pos} as a  part of speech and two Strings; name
     * and root as inputs. Then, calls its super class {@link Word} with given name and initialises root and pos variables
     * with given inputs.
     *
     * @param name String input.
     * @param root String input.
     * @param pos  {@link Pos} type input.
     */
    public ExceptionalWord(String name, String root, Pos pos) {
        super(name);
        this.root = root;
        this.pos = pos;
    }

    /**
     * Getter for the root variable.
     *
     * @return root variable.
     */
    public String getRoot() {
        return root;
    }

    /**
     * Getter for the pos variable.
     *
     * @return pos variable.
     */
    public Pos getPos() {
        return pos;
    }
}
