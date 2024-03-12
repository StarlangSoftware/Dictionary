package Dictionary;

import java.io.Serializable;
import java.text.Collator;
import java.util.Locale;

public class TurkishWordComparator extends WordComparator implements Serializable{

    /**
     * The compare method takes two {@link Word}s as inputs; wordA and wordB and compares their names. First it creates
     * a {@link Locale} object which represents a specific geographical, political, or cultural region  and an instance of
     * {@link Collator} which performs locale-sensitive String comparison. Then, it returns the result of this comparison.
     *
     * @param wordA Word type input.
     * @param wordB Word type input.
     * @return the value {@code 0} if the wordA is equal to the wordB; a value less than {@code 0} if this wordA is
     * lexicographically less than wordB; and a value greater than {@code 0} if this wordA is lexicographically greater
     * than wordB.
     */
    public int compare(Word wordA, Word wordB) {
        Locale locale = new Locale("tr");
        Collator collator = Collator.getInstance(locale);
        return collator.compare(wordA.getName(), wordB.getName());
    }

}
