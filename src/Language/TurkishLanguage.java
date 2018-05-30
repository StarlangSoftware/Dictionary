package Language;

public class TurkishLanguage extends Language{
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

    public static boolean isVowel(char ch){
        return (VOWELS.indexOf(ch) != -1);
    }

    public static boolean isBackVowel(char ch){
        return (BACK_VOWELS.indexOf(ch) != -1);
    }

    public static boolean isFrontVowel(char ch){
        return (FRONT_VOWELS.indexOf(ch) != -1);
    }

    public static boolean isBackRoundedVowel(char ch){
        return (BACK_ROUNDED_VOWELS.indexOf(ch) != -1);
    }

    public static boolean isFrontRoundedVowel(char ch){
        return (FRONT_ROUNDED_VOWELS.indexOf(ch) != -1);
    }

    public static boolean isBackUnroundedVowel(char ch){
        return (BACK_UNROUNDED_VOWELS.indexOf(ch) != -1);
    }

    public static boolean isFrontUnroundedVowel(char ch){
        return (FRONT_UNROUNDED_VOWELS.indexOf(ch) != -1);
    }

    public static boolean isConsonantDrop(char ch){
        return (CONSONANT_DROPS.indexOf(ch) != -1);
    }

    public static boolean isConsonant(char ch){
        return (CONSONANTS.indexOf(ch) != -1);
    }

    public static boolean isSertSessiz(char ch){
        return (SERT_SESSIZ.indexOf(ch) != -1);
    }

}
