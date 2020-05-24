package Dictionary.Trie;

import Dictionary.TxtDictionary;
import Dictionary.Word;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {
    Trie simpleTrie, complexTrie;

    @Before
    public void setUp() throws Exception {
        simpleTrie = new Trie();
        simpleTrie.addWord("azı", new Word("azı"));
        simpleTrie.addWord("az", new Word("az"));
        simpleTrie.addWord("ad", new Word("ad"));
        simpleTrie.addWord("adi", new Word("adi"));
        simpleTrie.addWord("adil", new Word("adil"));
        simpleTrie.addWord("a", new Word("a"));
        simpleTrie.addWord("adilane", new Word("adilane"));
        simpleTrie.addWord("ısı", new Word("ısı"));
        simpleTrie.addWord("ısıtıcı", new Word("ısıtıcı"));
        simpleTrie.addWord("ölü", new Word("ölü"));
        simpleTrie.addWord("ölüm", new Word("ölüm"));
        simpleTrie.addWord("ören", new Word("ören"));
        simpleTrie.addWord("örgü", new Word("örgü"));
        complexTrie = new Trie();
        TxtDictionary dictionary = new TxtDictionary();
        for (int i = 0; i < dictionary.size(); i++){
            complexTrie.addWord(dictionary.getWord(i).getName(), dictionary.getWord(i));
        }
    }

    @Test
    public void getWordsWithPrefixSimple() {
        assertArrayEquals(new Word[]{new Word("a")}, simpleTrie.getWordsWithPrefix("a").toArray());
        assertArrayEquals(new Word[]{new Word("a"), new Word("ad")}, simpleTrie.getWordsWithPrefix("ad").toArray());
        assertArrayEquals(new Word[]{new Word("a"), new Word("ad"), new Word("adi")}, simpleTrie.getWordsWithPrefix("adi").toArray());
        assertArrayEquals(new Word[]{new Word("a"), new Word("ad"), new Word("adi"), new Word("adil")}, simpleTrie.getWordsWithPrefix("adil").toArray());
        assertArrayEquals(new Word[]{new Word("a"), new Word("ad"), new Word("adi"), new Word("adilane"), new Word("adil")}, simpleTrie.getWordsWithPrefix("adilane").toArray());
        assertArrayEquals(new Word[]{new Word("ölü")}, simpleTrie.getWordsWithPrefix("ölü").toArray());
        assertArrayEquals(new Word[]{new Word("ölü"), new Word("ölüm")}, simpleTrie.getWordsWithPrefix("ölüm").toArray());
        assertArrayEquals(new Word[]{new Word("ısı")}, simpleTrie.getWordsWithPrefix("ısı").toArray());
        assertArrayEquals(new Word[]{new Word("ısıtıcı"), new Word("ısı")}, simpleTrie.getWordsWithPrefix("ısıtıcı").toArray());
    }

    @Test
    public void getWordsWithPrefixComplex() {
        assertArrayEquals(new Word[]{new Word("a")}, complexTrie.getWordsWithPrefix("a").toArray());
        assertArrayEquals(new Word[]{new Word("a"), new Word("ad")}, complexTrie.getWordsWithPrefix("ad").toArray());
        assertArrayEquals(new Word[]{new Word("a"), new Word("ad"), new Word("adi")}, complexTrie.getWordsWithPrefix("adi").toArray());
        assertArrayEquals(new Word[]{new Word("a"), new Word("ad"), new Word("adi"), new Word("adil")}, complexTrie.getWordsWithPrefix("adil").toArray());
        assertArrayEquals(new Word[]{new Word("a"), new Word("ad"), new Word("adi"), new Word("adilane"), new Word("adil")}, complexTrie.getWordsWithPrefix("adilane").toArray());
        assertArrayEquals(new Word[]{new Word("ölü"), new Word("öl")}, complexTrie.getWordsWithPrefix("ölü").toArray());
        assertArrayEquals(new Word[]{new Word("ölü"), new Word("öl"), new Word("ölüm")}, complexTrie.getWordsWithPrefix("ölüm").toArray());
        assertArrayEquals(new Word[]{new Word("ı"), new Word("ısı")}, complexTrie.getWordsWithPrefix("ısı").toArray());
        assertArrayEquals(new Word[]{new Word("ı"), new Word("ısıtıcı"), new Word("ısıt"), new Word("ısı")}, complexTrie.getWordsWithPrefix("ısıtıcı").toArray());
    }

}