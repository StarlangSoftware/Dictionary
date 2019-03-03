package Dictionary;

import Dictionary.Trie.Trie;

import java.util.HashSet;

public class TestDictionary {
    public static void main(String[] args){
        TxtDictionary dictionary = new TxtDictionary();
        Trie trie = dictionary.prepareTrie();
        HashSet<Word> set = trie.getWordsWithPrefix("ab");
    }
}
