package Dictionary;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {

    @Test
    public void testCharCount() {
        Word word = new Word("ali");
        assertEquals(3, word.charCount());
        word = new Word("Veli");
        assertEquals(4, word.charCount());
        word = new Word("ahmet");
        assertEquals(5, word.charCount());
        word = new Word("çöğüşı");
        assertEquals(6, word.charCount());
    }

    @Test
    public void testIsCapital() {
        assertFalse(Word.isCapital("ali"));
        assertTrue(Word.isCapital("Ali"));
        assertFalse(Word.isCapital("ısı"));
        assertTrue(Word.isCapital("Isıtıcı"));
        assertFalse(Word.isCapital("çin"));
        assertTrue(Word.isCapital("Çin"));
        assertFalse(Word.isCapital("ödül"));
        assertTrue(Word.isCapital("Ödül"));
        assertFalse(Word.isCapital("şişe"));
        assertTrue(Word.isCapital("Şişe"));
        assertFalse(Word.isCapital("üretici"));
        assertTrue(Word.isCapital("Üretici"));
    }

    @Test
    public void testIsPunctuation() {
        assertTrue(Word.isPunctuation("."));
        assertTrue(Word.isPunctuation("..."));
        assertTrue(Word.isPunctuation("["));
        assertTrue(Word.isPunctuation("]"));
        assertTrue(Word.isPunctuation("\u2026"));
        assertTrue(Word.isPunctuation("%"));
        assertTrue(Word.isPunctuation("&"));
        assertTrue(Word.isPunctuation("="));
        assertTrue(Word.isPunctuation("\u0060\u0060"));
        assertTrue(Word.isPunctuation("\u0060"));
        assertTrue(Word.isPunctuation("''"));
        assertTrue(Word.isPunctuation("$"));
        assertTrue(Word.isPunctuation("!"));
        assertTrue(Word.isPunctuation("?"));
        assertTrue(Word.isPunctuation(","));
        assertTrue(Word.isPunctuation(":"));
        assertTrue(Word.isPunctuation("--"));
        assertTrue(Word.isPunctuation(";"));
        assertTrue(Word.isPunctuation("("));
        assertTrue(Word.isPunctuation(")"));
        assertTrue(Word.isPunctuation("'"));
        assertTrue(Word.isPunctuation("\""));
        assertTrue(Word.isPunctuation("\u201C"));
        assertTrue(Word.isPunctuation("\u2018"));
        assertTrue(Word.isPunctuation("\u201D"));
        assertTrue(Word.isPunctuation("…"));
        assertTrue(Word.isPunctuation("\u25CF"));
        assertTrue(Word.isPunctuation("/"));
        assertTrue(Word.isPunctuation("-"));
        assertTrue(Word.isPunctuation("+"));
        assertTrue(Word.isPunctuation("-LRB-"));
        assertTrue(Word.isPunctuation("-RRB-"));
        assertTrue(Word.isPunctuation("-LCB-"));
        assertTrue(Word.isPunctuation("-RCB-"));
        assertTrue(Word.isPunctuation("-LSB-"));
        assertTrue(Word.isPunctuation("-RSB-"));
    }

    @Test
    public void testIsHonorific() {
        assertTrue(Word.isHonorific("bay"));
        assertTrue(Word.isHonorific("Bay"));
        assertTrue(Word.isHonorific("BAY"));
        assertTrue(Word.isHonorific("bayan"));
        assertTrue(Word.isHonorific("Bayan"));
        assertTrue(Word.isHonorific("BAYAN"));
    }

    @Test
    public void testIsOrganization() {
        assertTrue(Word.isOrganization("corp"));
        assertTrue(Word.isOrganization("Corp"));
        assertTrue(Word.isOrganization("inc."));
        assertTrue(Word.isOrganization("co."));
        assertTrue(Word.isOrganization("Co."));
    }

    @Test
    public void testIsMoney() {
        assertTrue(Word.isMoney("dolar"));
        assertTrue(Word.isMoney("sterlin"));
        assertTrue(Word.isMoney("paunt"));
        assertTrue(Word.isMoney("ons"));
        assertTrue(Word.isMoney("ruble"));
        assertTrue(Word.isMoney("mark"));
        assertTrue(Word.isMoney("frank"));
        assertTrue(Word.isMoney("sent"));
        assertTrue(Word.isMoney("cent"));
        assertTrue(Word.isMoney("yen"));
        assertTrue(Word.isMoney("Dolar"));
        assertTrue(Word.isMoney("Sterlin"));
        assertTrue(Word.isMoney("Paunt"));
        assertTrue(Word.isMoney("Ons"));
        assertTrue(Word.isMoney("Ruble"));
        assertTrue(Word.isMoney("Mark"));
        assertTrue(Word.isMoney("Frank"));
        assertTrue(Word.isMoney("Sent"));
        assertTrue(Word.isMoney("Cent"));
        assertTrue(Word.isMoney("Yen"));
        assertTrue(Word.isMoney("3000$"));
        assertFalse(Word.isMoney("3000"));
    }

    @Test
    public void testIsTime() {
        assertTrue(Word.isTime("9:1"));
        assertTrue(Word.isTime("9:12"));
        assertTrue(Word.isTime("12:1"));
        assertTrue(Word.isTime("12:13"));
        assertTrue(Word.isTime("1:9:1"));
        assertTrue(Word.isTime("1:9:12"));
        assertTrue(Word.isTime("1:12:1"));
        assertTrue(Word.isTime("2:13:14"));
        assertTrue(Word.isTime("12:9:1"));
        assertTrue(Word.isTime("11:9:12"));
        assertTrue(Word.isTime("10:12:1"));
        assertTrue(Word.isTime("21:13:14"));
        assertFalse(Word.isTime("12"));
        assertFalse(Word.isTime("1:1:1:1"));
        assertTrue(Word.isTime("ocak"));
        assertTrue(Word.isTime("şubat"));
        assertTrue(Word.isTime("mart"));
        assertTrue(Word.isTime("nisan"));
        assertTrue(Word.isTime("mayıs"));
        assertTrue(Word.isTime("haziran"));
        assertTrue(Word.isTime("temmuz"));
        assertTrue(Word.isTime("ağustos"));
        assertTrue(Word.isTime("eylül"));
        assertTrue(Word.isTime("ekim"));
        assertTrue(Word.isTime("kasım"));
        assertTrue(Word.isTime("aralık"));
        assertTrue(Word.isTime("Ocak"));
        assertTrue(Word.isTime("Şubat"));
        assertTrue(Word.isTime("Mart"));
        assertTrue(Word.isTime("Nisan"));
        assertTrue(Word.isTime("Mayıs"));
        assertTrue(Word.isTime("Haziran"));
        assertTrue(Word.isTime("Temmuz"));
        assertTrue(Word.isTime("Ağustos"));
        assertTrue(Word.isTime("Eylül"));
        assertTrue(Word.isTime("Ekim"));
        assertTrue(Word.isTime("Kasım"));
        assertTrue(Word.isTime("Aralık"));
        assertTrue(Word.isTime("pazartesi"));
        assertTrue(Word.isTime("salı"));
        assertTrue(Word.isTime("çarşamba"));
        assertTrue(Word.isTime("perşembe"));
        assertTrue(Word.isTime("cuma"));
        assertTrue(Word.isTime("cumartesi"));
        assertTrue(Word.isTime("pazar"));
        assertTrue(Word.isTime("Pazartesi"));
        assertTrue(Word.isTime("Salı"));
        assertTrue(Word.isTime("Çarşamba"));
        assertTrue(Word.isTime("Perşembe"));
        assertTrue(Word.isTime("Cuma"));
        assertTrue(Word.isTime("Cumartesi"));
        assertTrue(Word.isTime("Pazar"));
        assertFalse(Word.isTime("1234567"));
        assertFalse(Word.isTime("-1234"));
        assertFalse(Word.isTime("1834"));
        assertFalse(Word.isTime("2201"));
        assertTrue(Word.isTime("1934"));
    }

}