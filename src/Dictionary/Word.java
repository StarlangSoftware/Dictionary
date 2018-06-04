package Dictionary;

import Language.TurkishLanguage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

public class Word implements Serializable{

    protected String name;

    public Word(){

    }

    public Word(String name){
        this.name = name;
    }

    public int hashCode(){
        return name.hashCode();
    }

    @Override public boolean equals(Object aThat) {
        if (this == aThat)
            return true;
        if (!(aThat instanceof Word))
            return false;
        Word that = (Word)aThat;
        return that.name.equalsIgnoreCase(name);
    }

    public String toString(){
        return name;
    }

    public int charCount(){
        return name.length();
    }

    public Word clone(){
        return new Word(name);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public static boolean isCapital(String surfaceForm){
        return TurkishLanguage.UPPERCASE_LETTERS.indexOf(surfaceForm.charAt(0)) != -1;
    }

    public static boolean isPunctuation(String surfaceForm){
        return (surfaceForm.equalsIgnoreCase(".") || surfaceForm.equalsIgnoreCase("[") || surfaceForm.equalsIgnoreCase("]") || surfaceForm.equalsIgnoreCase("...") || surfaceForm.equalsIgnoreCase("%") || surfaceForm.equalsIgnoreCase("&") || surfaceForm.equalsIgnoreCase("=") || surfaceForm.equalsIgnoreCase("``") || surfaceForm.equalsIgnoreCase("`") || surfaceForm.equalsIgnoreCase("''") || surfaceForm.equalsIgnoreCase("$") || surfaceForm.equalsIgnoreCase("!") || surfaceForm.equalsIgnoreCase("?") || surfaceForm.equalsIgnoreCase(",") || surfaceForm.equalsIgnoreCase(":") || surfaceForm.equalsIgnoreCase("--") || surfaceForm.equalsIgnoreCase(";") || surfaceForm.equalsIgnoreCase("(") || surfaceForm.equalsIgnoreCase(")") || surfaceForm.equalsIgnoreCase("'") || surfaceForm.equalsIgnoreCase("\"") || surfaceForm.equalsIgnoreCase("”") || surfaceForm.equalsIgnoreCase("’") || surfaceForm.equalsIgnoreCase("“") || surfaceForm.equalsIgnoreCase("…") || surfaceForm.equalsIgnoreCase("●") || surfaceForm.equalsIgnoreCase("/") || surfaceForm.equalsIgnoreCase("-") || surfaceForm.equalsIgnoreCase("+") || surfaceForm.equalsIgnoreCase("-LRB-") || surfaceForm.equalsIgnoreCase("-RRB-") || surfaceForm.equalsIgnoreCase("-LCB-") || surfaceForm.equalsIgnoreCase("-RCB-") || surfaceForm.equalsIgnoreCase("-LSB-") || surfaceForm.equalsIgnoreCase("-RSB-"));
    }

    public static boolean isHonorific(String surfaceForm){
        String lowercase = surfaceForm.toLowerCase(new Locale("tr"));
        return lowercase.equals("bay") || lowercase.equals("bayan");
    }

    public static boolean isOrganization(String surfaceForm){
        String lowercase = surfaceForm.toLowerCase(new Locale("tr"));
        return lowercase.startsWith("şirket") || lowercase.equals("corp") || lowercase.equals("inc.") || lowercase.equals("co.");
    }

    public static boolean isMoney(String surfaceForm){
        String lowercase = surfaceForm.toLowerCase(new Locale("tr"));
        return lowercase.startsWith("dolar") || lowercase.startsWith("sterlin") || lowercase.startsWith("paunt") || lowercase.startsWith("ons") || lowercase.startsWith("ruble") || lowercase.startsWith("mark") || lowercase.startsWith("frank") || lowercase.equals("yen") || lowercase.startsWith("sent") || lowercase.startsWith("yen'") || lowercase.contains("$");
    }

    public boolean isPunctuation(){
        if (name.equals(",") || name.equals(".") || name.equals("!") || name.equals("?") || name.equals(":")
                || name.equals(";") || name.equals("\"") || name.equals("''") || name.equals("'") || name.equals("`")
                || name.equals("``") || name.equals("...") || name.equals("-") || name.equals("--"))
            return true;
        return false;
    }

    public static boolean isTime(String surfaceForm){
        String lowercase = surfaceForm.toLowerCase(new Locale("tr"));
        if (lowercase.matches("(\\d\\d|\\d):(\\d\\d|\\d):(\\d\\d|\\d)") || lowercase.matches("(\\d\\d|\\d):(\\d\\d|\\d)")){
            return true;
        }
        if (lowercase.startsWith("ocak") || lowercase.startsWith("şubat") || lowercase.startsWith("mart") || lowercase.startsWith("nisan") || lowercase.startsWith("mayıs") || lowercase.startsWith("haziran") || lowercase.startsWith("temmuz") || lowercase.startsWith("ağustos") || lowercase.startsWith("eylül") || lowercase.startsWith("ekim") || lowercase.startsWith("kasım") || lowercase.equals("aralık")){
            return true;
        }
        if (lowercase.equals("pazar") || lowercase.equals("salı") || lowercase.startsWith("çarşamba") || lowercase.startsWith("perşembe") || lowercase.equals("cuma") || lowercase.startsWith("cumartesi") || lowercase.startsWith("pazartesi")){
            return true;
        }
        if (lowercase.contains("'")){
            lowercase = lowercase.substring(0, lowercase.indexOf("'"));
        }
        try {
            int time = Integer.parseInt(lowercase);
            if (time > 1900 && time < 2200){
                return true;
            }
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        return false;
    }

    public static Word[] toWordArray(String[] sourceArray){
        Word[] result = new Word[sourceArray.length];
        for (int i = 0; i < sourceArray.length; i++){
            result[i] = new Word(sourceArray[i]);
        }
        return result;
    }

    public ArrayList<Word> toCharacters(){
        ArrayList<Word> characters = new ArrayList<Word>();
        for (int i = 0; i < name.length(); i++)
            characters.add(new Word("" + name.charAt(i)));
        return characters;
    }

}
