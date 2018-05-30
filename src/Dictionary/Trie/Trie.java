package Dictionary.Trie;

import Dictionary.TxtWord;
import Dictionary.Word;

import java.util.HashSet;

public class Trie {
    private TrieNode rootNode;

    public Trie(){
        rootNode = new TrieNode();
    }

    public void addWord(String word, Word root){
        rootNode.addWord(word, root);
    }

    public HashSet<Word> getWordsWithPrefix(String surfaceForm){
        TrieNode current = rootNode;
        HashSet<Word> words = new HashSet<>();
        for (int i = 0; i < surfaceForm.length(); i++){
            current = current.getChild(surfaceForm.charAt(i));
            if (current != null){
                if (current.getWords() != null){
                    words.addAll(current.getWords());
                }
            } else {
                break;
            }
        }
        return words;
    }

    public TxtWord getCompoundWordStartingWith(String hash){
        TrieNode current = rootNode;
        for (int i = 0; i < hash.length(); i++){
            current = current.getChild(hash.charAt(i));
            if (current == null){
                return null;
            }
        }
        if (current != null && current.getWords() != null){
            for (Word word : current.getWords()){
                if (((TxtWord) word).isPortmanteau()){
                    return (TxtWord) word;
                }
            }
        }
        return null;
    }
}
