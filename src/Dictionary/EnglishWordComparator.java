package Dictionary;

import java.io.Serializable;

public class EnglishWordComparator extends WordComparator implements Serializable{

    public int compare(Word wordA, Word wordB) {
        return wordA.getName().compareTo(wordB.getName());
    }
}
