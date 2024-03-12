package Dictionary;

import java.io.Serializable;
import java.util.*;

public class Dictionary implements Serializable {

    protected List<Word> words;
    protected String fileName;
    protected WordComparator comparator;

    /**
     * An empty constructor of {@link Dictionary} class.
     */
    public Dictionary() {

    }

    /**
     * Another constructor of {@link Dictionary} class which takes a {@link WordComparator} as an input and initializes
     * comparator variable with given input and also creates a new words {@link ArrayList}.
     *
     * @param comparator {@link WordComparator} type input.
     */
    public Dictionary(WordComparator comparator) {
        this.comparator = comparator;
        words = new ArrayList<>();
    }

    /**
     * The getWord method takes a String name as an input and performs binary search within words {@link ArrayList} and assigns the result
     * to integer variable middle. If the middle is greater than 0, it returns the item at index middle of words {@link ArrayList}, null otherwise.
     *
     * @param name String input.
     * @return the item at found index of words {@link ArrayList}, null if cannot be found.
     */
    public Word getWord(String name) {
        int middle;
        middle = Collections.binarySearch(words, new Word(name), comparator);
        if (middle >= 0) {
            return words.get(middle);
        }
        return null;
    }

    /**
     * RemoveWord removes a word with the given name
     * @param name Name of the word to be removed.
     */
    public void removeWord(String name){
        int middle = Collections.binarySearch(words, new Word(name), comparator);
        if (middle >= 0){
            words.remove(middle);
        }
    }

    /**
     * The getWordIndex method takes a String name as an input and performs binary search within words {@link ArrayList} and assigns the result
     * to integer variable middle. If the middle is greater than 0, it returns the index middle, -1 otherwise.
     *
     * @param name String input.
     * @return found index of words {@link ArrayList}, -1 if cannot be found.
     */
    public int getWordIndex(String name) {
        int middle;
        middle = Collections.binarySearch(words, new Word(name), comparator);
        if (middle >= 0) {
            return middle;
        }
        return -1;
    }

    /**
     * The size method returns the size of the words {@link ArrayList}.
     *
     * @return the size of the words {@link ArrayList}.
     */
    public int size() {
        return words.size();
    }

    /**
     * The getWord method which takes an index as an input and returns the value at given index of words {@link ArrayList}.
     *
     * @param index to get the value.
     * @return the value at given index of words {@link ArrayList}.
     */
    public Word getWord(int index) {
        return words.get(index);
    }

    /**
     * The longestWordSize method loops through the words {@link ArrayList} and returns the item with the maximum word length.
     *
     * @return the item with the maximum word length.
     */
    public int longestWordSize() {
        int max = 0;
        for (Word word : words) {
            if (word.getName().length() > max) {
                max = word.getName().length();
            }
        }
        return max;
    }

    /**
     * The getWordStartingWith method takes a String hash as an input and performs binary search within words {@link ArrayList} and assigns the result
     * to integer variable middle. If the middle is greater than 0, it returns the index middle, -middle-1 otherwise.
     *
     * @param hash String input.
     * @return found index of words {@link ArrayList}, -middle-1 if cannot be found.
     */
    public int getWordStartingWith(String hash) {
        int middle;
        middle = Collections.binarySearch(words, new Word(hash), comparator);
        if (middle >= 0) {
            return middle;
        } else {
            return -middle - 1;
        }
    }

}
