package Dictionary;

import java.io.Serializable;
import java.util.Comparator;

public abstract class WordComparator implements Comparator<Word>, Serializable {

    /**
     * An abstract compare method.
     *
     * @param wordA Word type input.
     * @param wordB Word type input.
     * @return integer.
     */
    public abstract int compare(Word wordA, Word wordB);

}
