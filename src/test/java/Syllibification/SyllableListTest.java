package Syllibification;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SyllableListTest {

    @Test
    public void testSyllableList() throws IrregularWordException {
        SyllableList syllableList;
        syllableList = new SyllableList("başöğretmen");
        assertEquals(syllableList.getSyllables(), new ArrayList<>(Arrays.asList(new String[]{"ba", "şöğ", "ret", "men"})));
        syllableList = new SyllableList("fransa");
        assertEquals(syllableList.getSyllables(), new ArrayList<>(Arrays.asList(new String[]{"fran", "sa"})));
        syllableList = new SyllableList("traktör");
        assertEquals(syllableList.getSyllables(), new ArrayList<>(Arrays.asList(new String[]{"trak", "tör"})));
        syllableList = new SyllableList("kraker");
        assertEquals(syllableList.getSyllables(), new ArrayList<>(Arrays.asList(new String[]{"kra", "ker"})));
        syllableList = new SyllableList("trake");
        assertEquals(syllableList.getSyllables(), new ArrayList<>(Arrays.asList(new String[]{"tra", "ke"})));
        syllableList = new SyllableList("ilköğretim");
        assertEquals(syllableList.getSyllables(), new ArrayList<>(Arrays.asList(new String[]{"il", "köğ", "re", "tim"})));
        syllableList = new SyllableList("semizotu");
        assertEquals(syllableList.getSyllables(), new ArrayList<>(Arrays.asList(new String[]{"se", "mi", "zo", "tu"})));
        syllableList = new SyllableList("ali");
        assertEquals(syllableList.getSyllables(), new ArrayList<>(Arrays.asList(new String[]{"a", "li"})));
        syllableList = new SyllableList("türk");
        assertEquals(syllableList.getSyllables(), new ArrayList<>(Arrays.asList(new String[]{"türk"})));
        syllableList = new SyllableList("kırktürk");
        assertEquals(syllableList.getSyllables(), new ArrayList<>(Arrays.asList(new String[]{"kırk", "türk"})));
        syllableList = new SyllableList("kardanadam");
        assertEquals(syllableList.getSyllables(), new ArrayList<>(Arrays.asList(new String[]{"kar", "da", "na", "dam"})));
        syllableList = new SyllableList("çöpadam");
        assertEquals(syllableList.getSyllables(), new ArrayList<>(Arrays.asList(new String[]{"çö", "pa", "dam"})));
        syllableList = new SyllableList("faal");
        assertEquals(syllableList.getSyllables(), new ArrayList<>(Arrays.asList(new String[]{"fa", "al"})));
    }

}