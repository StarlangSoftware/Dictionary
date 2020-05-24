package Dictionary;

import Language.TurkishLanguage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

public class Word implements Serializable {

    protected String name;

    /**
     * An empty constructor of {@link Word} class.
     */
    public Word() {

    }

    /**
     * A constructor of {@link Word} class which gets a String name as an input and assigns to the name variable.
     *
     * @param name String input.
     */
    public Word(String name) {
        this.name = name;
    }

    /**
     * The overridden hashCode method returns the hash code for the name.
     *
     * @return the hash code for the name.
     */
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * The overridden equals method takes an {@link Object} as an input and returns the result of comparison of name variable
     * and name of given {@link Object}.
     *
     * @param aThat {@link Object} input.
     * @return the result of comparison of name variable and name of given {@link Object}.
     */
    @Override
    public boolean equals(Object aThat) {
        if (this == aThat)
            return true;
        if (!(aThat instanceof Word))
            return false;
        Word that = (Word) aThat;
        return that.name.equalsIgnoreCase(name);
    }

    /**
     * The overridden toString method returns the name variable.
     *
     * @return the name variable.
     */
    public String toString() {
        return name;
    }

    /**
     * The charCount method returns the length of name variable.
     *
     * @return the length of name variable.
     */
    public int charCount() {
        return name.length();
    }

    /**
     * The overridden clone method returns new {@link Word} as name.
     *
     * @return new {@link Word} as name.
     */
    public Word clone() {
        return new Word(name);
    }

    /**
     * Getter for the name variable.
     *
     * @return name variable.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name variable.
     *
     * @param name String input.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The isCapital method takes a String surfaceForm as an input and returns true if the character at first index of surfaceForm
     * is a capital letter, false otherwise.
     *
     * @param surfaceForm String input to check the first character.
     * @return true if the character at first index of surfaceForm is a capital letter, false otherwise.
     */
    public static boolean isCapital(String surfaceForm) {
        return TurkishLanguage.UPPERCASE_LETTERS.indexOf(surfaceForm.charAt(0)) != -1;
    }

    /**
     * The isPunctuation method takes a String surfaceForm as an input and returns true if it is a punctuation, false otherwise.
     * Grave accent : \u0060
     * Left quotation mark : \u201C
     * Right quotation mark : \u201D
     * Left single quotation mark : \u2018
     *Horizontal ellipsis : \u2026
     *
     * @param surfaceForm String input to check.
     * @return true if it is a punctuation, false otherwise.
     */
    public static boolean isPunctuation(String surfaceForm) {
        return (surfaceForm.equalsIgnoreCase(".") || surfaceForm.equalsIgnoreCase("...") || surfaceForm.equalsIgnoreCase("[") || surfaceForm.equalsIgnoreCase("]") || surfaceForm.equalsIgnoreCase("\u2026") || surfaceForm.equalsIgnoreCase("%") || surfaceForm.equalsIgnoreCase("&") || surfaceForm.equalsIgnoreCase("=") || surfaceForm.equalsIgnoreCase("\u0060\u0060") || surfaceForm.equalsIgnoreCase("\u0060") || surfaceForm.equalsIgnoreCase("''") || surfaceForm.equalsIgnoreCase("$") || surfaceForm.equalsIgnoreCase("!") || surfaceForm.equalsIgnoreCase("?") || surfaceForm.equalsIgnoreCase(",") || surfaceForm.equalsIgnoreCase(":") || surfaceForm.equalsIgnoreCase("--") || surfaceForm.equalsIgnoreCase(";") || surfaceForm.equalsIgnoreCase("(") || surfaceForm.equalsIgnoreCase(")") || surfaceForm.equalsIgnoreCase("'") || surfaceForm.equalsIgnoreCase("\"") || surfaceForm.equalsIgnoreCase("\u201C") || surfaceForm.equalsIgnoreCase("\u2018") || surfaceForm.equalsIgnoreCase("\u201D") || surfaceForm.equalsIgnoreCase("…") || surfaceForm.equalsIgnoreCase("\u25CF") || surfaceForm.equalsIgnoreCase("/") || surfaceForm.equalsIgnoreCase("-") || surfaceForm.equalsIgnoreCase("+") || surfaceForm.equalsIgnoreCase("-LRB-") || surfaceForm.equalsIgnoreCase("-RRB-") || surfaceForm.equalsIgnoreCase("-LCB-") || surfaceForm.equalsIgnoreCase("-RCB-") || surfaceForm.equalsIgnoreCase("-LSB-") || surfaceForm.equalsIgnoreCase("-RSB-"));
    }

    /**
     * The isHonorific method takes a String surfaceForm as an input and after converting it to lower case it returns true
     * if it equals to "bay" or "bayan", false otherwise.
     *
     * @param surfaceForm String input to check.
     * @return true if it equals to "bay" or "bayan", false otherwise.
     */
    public static boolean isHonorific(String surfaceForm) {
        String lowerCase = surfaceForm.toLowerCase(new Locale("tr"));
        return lowerCase.equals("bay") || lowerCase.equals("bayan");
    }

    /**
     * The isOrganization method takes a String surfaceForm as an input and after converting it to lower case it returns true
     * if it equals to "şirket", "corp", "inc.", or "co.", and false otherwise.
     *
     * @param surfaceForm String input to check.
     * @return true if it equals to "şirket", "corp", "inc.", or "co.", and false otherwise.
     */
    public static boolean isOrganization(String surfaceForm) {
        String lowerCase = surfaceForm.toLowerCase(new Locale("tr"));
        return lowerCase.equals("corp") || lowerCase.equals("inc.") || lowerCase.equals("co.");
    }

    /**
     * The isMoney method takes a String surfaceForm as an input and after converting it to lower case it returns true
     * if it equals to one of the dolar, sterlin, paunt, ons, ruble, mark, frank, yan, sent, yen' or $, and false otherwise.
     *
     * @param surfaceForm String input to check.
     * @return true if it equals to one of the dolar, sterlin, paunt, ons, ruble, mark, frank, yan, sent, yen' or $, and false otherwise.
     */
    public static boolean isMoney(String surfaceForm) {
        String lowerCase = surfaceForm.toLowerCase(new Locale("tr"));
        return lowerCase.startsWith("dolar") || lowerCase.startsWith("sterlin") || lowerCase.startsWith("paunt") || lowerCase.startsWith("ons") || lowerCase.startsWith("ruble") || lowerCase.startsWith("mark") || lowerCase.startsWith("frank") || lowerCase.equals("yen") || lowerCase.startsWith("sent") || lowerCase.startsWith("cent") || lowerCase.startsWith("yen'") || lowerCase.contains("$");
    }

    /**
     * The isPunctuation method without any argument, it checks name variable whether it is a punctuation or not and
     * returns true if so.
     *
     * @return true if name is a punctuation.
     */
    public boolean isPunctuation() {
        return Word.isPunctuation(name);
    }

    /**
     * The isTime method takes a String surfaceForm as an input and after converting it to lower case it checks some cases.
     * If it is in the form of 12:23:34 or 12:23 it returns true.
     * If it starts with name of months; ocak, şubat, mart, nisan, mayıs, haziran, temmuz, ağustos, eylül, ekim, kasım, aralık it returns true.
     * If it equals to the name of days; pazar, pazartesi, salı, çarşamba, perşembe, cuma, cumartesi it returns true.
     *
     * @param surfaceForm String input to check.
     * @return true if it presents time, and false otherwise.
     */
    public static boolean isTime(String surfaceForm) {
        String lowerCase = surfaceForm.toLowerCase(new Locale("tr"));
        if (lowerCase.matches("(\\d\\d|\\d):(\\d\\d|\\d):(\\d\\d|\\d)") || lowerCase.matches("(\\d\\d|\\d):(\\d\\d|\\d)")) {
            return true;
        }
        if (lowerCase.startsWith("ocak") || lowerCase.startsWith("şubat") || lowerCase.startsWith("mart") || lowerCase.startsWith("nisan") || lowerCase.startsWith("mayıs") || lowerCase.startsWith("haziran") || lowerCase.startsWith("temmuz") || lowerCase.startsWith("ağustos") || lowerCase.startsWith("eylül") || lowerCase.startsWith("ekim") || lowerCase.startsWith("kasım") || lowerCase.equals("aralık")) {
            return true;
        }
        if (lowerCase.equals("pazar") || lowerCase.equals("salı") || lowerCase.startsWith("çarşamba") || lowerCase.startsWith("perşembe") || lowerCase.equals("cuma") || lowerCase.startsWith("cumartesi") || lowerCase.startsWith("pazartesi")) {
            return true;
        }
        if (lowerCase.contains("'")) {
            lowerCase = lowerCase.substring(0, lowerCase.indexOf("'"));
        }
        try {
            int time = Integer.parseInt(lowerCase);
            if (time > 1900 && time < 2200) {
                return true;
            }
        } catch (NumberFormatException nfe) {
        }
        return false;
    }

    /**
     * The toWordArray method takes a String {@link java.lang.reflect.Array} sourceArray as an input. First it creates
     * a {@link Word} type result array and puts items of input sourceArray to this result {@link java.lang.reflect.Array}.
     *
     * @param sourceArray String {@link java.lang.reflect.Array}.
     * @return Word type {@link java.lang.reflect.Array}.
     */
    public static Word[] toWordArray(String[] sourceArray) {
        Word[] result = new Word[sourceArray.length];
        for (int i = 0; i < sourceArray.length; i++) {
            result[i] = new Word(sourceArray[i]);
        }
        return result;
    }

    /**
     * The toCharacters method creates a {@link Word} type characters {@link ArrayList} and adds characters of name variable
     * to newly created {@link ArrayList}.
     *
     * @return Word type {@link ArrayList}.
     */
    public ArrayList<Word> toCharacters() {
        ArrayList<Word> characters = new ArrayList<Word>();
        for (int i = 0; i < name.length(); i++)
            characters.add(new Word("" + name.charAt(i)));
        return characters;
    }

}
