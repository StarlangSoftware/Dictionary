package Dictionary.Trie;

import Dictionary.TxtWord;
import Dictionary.Word;

import java.util.HashSet;

public class Trie {
    private TrieNode rootNode;

    /**
     * A constructor of {@link Trie} class which creates a new {@link TrieNode} as rootNode.
     */
    public Trie() {
        rootNode = new TrieNode();
    }

    /**
     * The addWord method which takes a String word and a {@link Word} root as inputs and adds given word and root to the rootNode.
     *
     * @param word String input.
     * @param root {@link Word} input.
     */
    public void addWord(String word, Word root) {
        rootNode.addWord(word, root);
    }

    /**
     * The getWordsWithPrefix method which takes a String surfaceForm as an input. First it creates a {@link TrieNode} current and assigns
     * the rootNode to it, then it creates a new {@link HashSet} words. It loops i times where i ranges from 0 to length of surfaceForm
     * and assigns current's child that corresponds to the surfaceForm's char at index i and assigns it as {@link TrieNode} current.
     * If current is not null, it adds all words of current to the words {@link HashSet}.
     *
     * @param surfaceForm String input.
     * @return words {@link HashSet}.
     */
    public HashSet<Word> getWordsWithPrefix(String surfaceForm) {
        TrieNode current = rootNode;
        HashSet<Word> words = new HashSet<>();
        for (int i = 0; i < surfaceForm.length(); i++) {
            current = current.getChild(surfaceForm.charAt(i));
            if (current != null) {
                if (current.getWords() != null) {
                    words.addAll(current.getWords());
                }
            } else {
                break;
            }
        }
        return words;
    }

    /**
     * The getCompoundWordStartingWith method takes a String hash. First it creates a {@link TrieNode} current and assigns
     * the rootNode to it. Then it loops i times where i ranges from 0 to length of given hash and assigns current's child that
     * corresponds to the hash's char at index i and assigns it as current. If current is null, it returns null.
     * <p>
     * If current is not null,  it loops through the words of current {@link TrieNode} and if it is a Portmanteau word, it
     * directly returns the word.
     *
     * @param hash String input.
     * @return null if {@link TrieNode} is null, otherwise portmanteau word.
     */
    public TxtWord getCompoundWordStartingWith(String hash) {
        TrieNode current = rootNode;
        for (int i = 0; i < hash.length(); i++) {
            current = current.getChild(hash.charAt(i));
            if (current == null) {
                return null;
            }
        }
        if (current != null && current.getWords() != null) {
            for (Word word : current.getWords()) {
                if (((TxtWord) word).isPortmanteau()) {
                    return (TxtWord) word;
                }
            }
        }
        return null;
    }
}
