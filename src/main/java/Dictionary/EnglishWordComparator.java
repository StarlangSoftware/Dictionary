package Dictionary;

import java.io.Serializable;

public class EnglishWordComparator extends WordComparator implements Serializable {

    /**
     * The compare method takes two {@link Word}s as inputs; wordA and wordB and compares their names. Returns the result of this comparison.
     *
     * @param wordA Word type input.
     * @param wordB Word type input.
     * @return the value {@code 0} if the wordA is equal to the wordB; a value less than {@code 0} if this wordA is
     * lexicographically less than wordB; and a value greater than {@code 0} if this wordA is lexicographically greater
     * than wordB.
     */
    public int compare(Word wordA, Word wordB) {
        return wordA.getName().compareTo(wordB.getName());
    }
}
