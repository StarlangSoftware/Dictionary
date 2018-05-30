package Dictionary;

import java.io.Serializable;
import java.util.*;

public class Dictionary implements Serializable{

    protected List<Word> words;
    protected String filename;
    protected WordComparator comparator;

    public Dictionary(){

    }

    public Dictionary(WordComparator comparator){
        this.comparator = comparator;
        words = new ArrayList<Word>();
    }

    public Word getWord(String name){
        int middle;
        middle = Collections.binarySearch(words, new Word(name), comparator);
        if (middle >= 0){
            return words.get(middle);
        }
        return null;
    }

    public int getWordIndex(String name){
        int middle;
        middle = Collections.binarySearch(words, new Word(name), comparator);
        if (middle >= 0){
            return middle;
        }
        return -1;
    }

    public int size(){
        return words.size();
    }

    public Word getWord(int index){
        return words.get(index);
    }

    public int longestWordSize(){
        int max = 0;
        for (Word word : words){
            if (word.getName().length() > max){
                max = word.getName().length();
            }
        }
        return max;
    }

    public int getWordStartingWith(String hash){
        int middle;
        middle = Collections.binarySearch(words, new Word(hash), comparator);
        if (middle >= 0){
            return middle;
        } else {
            return -middle - 1;
        }
    }

}
