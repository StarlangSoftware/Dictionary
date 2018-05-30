package Dictionary;

import java.io.Serializable;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class TurkishWordComparator extends WordComparator implements Serializable{

    public int compare(Word wordA, Word wordB) {
        Locale locale = new Locale("tr");
        Collator collator = Collator.getInstance(locale);
        return collator.compare(wordA.getName(), wordB.getName());
    }

}
