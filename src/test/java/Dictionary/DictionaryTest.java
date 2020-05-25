package Dictionary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DictionaryTest {
    TxtDictionary dictionary;
    TxtDictionary lowerCaseDictionary, mixedCaseDictionary;

    @Before
    public void setUp() throws Exception {
        dictionary = new TxtDictionary();
        lowerCaseDictionary = new TxtDictionary("lowercase.txt", new TurkishWordComparator());
        mixedCaseDictionary = new TxtDictionary("mixedcase.txt", new TurkishIgnoreCaseWordComparator());
    }

    @Test
    public void testGetWordIndex() {
        assertEquals(0, lowerCaseDictionary.getWordIndex("a"));
        assertEquals(3, lowerCaseDictionary.getWordIndex("ç"));
        assertEquals(8, lowerCaseDictionary.getWordIndex("ğ"));
        assertEquals(10, lowerCaseDictionary.getWordIndex("ı"));
        assertEquals(18, lowerCaseDictionary.getWordIndex("ö"));
        assertEquals(22, lowerCaseDictionary.getWordIndex("ş"));
        assertEquals(25, lowerCaseDictionary.getWordIndex("ü"));
        assertEquals(28, lowerCaseDictionary.getWordIndex("z"));
        assertTrue(mixedCaseDictionary.getWordIndex("A") == 0 || mixedCaseDictionary.getWordIndex("A") == 1);
        assertTrue(mixedCaseDictionary.getWordIndex("Ç") == 6 || mixedCaseDictionary.getWordIndex("Ç") == 7);
        assertTrue(mixedCaseDictionary.getWordIndex("Ğ") == 16 || mixedCaseDictionary.getWordIndex("Ğ") == 17);
        assertTrue(mixedCaseDictionary.getWordIndex("I") == 20 || mixedCaseDictionary.getWordIndex("I") == 21);
        assertTrue(mixedCaseDictionary.getWordIndex("İ") == 22 || mixedCaseDictionary.getWordIndex("İ") == 23);
        assertTrue(mixedCaseDictionary.getWordIndex("Ş") == 44 || mixedCaseDictionary.getWordIndex("Ş") == 45);
        assertTrue(mixedCaseDictionary.getWordIndex("Ü") == 50 || mixedCaseDictionary.getWordIndex("Ü") == 51);
        assertTrue(mixedCaseDictionary.getWordIndex("Z") == 56 || mixedCaseDictionary.getWordIndex("Z") == 57);
    }

    @Test
    public void testSize() {
        assertEquals(29, lowerCaseDictionary.size());
        assertEquals(58, mixedCaseDictionary.size());
        assertEquals(58731, dictionary.size());
    }

    @Test
    public void testGetWord() {
        assertEquals("a", lowerCaseDictionary.getWord(0).name);
        assertEquals("ç", lowerCaseDictionary.getWord(3).name);
        assertEquals("ğ", lowerCaseDictionary.getWord(8).name);
        assertEquals("ı", lowerCaseDictionary.getWord(10).name);
        assertEquals("ö", lowerCaseDictionary.getWord(18).name);
        assertEquals("ş", lowerCaseDictionary.getWord(22).name);
        assertEquals("ü", lowerCaseDictionary.getWord(25).name);
        assertEquals("z", lowerCaseDictionary.getWord(28).name);
        for (int i = 0; i < dictionary.size(); i++){
            assertNotNull(dictionary.getWord(i));
        }
    }

    @Test
    public void testLongestWordSize() {
        assertEquals(1, lowerCaseDictionary.longestWordSize());
        assertEquals(1, mixedCaseDictionary.longestWordSize());
        assertEquals(21, dictionary.longestWordSize());
    }

    @Test
    public void testGetWordStartingWith() {
        assertEquals(20, lowerCaseDictionary.getWordStartingWith("q"));
        assertEquals(27, lowerCaseDictionary.getWordStartingWith("w"));
        assertEquals(27, lowerCaseDictionary.getWordStartingWith("x"));
        assertEquals(40, mixedCaseDictionary.getWordStartingWith("Q"));
        assertEquals(54, mixedCaseDictionary.getWordStartingWith("W"));
        assertEquals(54, mixedCaseDictionary.getWordStartingWith("X"));
    }
}