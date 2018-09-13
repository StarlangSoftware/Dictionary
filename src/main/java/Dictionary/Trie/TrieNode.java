package Dictionary.Trie;

import Dictionary.Word;

import java.util.HashMap;
import java.util.HashSet;

public class TrieNode {
    private HashMap<Character, TrieNode> children = null;
    private HashSet<Word> words = null;

    /**
     * A constructor of {@link TrieNode} class which creates a new children {@link HashMap}.
     */
    public TrieNode() {
        children = new HashMap<>();
    }

    /**
     * The addWord method takes a String word, an index, and a {@link Word} root as inputs. First it creates a {@link TrieNode} child
     * and if words {@link HashSet} is null it creates a new {@link HashSet} and add the given root word to this {@link HashSet}, if it
     * is not null, it directly adds it to the {@link HashSet} when the given index is equal to the length of given word.
     * <p>
     * Then, it extracts the character at given index of given word and if children {@link HashMap} contains a mapping for the
     * extracted character, it assigns it to the {@link TrieNode} child, else it creates a new {@link TrieNode} and assigns it to the
     * child. At the end, it recursively calls the addWord method with the next index of child and puts the character with
     * the child into the children {@link HashMap}.
     *
     * @param word  String input.
     * @param index Integer index.
     * @param root  {@link Word} input to add.
     */
    private void addWord(String word, int index, Word root) {
        TrieNode child;
        if (index == word.length()) {
            if (words == null) {
                words = new HashSet<>();
                words.add(root);
            } else {
                words.add(root);
            }
            return;
        }
        Character ch = word.charAt(index);
        if (children.containsKey(ch)) {
            child = children.get(ch);
        } else {
            child = new TrieNode();
        }
        child.addWord(word, index + 1, root);
        children.put(ch, child);
    }

    /**
     * The addWord method takes a String word and a {@link Word} type root as inputs. It calls addWord method with index 0.
     *
     * @param word String input.
     * @param root {@link Word} type input.
     */
    public void addWord(String word, Word root) {
        addWord(word, 0, root);
    }

    /**
     * The getChild method takes a {@link Character} and gets its corresponding value from children {@link HashMap}.
     *
     * @param ch {@link Character} input.
     * @return the value from children {@link HashMap}.
     */
    public TrieNode getChild(Character ch) {
        return children.get(ch);
    }

    /**
     * The getWords method returns the words {@link HashSet}.
     *
     * @return the words {@link HashSet}.
     */
    public HashSet<Word> getWords() {
        return words;
    }

}
