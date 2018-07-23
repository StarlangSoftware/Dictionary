package Dictionary;

import java.util.ArrayList;

public class TxtWord extends Word {

    private ArrayList<String> flags;

    /**
     * A constructor of {@link TxtWord} class which takes a String name as an input and calls its super class {@link Word}
     * with given name. Then, creates a new {@link ArrayList} as flags.
     *
     * @param name String name.
     */
    public TxtWord(String name) {
        super(name);
        flags = new ArrayList<>();
    }

    /**
     * Another constructor of {@link TxtWord} class which takes a String name and a flag as inputs and calls its super class {@link Word}
     * with given name. Then, creates a new {@link ArrayList} as flags and calls addFlag method with given flag.
     *
     * @param name String input.
     * @param flag String input.
     */
    public TxtWord(String name, String flag) {
        super(name);
        flags = new ArrayList<>();
        addFlag(flag);
    }

    /**
     * The clone method creates {@link TxtWord} type copy with name and add items of flags {@link ArrayList}  to the copy.
     *
     * @return TxtWord type copy.
     */
    public TxtWord clone() {
        int i;
        TxtWord copy = new TxtWord(name);
        for (i = 0; i < flags.size(); i++) {
            copy.addFlag(flags.get(i));
        }
        return copy;
    }

    /**
     * The addFlag method takes a String flag as an input and adds given flag to the flags {@link ArrayList}.
     *
     * @param flag String input to add.
     */
    public void addFlag(String flag) {
        flags.add(flag);
    }

    /**
     * The removeFlag method takes a String flag as an input and removes given flag from the flags {@link ArrayList}.
     *
     * @param flag String input to remove.
     */
    public void removeFlag(String flag) {
        flags.remove(flag);
    }

    /**
     * The verbType method checks flags {@link ArrayList} and returns the corresponding cases.
     *
     * @return the corresponding cases.
     */
    public String verbType() {
        if (flags.contains("F1P1-NO-REF")) {
            return "F1P1-NO-REF";
        }
        if (flags.contains("F2P1-NO-REF")) {
            return "F2P1-NO-REF";
        }
        if (flags.contains("F3P1-NO-REF")) {
            return "F3P1-NO-REF";
        }
        if (flags.contains("F4P1-NO-REF")) {
            return "F4P1-NO-REF";
        }
        if (flags.contains("F4PR-NO-REF")) {
            return "F4PR-NO-REF";
        }
        if (flags.contains("F4PL-NO-REF")) {
            return "F4PL-NO-REF";
        }
        if (flags.contains("F4PW-NO-REF")) {
            return "F4PW-NO-REF";
        }
        if (flags.contains("F5PL-NO-REF")) {
            return "F5PL-NO-REF";
        }
        if (flags.contains("F5PR-NO-REF")) {
            return "F5PR-NO-REF";
        }
        if (flags.contains("F5PW-NO-REF")) {
            return "F5PW-NO-REF";
        }
        if (flags.contains("F1P1")) {
            return "F1P1";
        }
        if (flags.contains("F2P1")) {
            return "F2P1";
        }
        if (flags.contains("F2PL")) {
            return "F2PL";
        }
        if (flags.contains("F3P1")) {
            return "F3P1";
        }
        if (flags.contains("F4P1")) {
            return "F4P1";
        }
        if (flags.contains("F4PR")) {
            return "F4PR";
        }
        if (flags.contains("F4PL")) {
            return "F4PL";
        }
        if (flags.contains("F4PW")) {
            return "F4PW";
        }
        if (flags.contains("F5P1")) {
            return "F5P1";
        }
        if (flags.contains("F5PL")) {
            return "F5PL";
        }
        if (flags.contains("F5PR")) {
            return "F5PR";
        }
        if (flags.contains("F5PW")) {
            return "F5PW";
        }
        if (flags.contains("F6P1")) {
            return "F6P1";
        }
        return "";
    }

    /**
     * The samePos method takes {@link TxtWord} as input and returns true if;
     * flags {@link ArrayList} contains CL_ISIM or given word is CL_ISIM or
     * flags {@link ArrayList} contains CL_FIIL or given word is CL_FIIL or
     * flags {@link ArrayList} contains IS_ADJ or given word is IS_ADJ or
     * flags {@link ArrayList} contains IS_ZM or given word is IS_ZM or
     * flags {@link ArrayList} contains IS_ADVERB or given word is IS_ADVERB, false otherwise.
     *
     * @param word {@link TxtWord} type input.
     * @return true if given word is nominal, verb, adjective, pronoun or adverb, false otherwise.
     */
    public boolean samePos(TxtWord word) {
        if (isNominal() && word.isNominal()) {
            return true;
        }
        if (isVerb() && word.isVerb()) {
            return true;
        }
        if (isAdjective() && word.isAdjective()) {
            return true;
        }
        if (isPronoun() && word.isPronoun()) {
            return true;
        }
        if (isAdverb() && word.isAdverb()) {
            return true;
        }
        return false;
    }

    /**
     * The isNominal method returns true if flags {@link ArrayList} contains CL_ISIM.
     *
     * @return true if flags {@link ArrayList} contains CL_ISIM.
     */
    public boolean isNominal() {
        return flags.contains("CL_ISIM");
    }

    /**
     * The isPassive method returns true if flags {@link ArrayList} contains PASSIVE-HN.
     *
     * @return true if flags {@link ArrayList} contains PASSIVE-HN.
     */
    public boolean isPassive() {
        return flags.contains("PASSIVE-HN");
    }

    /**
     * The isAbbreviation method returns true if flags {@link ArrayList} contains IS_KIS.
     *
     * @return true if flags {@link ArrayList} contains IS_KIS.
     */
    public boolean isAbbreviation() {
        return flags.contains("IS_KIS");
    }

    /**
     * The isInterjection method returns true if flags {@link ArrayList} contains IS_INTERJ.
     *
     * @return true if flags {@link ArrayList} contains IS_INTERJ.
     */
    public boolean isInterjection() {
        return flags.contains("IS_INTERJ");
    }

    /**
     * The isDuplicate method returns true if flags {@link ArrayList} contains IS_DUP.
     *
     * @return true if flags {@link ArrayList} contains IS_DUP.
     */
    public boolean isDuplicate() {
        return flags.contains("IS_DUP");
    }

    /**
     * The isHeader method returns true if flags {@link ArrayList} contains IS_HEADER.
     *
     * @return true if flags {@link ArrayList} contains IS_HEADER.
     */
    public boolean isHeader() {
        return flags.contains("IS_HEADER");
    }

    /**
     * The isAdjective method returns true if flags {@link ArrayList} contains IS_ADJ.
     *
     * @return true if flags {@link ArrayList} contains IS_ADJ.
     */
    public boolean isAdjective() {
        return flags.contains("IS_ADJ");
    }

    /**
     * The isPureAdjective method returns true if flags {@link ArrayList} contains IS_PUREADJ.
     *
     * @return true if flags {@link ArrayList} contains IS_PUREADJ.
     */
    public boolean isPureAdjective() {
        return flags.contains("IS_PUREADJ");
    }

    /**
     * The isPronoun method returns true if flags {@link ArrayList} contains IS_ZM.
     *
     * @return true if flags {@link ArrayList} contains IS_ZM.
     */
    public boolean isPronoun() {
        return flags.contains("IS_ZM");
    }

    /**
     * The isQuestion method returns true if flags {@link ArrayList} contains IS_QUES.
     *
     * @return true if flags {@link ArrayList} contains IS_QUES.
     */
    public boolean isQuestion() {
        return flags.contains("IS_QUES");
    }

    /**
     * The isVerb method returns true if flags {@link ArrayList} contains CL_FIIL.
     *
     * @return true if flags {@link ArrayList} contains CL_FIIL.
     */
    public boolean isVerb() {
        return flags.contains("CL_FIIL");
    }

    /**
     * The isPortmanteau method returns true if flags {@link ArrayList} contains IS_BILEŞ.
     *
     * @return true if flags {@link ArrayList} contains IS_BILEŞ.
     */
    public boolean isPortmanteau() {
        return flags.contains("IS_BILEŞ");
    }

    /**
     * The isDeterminer method returns true if flags {@link ArrayList} contains IS_DET.
     *
     * @return true if flags {@link ArrayList} contains IS_DET.
     */
    public boolean isDeterminer() {
        return flags.contains("IS_DET");
    }

    /**
     * The isConjunction method returns true if flags {@link ArrayList} contains IS_CONJ.
     *
     * @return true if flags {@link ArrayList} contains IS_CONJ.
     */
    public boolean isConjunction() {
        return flags.contains("IS_CONJ");
    }

    /**
     * The isAdverb method returns true if flags {@link ArrayList} contains IS_ADVERB.
     *
     * @return true if flags {@link ArrayList} contains IS_ADVERB.
     */
    public boolean isAdverb() {
        return flags.contains("IS_ADVERB");
    }

    /**
     * The isPostP method returns true if flags {@link ArrayList} contains IS_POSTP.
     *
     * @return true if flags {@link ArrayList} contains IS_POSTP.
     */
    public boolean isPostP() {
        return flags.contains("IS_POSTP");
    }

    /**
     * The isPortmanteauEndingWithSI method returns true if flags {@link ArrayList} contains IS_B_SI.
     *
     * @return true if flags {@link ArrayList} contains IS_B_SI.
     */
    public boolean isPortmanteauEndingWithSI() {
        return flags.contains("IS_B_SI");
    }

    /**
     * The isPortmanteauFacedVowelEllipsis method returns true if flags {@link ArrayList} contains IS_B_UD.
     *
     * @return true if flags {@link ArrayList} contains IS_B_UD.
     */
    public boolean isPortmanteauFacedVowelEllipsis() {
        return flags.contains("IS_B_UD");
    }

    /**
     * The isSuffix method returns true if flags {@link ArrayList} contains EK.
     *
     * @return true if flags {@link ArrayList} contains EK.
     */
    public boolean isSuffix() {
        return flags.contains("EK");
    }

    /**
     * The isProperNoun method returns true if flags {@link ArrayList} contains IS_OA.
     *
     * @return true if flags {@link ArrayList} contains IS_OA.
     */
    public boolean isProperNoun() {
        return flags.contains("IS_OA");
    }

    /**
     * The isPlural method returns true if flags {@link ArrayList} contains IS_CA.
     *
     * @return true if flags {@link ArrayList} contains IS_CA.
     */
    public boolean isPlural() {
        return flags.contains("IS_CA");
    }

    /**
     * The isNumeral method returns true if flags {@link ArrayList} contains IS_SAYI.
     *
     * @return true if flags {@link ArrayList} contains IS_SAYI.
     */
    public boolean isNumeral() {
        return flags.contains("IS_SAYI");
    }

    /**
     * The isReal method returns true if flags {@link ArrayList} contains IS_REELSAYI.
     *
     * @return true if flags {@link ArrayList} contains IS_REELSAYI.
     */
    public boolean isReal() {
        return flags.contains("IS_REELSAYI");
    }

    /**
     * The isFraction method returns true if flags {@link ArrayList} contains IS_KESIR.
     *
     * @return true if flags {@link ArrayList} contains IS_KESIR.
     */
    public boolean isFraction() {
        return flags.contains("IS_KESIR");
    }

    /**
     * The isTime method returns true if flags {@link ArrayList} contains IS_ZAMAN.
     *
     * @return true if flags {@link ArrayList} contains IS_ZAMAN.
     */
    public boolean isTime() {
        return flags.contains("IS_ZAMAN");
    }

    /**
     * The isDate method returns true if flags {@link ArrayList} contains IS_DATE.
     *
     * @return true if flags {@link ArrayList} contains IS_DATE.
     */
    public boolean isDate() {
        return flags.contains("IS_DATE");
    }

    /**
     * The isPercent method returns true if flags {@link ArrayList} contains IS_PERCENT.
     *
     * @return true if flags {@link ArrayList} contains IS_PERCENT.
     */
    public boolean isPercent() {
        return flags.contains("IS_PERCENT");
    }

    /**
     * The isRange method returns true if flags {@link ArrayList} contains IS_RANGE.
     *
     * @return true if flags {@link ArrayList} contains IS_RANGE.
     */
    public boolean isRange() {
        return flags.contains("IS_RANGE");
    }

    /**
     * The isOrdinal method returns true if flags {@link ArrayList} contains IS_ORD.
     *
     * @return true if flags {@link ArrayList} contains IS_ORD.
     */
    public boolean isOrdinal() {
        return flags.contains("IS_ORD");
    }

    /**
     * The notObeysVowelHarmonyDuringAgglutination method returns true if flags {@link ArrayList} contains IS_UU.
     *
     * @return true if flags {@link ArrayList} contains IS_UU.
     */
    public boolean notObeysVowelHarmonyDuringAgglutination() {
        return flags.contains("IS_UU");
    }

    /**
     * The obeysAndNotObeysVowelHarmonyDuringAgglutination method returns true if flags {@link ArrayList} contains IS_UUU.
     *
     * @return true if flags {@link ArrayList} contains IS_UUU.
     */
    public boolean obeysAndNotObeysVowelHarmonyDuringAgglutination() {
        return flags.contains("IS_UUU");
    }

    /**
     * The rootSoftenDuringSuffixation method returns true if flags {@link ArrayList} contains IS_SD, F_SD, IS_B_SD.
     *
     * @return true if flags {@link ArrayList} contains IS_SD, F_SD, IS_B_SD.
     */
    public boolean rootSoftenDuringSuffixation() {
        return flags.contains("IS_SD") || flags.contains("F_SD") || flags.contains("IS_B_SD");
    }

    /**
     * The rootSoftenDuringSuffixation method returns true if flags {@link ArrayList} contains IS_SDD.
     *
     * @return true if flags {@link ArrayList} contains IS_SDD.
     */
    public boolean rootSoftenAndNotSoftenDuringSuffixation() {
        return flags.contains("IS_SDD");
    }

    /**
     * The verbSoftenDuringSuffixation method returns true if flags {@link ArrayList} contains F_SD.
     *
     * @return true if flags {@link ArrayList} contains F_SD.
     */
    public boolean verbSoftenDuringSuffixation() {
        return flags.contains("F_SD");
    }

    /**
     * The nounSoftenDuringSuffixation method returns true if flags {@link ArrayList} contains IS_SD, IS_B_SD.
     *
     * @return true if flags {@link ArrayList} contains IS_SD, IS_B_SD.
     */
    public boolean nounSoftenDuringSuffixation() {
        return flags.contains("IS_SD") || flags.contains("IS_B_SD");
    }

    /**
     * The endingKChangesIntoG method returns true if flags {@link ArrayList} contains IS_KG.
     *
     * @return true if flags {@link ArrayList} contains IS_KG.
     */
    public boolean endingKChangesIntoG() {
        return flags.contains("IS_KG");
    }

    /**
     * The isExceptional method returns true if flags {@link ArrayList} contains IS_EX.
     *
     * @return true if flags {@link ArrayList} contains IS_EX.
     */
    public boolean isExceptional() {
        return flags.contains("IS_EX");
    }

    /**
     * The duplicatesDuringSuffixation method returns true if flags {@link ArrayList} contains IS_ST.
     *
     * @return true if flags {@link ArrayList} contains IS_ST.
     */
    public boolean duplicatesDuringSuffixation() {
        return flags.contains("IS_ST");
    }

    /**
     * The lastIdropsDuringSuffixation method returns true if flags {@link ArrayList} contains IS_UD.
     *
     * @return true if flags {@link ArrayList} contains IS_UD.
     */
    public boolean lastIdropsDuringSuffixation() {
        return flags.contains("IS_UD");
    }

    /**
     * The lastIDropsAndNotDropDuringSuffixation method returns true if flags {@link ArrayList} contains IS_UDD.
     *
     * @return true if flags {@link ArrayList} contains IS_UDD.
     */
    public boolean lastIDropsAndNotDropDuringSuffixation() {
        return flags.contains("IS_UDD");
    }

    /**
     * The takesRelativeSuffixKi method returns true if flags {@link ArrayList} contains IS_KI.
     *
     * @return true if flags {@link ArrayList} contains IS_KI.
     */
    public boolean takesRelativeSuffixKi() {
        return flags.contains("IS_KI");
    }

    /**
     * The takesRelativeSuffixKu method returns true if flags {@link ArrayList} contains IS_KU.
     *
     * @return true if flags {@link ArrayList} contains IS_KU.
     */
    public boolean takesRelativeSuffixKu() {
        return flags.contains("IS_KU");
    }

    /**
     * The consonantSMayInsertedDuringPossesiveSuffixation method returns true if flags {@link ArrayList} contains IS_SII.
     *
     * @return true if flags {@link ArrayList} contains IS_SII.
     */
    public boolean consonantSMayInsertedDuringPossesiveSuffixation() {
        return flags.contains("IS_SII");
    }

    /**
     * The lastIdropsDuringPassiveSuffixation method returns true if flags {@link ArrayList} contains F_UD.
     *
     * @return true if flags {@link ArrayList} contains F_UD.
     */
    public boolean lastIdropsDuringPassiveSuffixation() {
        return flags.contains("F_UD");
    }

    /**
     * The vowelAChangesToIDuringYSuffixation method returns true if flags {@link ArrayList} contains F_GUD.
     *
     * @return true if flags {@link ArrayList} contains F_GUD.
     */
    public boolean vowelAChangesToIDuringYSuffixation() {
        return flags.contains("F_GUD");
    }

    /**
     * The vowelEChangesToIDuringYSuffixation method returns true if flags {@link ArrayList} contains F_GUDO.
     *
     * @return true if flags {@link ArrayList} contains F_GUDO.
     */
    public boolean vowelEChangesToIDuringYSuffixation() {
        return flags.contains("F_GUDO");
    }

    /**
     * The takesSuffixIRAsAorist method returns true if flags {@link ArrayList} does not contain F_GIR.
     *
     * @return true if flags {@link ArrayList} contains F_GIR.
     */
    public boolean takesSuffixIRAsAorist() {
        return !flags.contains("F_GIR");
    }

    /**
     * The takesSuffixDIRAsFactitive method returns true if flags {@link ArrayList} does not contain F_DIR.
     *
     * @return true if flags {@link ArrayList} contains F_DIR.
     */
    public boolean takesSuffixDIRAsFactitive() {
        return !flags.contains("F_DIR");
    }

    /**
     * The showsSuRegularities method returns true if flags {@link ArrayList} contains IS_SU.
     *
     * @return true if flags {@link ArrayList} contains IS_SU.
     */
    public boolean showsSuRegularities() {
        return flags.contains("IS_SU");
    }

}
