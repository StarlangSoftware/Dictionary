package Dictionary;

import java.util.ArrayList;

public class TxtWord extends Word{

    private ArrayList<String> flags;

    public TxtWord(String name){
        super(name);
        flags = new ArrayList<String>();
    }

    public TxtWord(String name, String flag){
        super(name);
        flags = new ArrayList<String>();
        addFlag(flag);
    }

    public TxtWord clone(){
        int i;
        TxtWord copy = new TxtWord(name);
        for (i = 0; i < flags.size(); i++){
            copy.addFlag(flags.get(i));
        }
        return copy;
    }

    public void addFlag(String flag){
        flags.add(flag);
    }

    public String verbType(){
        if (flags.contains("F1P1-NO-REF")){
            return "F1P1-NO-REF";
        }
        if (flags.contains("F2P1-NO-REF")){
            return "F2P1-NO-REF";
        }
        if (flags.contains("F3P1-NO-REF")){
            return "F3P1-NO-REF";
        }
        if (flags.contains("F4P1-NO-REF")){
            return "F4P1-NO-REF";
        }
        if (flags.contains("F4PR-NO-REF")){
            return "F4PR-NO-REF";
        }
        if (flags.contains("F4PL-NO-REF")){
            return "F4PL-NO-REF";
        }
        if (flags.contains("F4PW-NO-REF")){
            return "F4PW-NO-REF";
        }
        if (flags.contains("F5PL-NO-REF")){
            return "F5PL-NO-REF";
        }
        if (flags.contains("F5PR-NO-REF")){
            return "F5PR-NO-REF";
        }
        if (flags.contains("F5PW-NO-REF")){
            return "F5PW-NO-REF";
        }
        if (flags.contains("F1P1")){
            return "F1P1";
        }
        if (flags.contains("F2P1")){
            return "F2P1";
        }
        if (flags.contains("F2PL")){
            return "F2PL";
        }
        if (flags.contains("F3P1")){
            return "F3P1";
        }
        if (flags.contains("F4P1")){
            return "F4P1";
        }
        if (flags.contains("F4PR")){
            return "F4PR";
        }
        if (flags.contains("F4PL")){
            return "F4PL";
        }
        if (flags.contains("F4PW")){
            return "F4PW";
        }
        if (flags.contains("F5P1")){
            return "F5P1";
        }
        if (flags.contains("F5PL")){
            return "F5PL";
        }
        if (flags.contains("F5PR")){
            return "F5PR";
        }
        if (flags.contains("F5PW")){
            return "F5PW";
        }
        if (flags.contains("F6P1")){
            return "F6P1";
        }
        return "";
    }

    public boolean samePos(TxtWord word){
        if (isNominal() && word.isNominal()){
            return true;
        }
        if (isVerb() && word.isVerb()){
            return true;
        }
        if (isAdjective() && word.isAdjective()){
            return true;
        }
        if (isPronoun() && word.isPronoun()){
            return true;
        }
        if (isAdverb() && word.isAdverb()){
            return true;
        }
        return false;
    }

    public boolean isNominal(){
        return flags.contains("CL_ISIM") || flags.contains("CL_BOTH");
    }

    public boolean isPassive(){
        return flags.contains("PASSIVE-HN");
    }

    public boolean isAbbreviation(){
        return flags.contains("IS_KIS");
    }

    public boolean isInterjection(){
        return flags.contains("IS_INTERJ");
    }

    public boolean isDuplicate(){
        return flags.contains("IS_DUP");
    }

    public boolean isHeader(){
        return flags.contains("IS_HEADER");
    }

    public boolean isAdjective(){
        return flags.contains("IS_ADJ");
    }

    public boolean isPureAdjective(){
        return flags.contains("IS_PUREADJ");
    }

    public boolean isPronoun(){
        return flags.contains("IS_ZM");
    }

    public boolean isQuestion(){
        return flags.contains("IS_QUES");
    }

    public boolean isVerb(){
        return flags.contains("CL_FIIL") || flags.contains("CL_BOTH");
    }

    public boolean isPortmanteau(){
        return flags.contains("IS_BILEŞ");
    }

    public boolean isDeterminer(){
        return flags.contains("IS_DET");
    }

    public boolean isConjunction(){
        return flags.contains("IS_CONJ");
    }

    public boolean isAdverb(){
        return flags.contains("IS_ADVERB");
    }

    public boolean isPostP(){
        return flags.contains("IS_POSTP");
    }

    public boolean isPortmanteauEndingWithSI(){
        return flags.contains("IS_B_SI");
    }

    public boolean isPortmanteauFacedVowelEllipsis(){
        return flags.contains("IS_B_UD");
    }

    public boolean isSuffix(){
        return flags.contains("EK");
    }

    public boolean isProperNoun(){
        return flags.contains("IS_OA");
    }

    public boolean isPlural(){
        return flags.contains("IS_CA");
    }

    public boolean isNumeral(){
        return flags.contains("IS_SAYI");
    }

    public boolean isReal(){
        return flags.contains("IS_REELSAYI");
    }

    public boolean isFraction(){
        return flags.contains("IS_KESIR");
    }

    public boolean isTime(){
        return flags.contains("IS_ZAMAN");
    }

    public boolean isDate(){
        return flags.contains("IS_DATE");
    }

    public boolean isPercent(){
        return flags.contains("IS_PERCENT");
    }

    public boolean isRange(){
        return flags.contains("IS_RANGE");
    }

    public boolean isOrdinal() {
        return flags.contains("IS_ORD");
    }

    public boolean notObeysVowelHarmonyDuringAgglutination(){
        return flags.contains("IS_UU");
    }

    public boolean rootSoftenDuringSuffixation(){
        return flags.contains("IS_SD") || flags.contains("F_SD") || flags.contains("IS_B_SD") || flags.contains("IS_SDD");
    }

    public boolean verbSoftenDuringSuffixation(){
        return flags.contains("F_SD");
    }

    public boolean nounSoftenDuringSuffixation(){
        return flags.contains("IS_SD") || flags.contains("IS_B_SD") || flags.contains("IS_SDD");
    }

    public boolean endingKChangesIntoG(){
        return flags.contains("IS_KG");
    }

    public boolean isExceptional(){
        return flags.contains("IS_EX");
    }

    public boolean duplicatesDuringSuffixation(){
        return flags.contains("IS_ST") && !flags.contains("IS_STT");
    }

    public boolean lastIdropsDuringSuffixation(){
        return flags.contains("IS_UD") || flags.contains("IS_UDD");
    }

    public boolean takesRelativeSuffixKi(){
        return flags.contains("IS_KI");
    }

    public boolean takesRelativeSuffixKu(){
        return flags.contains("IS_KU");
    }

    public boolean consonantSMayInsertedDuringPossesiveSuffixation(){
        return flags.contains("IS_SII");
    }

    public boolean lastIdropsDuringPassiveSuffixation(){
        return flags.contains("F_UD");
    }

    public boolean vowelAChangesToIDuringYSuffixation(){
        return flags.contains("F_GUD");
    }

    public boolean vowelEChangesToIDuringYSuffixation(){
        return flags.contains("F_GUDO");
    }

    public boolean takesSuffixIRAsAorist(){
        return !flags.contains("F_GIR");
    }

    public boolean takesSuffixDIRAsFactitive(){
        return !flags.contains("F_DIR");
    }

    public boolean showsSuRegularities(){
        return flags.contains("IS_SU");
    }

}
