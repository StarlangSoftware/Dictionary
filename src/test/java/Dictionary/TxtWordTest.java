package Dictionary;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TxtWordTest {
    TxtDictionary dictionary;

    @Before
    public void setUp() throws Exception {
        dictionary = new TxtDictionary();
    }

    @Test
    public void testVerbType() {
        HashMap<String, Integer> verbs = new HashMap<String, Integer>();
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            String verbType = word.verbType();
            if (verbs.containsKey(verbType)){
                verbs.put(verbType, verbs.get(verbType) + 1);
            } else {
                verbs.put(verbType, 1);
            }
        }
        assertEquals(5, (int) verbs.get("F2P1-NO-REF"));
        assertEquals(1, (int) verbs.get("F3P1-NO-REF"));
        assertEquals(1, (int) verbs.get("F4P1-NO-REF"));
        assertEquals(14, (int) verbs.get("F4PR-NO-REF"));
        assertEquals(2, (int) verbs.get("F4PL-NO-REF"));
        assertEquals(67, (int) verbs.get("F4PW-NO-REF"));
        assertEquals(10, (int) verbs.get("F5PL-NO-REF"));
        assertEquals(111, (int) verbs.get("F5PR-NO-REF"));
        assertEquals(1, (int) verbs.get("F5PW-NO-REF"));
        assertEquals(2, (int) verbs.get("F1P1"));
        assertEquals(11, (int) verbs.get("F2P1"));
        assertEquals(4, (int) verbs.get("F3P1"));
        assertEquals(1, (int) verbs.get("F4P1"));
        assertEquals(1, (int) verbs.get("F5P1"));
        assertEquals(7, (int) verbs.get("F6P1"));
        assertEquals(2, (int) verbs.get("F2PL"));
        assertEquals(49, (int) verbs.get("F4PL"));
        assertEquals(18, (int) verbs.get("F5PL"));
        assertEquals(173, (int) verbs.get("F4PR"));
        assertEquals(808, (int) verbs.get("F5PR"));
        assertEquals(1396, (int) verbs.get("F4PW"));
        assertEquals(13, (int) verbs.get("F5PW"));
    }

    @Test
    public void testIsNominal() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isNominal()){
                count++;
            }
        }
        assertEquals(30601, count);
    }

    @Test
    public void testIsPassive() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isPassive()){
                count++;
            }
        }
        assertEquals(10, count);
    }

    @Test
    public void testIsAbbreviation() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isAbbreviation()){
                count++;
            }
        }
        assertEquals(102, count);
    }

    @Test
    public void testIsInterjection() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isInterjection()){
                count++;
            }
        }
        assertEquals(104, count);
    }

    @Test
    public void testIsDuplicate() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isDuplicate()){
                count++;
            }
        }
        assertEquals(124, count);
    }

    @Test
    public void testIsAdjective() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isAdjective()){
                count++;
            }
        }
        assertEquals(9679, count);
    }

    @Test
    public void testIsPronoun() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isPronoun()){
                count++;
            }
        }
        assertEquals(49, count);
    }

    @Test
    public void testIsQuestion() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isQuestion()){
                count++;
            }
        }
        assertEquals(4, count);
    }

    @Test
    public void testIsVerb() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isVerb()){
                count++;
            }
        }
        assertEquals(5042, count);
    }

    @Test
    public void testIsPortmanteau() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isPortmanteau()){
                count++;
            }
        }
        assertEquals(1294, count);
    }

    @Test
    public void testIsDeterminer() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isDeterminer()){
                count++;
            }
        }
        assertEquals(13, count);
    }

    @Test
    public void testIsConjunction() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isConjunction()){
                count++;
            }
        }
        assertEquals(51, count);
    }

    @Test
    public void testIsAdverb() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isAdverb()){
                count++;
            }
        }
        assertEquals(1849, count);
    }

    @Test
    public void testIsPostP() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isPostP()){
                count++;
            }
        }
        assertEquals(49, count);
    }

    @Test
    public void testIsPortmanteauEndingWithSI() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isPortmanteauEndingWithSI()){
                count++;
            }
        }
        assertEquals(178, count);
    }

    @Test
    public void testIsPortmanteauFacedVowelEllipsis() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isPortmanteauFacedVowelEllipsis()){
                count++;
            }
        }
        assertEquals(25, count);
    }

    @Test
    public void testIsPortmanteauFacedSoftening() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isPortmanteauFacedSoftening()){
                count++;
            }
        }
        assertEquals(348, count);
    }

    @Test
    public void testIsSuffix() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isSuffix()){
                count++;
            }
        }
        assertEquals(3, count);
    }

    @Test
    public void testIsProperNoun() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isProperNoun()){
                count++;
            }
        }
        assertEquals(19012, count);
    }

    @Test
    public void testIsPlural() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isPlural()){
                count++;
            }
        }
        assertEquals(398, count);
    }

    @Test
    public void testIsNumeral() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isNumeral()){
                count++;
            }
        }
        assertEquals(33, count);
    }

    @Test
    public void testNotObeysVowelHarmonyDuringAgglutination() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.notObeysVowelHarmonyDuringAgglutination()){
                count++;
            }
        }
        assertEquals(315, count);
    }

    @Test
    public void testObeysAndNotObeysVowelHarmonyDuringAgglutination() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.obeysAndNotObeysVowelHarmonyDuringAgglutination()){
                count++;
            }
        }
        assertEquals(5, count);
    }

    @Test
    public void testRootSoftenDuringSuffixation() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.rootSoftenDuringSuffixation()){
                count++;
            }
        }
        assertEquals(5529, count);
    }

    @Test
    public void testRootSoftenAndNotSoftenDuringSuffixation() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.rootSoftenAndNotSoftenDuringSuffixation()){
                count++;
            }
        }
        assertEquals(14, count);
    }

    @Test
    public void testVerbSoftenDuringSuffixation() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.verbSoftenDuringSuffixation()){
                count++;
            }
        }
        assertEquals(87, count);
    }

    @Test
    public void testNounSoftenDuringSuffixation() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.nounSoftenDuringSuffixation()){
                count++;
            }
        }
        assertEquals(5443, count);
    }

    @Test
    public void testEndingKChangesIntoG() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.endingKChangesIntoG()){
                count++;
            }
        }
        assertEquals(26, count);
    }

    @Test
    public void testIsExceptional() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.isExceptional()){
                count++;
            }
        }
        assertEquals(31, count);
    }

    @Test
    public void testDuplicatesDuringSuffixation() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.duplicatesDuringSuffixation()){
                count++;
            }
        }
        assertEquals(36, count);
    }

    @Test
    public void testDuplicatesAndNotDuplicatesDuringSuffixation() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.duplicatesAndNotDuplicatesDuringSuffixation()){
                count++;
            }
        }
        assertEquals(4, count);
    }

    @Test
    public void testLastIdropsDuringSuffixation() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.lastIdropsDuringSuffixation()){
                count++;
            }
        }
        assertEquals(167, count);
    }

    @Test
    public void testLastIDropsAndNotDropDuringSuffixation() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.lastIDropsAndNotDropDuringSuffixation()){
                count++;
            }
        }
        assertEquals(4, count);
    }

    @Test
    public void testTakesRelativeSuffixKi() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.takesRelativeSuffixKi()){
                count++;
            }
        }
        assertEquals(16, count);
    }

    @Test
    public void testTakesRelativeSuffixKu() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.takesRelativeSuffixKu()){
                count++;
            }
        }
        assertEquals(4, count);
    }

    @Test
    public void testLastIdropsDuringPassiveSuffixation() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.lastIdropsDuringPassiveSuffixation()){
                count++;
            }
        }
        assertEquals(11, count);
    }

    @Test
    public void testVowelAChangesToIDuringYSuffixation() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.vowelAChangesToIDuringYSuffixation()){
                count++;
            }
        }
        assertEquals(1300, count);
    }

    @Test
    public void testVowelEChangesToIDuringYSuffixation() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.vowelEChangesToIDuringYSuffixation()){
                count++;
            }
        }
        assertEquals(2, count);
    }

    @Test
    public void testTakesSuffixIRAsAorist() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (!word.takesSuffixIRAsAorist()){
                count++;
            }
        }
        assertEquals(51, count);
    }

    @Test
    public void testTakesSuffixDIRAsFactitive() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (!word.takesSuffixDIRAsFactitive()){
                count++;
            }
        }
        assertEquals(197, count);
    }

    @Test
    public void testShowsSuRegularities() {
        int count = 0;
        for (int i = 0; i < dictionary.size(); i++){
            TxtWord word = (TxtWord) dictionary.getWord(i);
            if (word.showsSuRegularities()){
                count++;
            }
        }
        assertEquals(5, count);
    }
}