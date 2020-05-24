package Dictionary;

import Dictionary.Trie.Trie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TxtDictionaryTest {
    TxtDictionary dictionary;

    @Before
    public void setUp() throws Exception {
        dictionary = new TxtDictionary();
    }

    @Test
    public void testGetCorrectForm() {
        for (int i = 0; i < dictionary.size(); i++){
            assertNull(dictionary.getCorrectForm(dictionary.getWord(i).getName()));
        }
    }

    @Test
    public void testPrepareTrie(){
        Trie trie = dictionary.prepareTrie();
        assertTrue(trie.getWordsWithPrefix("bana").contains(new Word("ben")));
        assertTrue(trie.getWordsWithPrefix("metni").contains(new Word("metin")));
        assertTrue(trie.getWordsWithPrefix("ağzı").contains(new Word("ağız")));
        assertTrue(trie.getWordsWithPrefix("ayrıldı").contains(new Word("ayır")));
        assertTrue(trie.getWordsWithPrefix("buyruldu").contains(new Word("buyur")));
        assertTrue(trie.getWordsWithPrefix("ahdi").contains(new Word("ahit")));
        assertTrue(trie.getWordsWithPrefix("kaybı").contains(new Word("kayıp")));
        assertTrue(trie.getWordsWithPrefix("kutbu").contains(new Word("kutup")));
        assertTrue(trie.getWordsWithPrefix("ademelmaları").contains(new Word("ademelması")));
        assertTrue(trie.getWordsWithPrefix("ağaçküpeleri").contains(new Word("ağaçküpesi")));
        assertTrue(trie.getWordsWithPrefix("ağaçlığı").contains(new Word("ağaçlık")));
        assertTrue(trie.getWordsWithPrefix("sumağı").contains(new Word("sumak")));
        assertTrue(trie.getWordsWithPrefix("deveboyunları").contains(new Word("deveboynu")));
        assertTrue(trie.getWordsWithPrefix("gökcisimleri").contains(new Word("gökcismi")));
        assertTrue(trie.getWordsWithPrefix("gökkuşakları").contains(new Word("gökkuşağı")));
        assertTrue(trie.getWordsWithPrefix("hintarmutları").contains(new Word("hintarmudu")));
        assertTrue(trie.getWordsWithPrefix("hintpirinçleri").contains(new Word("hintpirinci")));
        assertTrue(trie.getWordsWithPrefix("sudolapları").contains(new Word("sudolabı")));
        assertTrue(trie.getWordsWithPrefix("yiyor").contains(new Word("ye")));
        assertTrue(trie.getWordsWithPrefix("diyor").contains(new Word("de")));
        assertTrue(trie.getWordsWithPrefix("depoluyor").contains(new Word("depola")));
        assertTrue(trie.getWordsWithPrefix("dışlıyor").contains(new Word("dışla")));
        assertTrue(trie.getWordsWithPrefix("fiyongu").contains(new Word("fiyonk")));
        assertTrue(trie.getWordsWithPrefix("gongu").contains(new Word("gonk")));
    }
}