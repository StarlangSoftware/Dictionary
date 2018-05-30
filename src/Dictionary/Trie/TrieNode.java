package Dictionary.Trie;

import Dictionary.Word;

import java.util.HashMap;
import java.util.HashSet;

public class TrieNode {
    private HashMap<Character, TrieNode> children = null;
    private HashSet<Word> words = null;

    public TrieNode(){
        children = new HashMap<>();
    }

    private void addWord(String word, int index, Word root){
        TrieNode child;
        if (index == word.length()){
            if (words == null){
                words = new HashSet<>();
                words.add(root);
            } else {
                words.add(root);
            }
            return;
        }
        Character ch = word.charAt(index);
        if (children.containsKey(ch)){
            child = children.get(ch);
        } else {
            child = new TrieNode();
        }
        child.addWord(word, index + 1, root);
        children.put(ch, child);
    }

    public void addWord(String word, Word root){
        addWord(word, 0, root);
    }

    public TrieNode getChild(Character ch){
        return children.get(ch);
    }

    public HashSet<Word> getWords(){
        return words;
    }

}
