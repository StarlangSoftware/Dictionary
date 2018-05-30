package Dictionary;

import java.io.Serializable;
import java.util.Comparator;

public abstract class WordComparator implements Comparator<Word>, Serializable{

    public abstract int compare(Word wordA, Word wordB);

}
