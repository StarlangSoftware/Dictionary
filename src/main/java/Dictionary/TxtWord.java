package Dictionary;

import java.util.ArrayList;
import java.util.Comparator;

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
        flags = new ArrayList<String>();
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
        flags = new ArrayList<String>();
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
        if (flags.contains("F2P1-NO-REF")) {
            /*
             F2P1-NO-REF: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take PassiveHl suffix,
             can take CausativeT suffix. e.g. Doğ, göç, için
             */
            return "F2P1-NO-REF";
        }
        if (flags.contains("F3P1-NO-REF")) {
            /*
             *F3P1-NO-REF: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take Passive Hl suffix,
             *can take CausativeT suffix. e.g. Ak
             */
            return "F3P1-NO-REF";
        }
        if (flags.contains("F4P1-NO-REF")) {
            /*
             *F4P1-NO-REF: The bare-form is a verb and depending on this attribute, the verb can't take PassiveHn suffix, can take CausativeT suffix.
             *e.g. Aksa
             */
            return "F4P1-NO-REF";
        }
        if (flags.contains("F4PR-NO-REF")) {
            /*
             *F4PR-NO-REF: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take PassiveHl suffix,
             *can take CausativeT suffix. e.g. Çevir, göster
             */
            return "F4PR-NO-REF";
        }
        if (flags.contains("F4PL-NO-REF")) {
            /*
             *F4PL-NO-REF: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix,
             *can take CausativeT suffix. e.g. Azal, çoğal
             */
            return "F4PL-NO-REF";
        }
        if (flags.contains("F4PW-NO-REF")) {
            /*
             *F4PW-NO-REF: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take PassiveN suffix,
             *can take CausativeT suffix. e.g. Birle, boya
             */
            return "F4PW-NO-REF";
        }
        if (flags.contains("F5PL-NO-REF")) {
            /*
             *F5PL-NO-REF: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix,
             *can take CausativeDHr suffix. e.g. Çal, kal
             */
            return "F5PL-NO-REF";
        }
        if (flags.contains("F5PR-NO-REF")) {
            /*
             *F5PR-NO-REF: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take PassiveHl suffix,
             *can take CausativeDHr suffix. e.g. Birleş, çöz
             */
            return "F5PR-NO-REF";
        }
        if (flags.contains("F5PW-NO-REF")) {
            /*
             *F5PW-NO-REF: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take PassiveHl suffix,
             *can take CausativeDHr suffix. e.g. Ye
             */
            return "F5PW-NO-REF";
        }
        if (flags.contains("F1P1")) {
            /*
             *F1P1: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take PassiveHl suffix,
             *can take CausativeAr suffix, can take ReciprocalHs suffix. e.g. Çık, kop
             */
            return "F1P1";
        }
        if (flags.contains("F2P1")) {
            /*
             *F2P1: The bare-form is a verb and depending on this attribute, the verb can can not PassiveHn suffix, can take CausativeHr suffix,
             *can take CausativeDHr suffix, can take ReciprocalHs suffix. e.g. Bit, doy, düş
             */
            return "F2P1";
        }
        if (flags.contains("F2PL")) {
            /*
             *F2PL: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take CausativeHr suffix,
             *can take CausativeDHr suffix, can take ReciprocalHs suffix. e.g. Art, çök
             */
            return "F2PL";
        }
        if (flags.contains("F3P1")) {
            /*
             *F3P1: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take PassiveHl suffix,
             *can take CausativeHl suffix, can take ReciprocalHs suffix. e.g. Kok, sark
             */
            return "F3P1";
        }
        if (flags.contains("F4P1")) {
            /*
             *F4P1: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix,
             *can take CausativeT suffix, can take ReciprocalHs suffix. e.g. Anla
             */
            return "F4P1";
        }
        if (flags.contains("F4PR")) {
            /*
             *F4PR: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take PassiveHl suffix,
             *can take CausativeT suffix, can take ReciprocalHs suffix. e.g. Bitir, çağır
             */
            return "F4PR";
        }
        if (flags.contains("F4PL")) {
            /*
             *F4PL: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take PassiveN suffix,
             *can take CausativeT suffix, can take ReciprocalHs suffix. e.g. Bolal, çömel
             */
            return "F4PL";
        }
        if (flags.contains("F4PW")) {
            /*
             *F4PW: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take PassiveN suffix,
             *can take CausativeT suffix, can take ReciprocalHs suffix. e.g. Boyla, çağla
             */
            return "F4PW";
        }
        if (flags.contains("F5P1")) {
            /*
             *F5P1: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take PassiveHl suffix,
             *can take CausativeDHr suffix, can take ReciprocalHs suffix, can take ReflexiveHn suffix. e.g. Giy
             */
            return "F5P1";
        }
        if (flags.contains("F5PL")) {
            /*
             *F5PL: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take PassiveHl suffix,
             *can take CausativeDHr suffix, can take ReciprocalHs suffix. e.g. Böl, dal
             */
            return "F5PL";
        }
        if (flags.contains("F5PR")) {
            /*
             *F5PR: The bare-form is a verb and depending on this attribute, the verb can take NominalVerb suffixes "-sHm, -SHn, -yHz, SHnHz, -lAr",
             *can take NominalVerb1 suffixes, "-yDH, -ysA
             ", can take NominalVerb2 suffix, "-ymHs", can take AdjectiveRoot suffix, "-SH",
             *can take Adjective suffix, "-ŞAr" e.g. Bilin, çalış
             */
            return "F5PR";
        }
        if (flags.contains("F5PW")) {
            /*
             *F5PW: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix,
             *can take CausativeDHr suffix, can take ReciprocalHs suffix. e.g. Boşver, cezbet
             */
            return "F5PW";
        }
        if (flags.contains("F6P1")) {
            /*
             *F6P1: The bare-form is a verb and depending on this attribute, the verb can not take PassiveHn suffix, can take PassiveN suffix,
             *can take ReciprocalHs suffix, can take ReflexiveHn suffix. e.g. Gizle, hazırla, kaşı
             */
            return "F6P1";
        }
        return "";
    }

    /**
     * The samePos method takes {@link TxtWord} as input and returns true if;
     * <p>
     * flags {@link ArrayList} contains CL_ISIM
     * CL_ISIM: The bare-form of the word is a noun. e.g. Abla
     * <p>
     * flags {@link ArrayList} contains CL_FIIL
     * CL_FIIL: The bare-form of the word is a verb. e.g. Affet
     * <p>
     * flags {@link ArrayList} contains IS_ADJ
     * IS_ADJ: The bare-form of the word is a adjective. e.g. Acayip
     * <p>
     * flags {@link ArrayList} contains IS_ZM
     * IS_ZM: The bare-form of the word is a pronoun. e.g. Başkası
     * <p>
     * flags {@link ArrayList} contains IS_ADVERB
     * IS_ADVERB: The bare-form of the word is a adverb. e.g. Tekrar, açıktan, adeta
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
        /*
         IS_KIS: The bare-form of the word is an abbrevation which does not obey
         vowel harmony while taking suffixes. Örn. Ab
         */
        return flags.contains("IS_KIS");
    }

    /**
     * The isInterjection method returns true if flags {@link ArrayList} contains IS_INTERJ.
     *
     * @return true if flags {@link ArrayList} contains IS_INTERJ.
     */
    public boolean isInterjection() {
        /*
         *IS_INTERJ: An interjection is a part of speech that shows the emotion or feeling. e.g. Ah, aferin
         */
        return flags.contains("IS_INTERJ");
    }

    /**
     * The isDuplicate method returns true if flags {@link ArrayList} contains IS_DUP.
     *
     * @return true if flags {@link ArrayList} contains IS_DUP.
     */
    public boolean isDuplicate() {
        /*
         *IS_DUP: The bare-form is part of a duplicate form. e.g. Abuk
         */
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
        /*
         *IS_ZM: The bare-form of the word is a pronoun. e.g. Hangi, hep, hiçbiri
         */
        return flags.contains("IS_ZM");
    }

    /**
     * The isQuestion method returns true if flags {@link ArrayList} contains IS_QUES.
     *
     * @return true if flags {@link ArrayList} contains IS_QUES.
     */
    public boolean isQuestion() {
        /*The bare-form of the word is a question. e.g. Mi, mu, mü
         */
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
        /*
         *IS_BILEŞ: The bare-form is a portmanteau word in affixed form. e.g. gelinçiçeği
         */
        return flags.contains("IS_BILEŞ");
    }

    /**
     * The isDeterminer method returns true if flags {@link ArrayList} contains IS_DET.
     *
     * @return true if flags {@link ArrayList} contains IS_DET.
     */
    public boolean isDeterminer() {
        /*
         *IS_DET: The bare-form of the word is a determiner. e.g. Bazı, bir
         */
        return flags.contains("IS_DET");
    }

    /**
     * The isConjunction method returns true if flags {@link ArrayList} contains IS_CONJ.
     *
     * @return true if flags {@link ArrayList} contains IS_CONJ.
     */
    public boolean isConjunction() {
        /*
         *IS_CONJ: The bare-form of the word is a conjunction. e.g. Gerek, halbuki
         */
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
        /*
         *The bare-form of the word is a postposition. e.g. Önce, takdirde, üzere
         */
        return flags.contains("IS_POSTP");
    }

    /**
     * The isPortmanteauEndingWithSI method returns true if flags {@link ArrayList} contains IS_B_SI.
     *
     * @return true if flags {@link ArrayList} contains IS_B_SI.
     */
    public boolean isPortmanteauEndingWithSI() {
        /*
         *IS_B_SI: The bare-form is a portmanteau word ending with "sı". e.g. Giritlalesi
         */
        return flags.contains("IS_B_SI");
    }

    /**
     * The isPortmanteauFacedVowelEllipsis method returns true if flags {@link ArrayList} contains IS_B_UD.
     *
     * @return true if flags {@link ArrayList} contains IS_B_UD.
     */
    public boolean isPortmanteauFacedVowelEllipsis() {
        /*
         *IS_B_UD: The bare-form of the word includes vowel epenthesis,
         *therefore the last inserted vowel drops during suffixation. e.g. İnsanoğlu
         */
        return flags.contains("IS_B_UD");
    }

    /**
     * The isPortmanteauFacedSoftening method returns true if flags {@link ArrayList} contains IS_B_UD.
     *
     * @return true if flags {@link ArrayList} contains IS_B_SD.
     */
    public boolean isPortmanteauFacedSoftening() {
        /*
         *IS_B_SD: The bare-form of the word includes softening. e.g. Çançiçeği
         */
        return flags.contains("IS_B_SD");
    }

    /**
     * The isSuffix method returns true if flags {@link ArrayList} contains EK.
     *
     * @return true if flags {@link ArrayList} contains EK.
     */
    public boolean isSuffix() {
        /*
         * EK: This tag indicates complementary verbs. e.g. İdi, iken, imiş.
         */
        return flags.contains("EK");
    }

    /**
     * The isProperNoun method returns true if flags {@link ArrayList} contains IS_OA.
     *
     * @return true if flags {@link ArrayList} contains IS_OA.
     */
    public boolean isProperNoun() {
        /*
         *IS_OA: The bare-form of the word is a proper noun. e.g. Abant, Beşiktaş
         */
        return flags.contains("IS_OA");
    }

    /**
     * The isPlural method returns true if flags {@link ArrayList} contains IS_CA.
     *
     * @return true if flags {@link ArrayList} contains IS_CA.
     */
    public boolean isPlural() {
        /*
         *IS_CA: The bare-form of the word is already in a plural form,
         *therefore can not take plural suffixes such as "ler" or "lar". e.g. Buğdaygiller
         */
        return flags.contains("IS_CA");
    }

    /**
     * The isNumeral method returns true if flags {@link ArrayList} contains IS_SAYI.
     *
     * @return true if flags {@link ArrayList} contains IS_SAYI.
     */
    public boolean isNumeral() {
        /*
         *IS_SAYI: The word is a number. e.g. Dört
         */
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
        /*
         *IS_ORD: The bare-form of the word can take suffixes and these suffixes define a ranking. e.g. Birinci
         */
        return flags.contains("IS_ORD");
    }

    /**
     * The notObeysVowelHarmonyDuringAgglutination method returns true if flags {@link ArrayList} contains IS_UU.
     *
     * @return true if flags {@link ArrayList} contains IS_UU.
     */
    public boolean notObeysVowelHarmonyDuringAgglutination() {
        /*
         *IS_UU: The bare-form does not obey vowel harmony while taking suffixes. e.g. Dikkat
         */
        return flags.contains("IS_UU");
    }

    /**
     * The obeysAndNotObeysVowelHarmonyDuringAgglutination method returns true if flags {@link ArrayList} contain IS_UUU.
     *
     * @return true if flags {@link ArrayList} contains IS_UUU.
     */
    public boolean obeysAndNotObeysVowelHarmonyDuringAgglutination() {
        /*
         *IS_UUU: The bare-form does not obey vowel harmony while taking suffixes. e.g. Bol, kalp
         */
        return flags.contains("IS_UUU");
    }

    /**
     * The rootSoftenDuringSuffixation method returns true if flags {@link ArrayList} contains IS_SD, F_SD.
     *
     * @return true if flags {@link ArrayList} contains IS_SD, F_SD.
     */
    public boolean rootSoftenDuringSuffixation() {
        return flags.contains("IS_SD") || flags.contains("F_SD");
    }

    /**
     * The rootSoftenAndNotSoftenDuringSuffixation method returns true if flags {@link ArrayList} contains IS_SDD.
     *
     * @return true if flags {@link ArrayList} contains IS_SDD.
     */
    public boolean rootSoftenAndNotSoftenDuringSuffixation() {
        /*
         *The bare-form final consonant can (or can not) get devoiced during vowel-initial suffixation. e.g. Kalp
         */
        return flags.contains("IS_SDD");
    }

    /**
     * The verbSoftenDuringSuffixation method returns true if flags {@link ArrayList} contains F_SD.
     *
     * @return true if flags {@link ArrayList} contains F_SD.
     */
    public boolean verbSoftenDuringSuffixation() {
        /*
         * F_SD: The bare-form final consonant gets devoiced during vowel-initial suffixation. e.g. Cezbet
         */
        return flags.contains("F_SD");
    }

    /**
     * The nounSoftenDuringSuffixation method returns true if flags {@link ArrayList} contains IS_SD.
     *
     * @return true if flags {@link ArrayList} contains IS_SD.
     */
    public boolean nounSoftenDuringSuffixation() {
        /*
         *IS_SD: The bare-form final consonant already has an accusative suffix. e.g. Kabağı
         */
        return flags.contains("IS_SD");
    }

    /**
     * The endingKChangesIntoG method returns true if flags {@link ArrayList} contains IS_KG.
     *
     * @return true if flags {@link ArrayList} contains IS_KG.
     */
    public boolean endingKChangesIntoG() {
        /*
         *IS_KG: The bare-form includes vowel epenthesis, therefore the last inserted vowel drope
         *during suffixation. e.g. Çelenk
         */
        return flags.contains("IS_KG");
    }

    /**
     * The isExceptional method returns true if flags {@link ArrayList} contains IS_EX.
     *
     * @return true if flags {@link ArrayList} contains IS_EX.
     */
    public boolean isExceptional() {
        /*
         *IS_EX: This tag defines exception words. e.g. Delikanlı
         */
        return flags.contains("IS_EX");
    }

    /**
     * The duplicatesDuringSuffixation method returns true if flags {@link ArrayList} contains IS_ST.
     *
     * @return true if flags {@link ArrayList} contains IS_ST.
     */
    public boolean duplicatesDuringSuffixation() {
        /*
         *IS_ST: The second consonant of the bare-form undergoes a resyllabification. e.g. His
         */
        return flags.contains("IS_ST");
    }

    /**
     * The duplicatesAndNotDuplicatesDuringSuffixation method returns true if flags {@link ArrayList} contains IS_STT.
     *
     * @return true if flags {@link ArrayList} contains IS_STT.
     */
    public boolean duplicatesAndNotDuplicatesDuringSuffixation() {
        /*
         *IS_STT: The second consonant of the bare-form undergoes a resyllabification. e.g. His
         */
        return flags.contains("IS_STT");
    }

    /**
     * The lastIdropsDuringSuffixation method returns true if flags {@link ArrayList} contains IS_UD.
     *
     * @return true if flags {@link ArrayList} contains IS_UD.
     */
    public boolean lastIdropsDuringSuffixation() {
        /*
         *IS_UD: The bare-form includes vowel epenthesis, therefore the last inserted vowel drops during suffixation.
         *e.g. Boyun
         */
        return flags.contains("IS_UD");
    }

    /**
     * The lastIDropsAndNotDropDuringSuffixation method returns true if flags {@link ArrayList} contains IS_UDD.
     *
     * @return true if flags {@link ArrayList} contains IS_UDD.
     */
    public boolean lastIDropsAndNotDropDuringSuffixation() {
        /*
         *The bare-form includes vowel epenthesis, therefore the last inserted vowel can (or can not) drop during suffixation. e.g. Kadir
         */
        return flags.contains("IS_UDD");
    }

    /**
     * The takesRelativeSuffixKi method returns true if flags {@link ArrayList} contains IS_KI.
     *
     * @return true if flags {@link ArrayList} contains IS_KI.
     */
    public boolean takesRelativeSuffixKi() {
        /*
         *IS_KI: The word can take a suffix such as "ki". e.g. Önce
         */
        return flags.contains("IS_KI");
    }

    /**
     * The takesRelativeSuffixKu method returns true if flags {@link ArrayList} contains IS_KU.
     *
     * @return true if flags {@link ArrayList} contains IS_KU.
     */
    public boolean takesRelativeSuffixKu() {
        /*
         *IS_KU: The word can take a suffix such as "kü". e.g. Bugün
         */
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
        /*
         *F_UD: The bare-form includes vowel epenthesis, therefore the last "ı"
         *drops during passive suffixation. e.g. Çağır
         */
        return flags.contains("F_UD");
    }

    /**
     * The vowelAChangesToIDuringYSuffixation method returns true if flags {@link ArrayList} contains F_GUD.
     *
     * @return true if flags {@link ArrayList} contains F_GUD.
     */
    public boolean vowelAChangesToIDuringYSuffixation() {
        /*
         *F_GUD: The verb bare-form includes vowel reduction, the last vowel "a" of the bare-form is replaced with "ı"
         *e.g. Buzağıla
         */
        return flags.contains("F_GUD");
    }

    /**
     * The vowelEChangesToIDuringYSuffixation method returns true if flags {@link ArrayList} contains F_GUDO.
     *
     * @return true if flags {@link ArrayList} contains F_GUDO.
     */
    public boolean vowelEChangesToIDuringYSuffixation() {
        /*
         *F_GUDO: The verb bare-form includes viwel reduction, the last vowel "e" of the
         *bare-form is replaced with "i". e.g. Ye
         */
        return flags.contains("F_GUDO");
    }

    /**
     * The takesSuffixIRAsAorist method returns true if flags {@link ArrayList} contains F_GIR.
     *
     * @return true if flags {@link ArrayList} contains F_GIR.
     */
    public boolean takesSuffixIRAsAorist() {
        /*
         *F_GIR: The bare-form of the word takes "ir" suffix. e.g. Geç
         */
        return !flags.contains("F_GIR");
    }

    /**
     * The takesSuffixDIRAsFactitive method returns true if flags {@link ArrayList} contains F_DIR.
     *
     * @return true if flags {@link ArrayList} contains F_DIR.
     */
    public boolean takesSuffixDIRAsFactitive() {
        /*
         *F_DIR: The bare-form of the word takes "tır" suffix. e.g. Daral
         */
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

    /**
     * The containsFlag method returns true if flags {@link ArrayList} contains flag.
     *
     * @param flag Flag to be cheked
     * @return true if flags {@link ArrayList} contains flag.
     */
    public boolean containsFlag(String flag){
        return flags.contains(flag);
    }

    public String toString(){
        StringBuilder result = new StringBuilder(super.toString());
        flags.sort(Comparator.naturalOrder());
        for (String flag : flags){
            result.append(" ").append(flag);
        }
        return result.toString();
    }

}
