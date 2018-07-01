package Language;

public class TurkishLanguage extends Language {
    public static final String VOWELS = "aeıioöuüâî";
    public static final String BACK_VOWELS = "aıouâ";
    public static final String FRONT_VOWELS = "eiöüî";
    public static final String BACK_ROUNDED_VOWELS = "ou";
    public static final String BACK_UNROUNDED_VOWELS = "aıâ";
    public static final String FRONT_ROUNDED_VOWELS = "öü";
    public static final String FRONT_UNROUNDED_VOWELS = "eiî";
    public static final String CONSONANT_DROPS = "nsy";
    public static final String CONSONANTS = "bcçdfgğhjklmnprsştvyzxqw";
    public static final String SERT_SESSIZ = "çfhkpsşt";
    public static final String LOWERCASE_LETTERS = "abcçdefgğhıijklmnoöprsştuüvyz";
    public static final String UPPERCASE_LETTERS = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ";
    public static final String LETTERS = LOWERCASE_LETTERS + UPPERCASE_LETTERS;

    /**
     * The isVowel method takes a character as an input and returns true if given character is a vowel.
     *
     * @param ch {@link Character} input to check.
     * @return true if given character is a vowel.
     */
    public static boolean isVowel(char ch) {
        return (VOWELS.indexOf(ch) != -1);
    }

    /**
     * The isBackVowel method takes a character as an input and returns true if given character is a back vowel.
     *
     * @param ch {@link Character} input to check.
     * @return true if given character is a back vowel.
     */
    public static boolean isBackVowel(char ch) {
        return (BACK_VOWELS.indexOf(ch) != -1);
    }

    /**
     * The isFrontVowel method takes a character as an input and returns true if given character is a front vowel.
     *
     * @param ch {@link Character} input to check.
     * @return true if given character is a front vowel.
     */
    public static boolean isFrontVowel(char ch) {
        return (FRONT_VOWELS.indexOf(ch) != -1);
    }

    /**
     * The isBackRoundedVowel method takes a character as an input and returns true if given character is a back rounded vowel.
     *
     * @param ch {@link Character} input to check.
     * @return true if given character is a back rounded vowel.
     */
    public static boolean isBackRoundedVowel(char ch) {
        return (BACK_ROUNDED_VOWELS.indexOf(ch) != -1);
    }

    /**
     * The isFrontRoundedVowel method takes a character as an input and returns true if given character is a front rounded vowel.
     *
     * @param ch {@link Character} input to check.
     * @return true if given character is a front rounded vowel.
     */
    public static boolean isFrontRoundedVowel(char ch) {
        return (FRONT_ROUNDED_VOWELS.indexOf(ch) != -1);
    }

    /**
     * The isBackUnroundedVowel method takes a character as an input and returns true if given character is a back unrounded vowel.
     *
     * @param ch {@link Character} input to check.
     * @return true if given character is a back unrounded vowel.
     */
    public static boolean isBackUnroundedVowel(char ch) {
        return (BACK_UNROUNDED_VOWELS.indexOf(ch) != -1);
    }

    /**
     * The isFrontUnroundedVowel method takes a character as an input and returns true if given character is a front unrounded vowel.
     *
     * @param ch {@link Character} input to check.
     * @return true if given character is a front unrounded vowel.
     */
    public static boolean isFrontUnroundedVowel(char ch) {
        return (FRONT_UNROUNDED_VOWELS.indexOf(ch) != -1);
    }

    /**
     * The isConsonantDrop method takes a character as an input and returns true if given character is a dropping consonant.
     *
     * @param ch {@link Character} input to check.
     * @return true if given character is a dropping consonant.
     */
    public static boolean isConsonantDrop(char ch) {
        return (CONSONANT_DROPS.indexOf(ch) != -1);
    }

    /**
     * The isConsonant method takes a character as an input and returns true if given character is a consonant.
     *
     * @param ch {@link Character} input to check.
     * @return true if given character is a consonant.
     */
    public static boolean isConsonant(char ch) {
        return (CONSONANTS.indexOf(ch) != -1);
    }

    /**
     * The isSertSessiz method takes a character as an input and returns true if given character is a sert sessiz.
     *
     * @param ch {@link Character} input to check.
     * @return true if given character is a sert sessiz.
     */
    public static boolean isSertSessiz(char ch) {
        return (SERT_SESSIZ.indexOf(ch) != -1);
    }

}
