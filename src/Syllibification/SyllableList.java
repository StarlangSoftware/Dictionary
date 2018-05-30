package Syllibification;

import Language.TurkishLanguage;

import java.util.ArrayList;

public class SyllableList {
    private ArrayList<Syllable> syllables;

    public SyllableList(String word) throws IrregularWordException {
        syllables = new ArrayList<Syllable>();
        StringBuilder sbSyllable = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            boolean isVowel = TurkishLanguage.isVowel(c);
            boolean isLastChar = i == word.length() - 1;
            if (isVowel){
                sbSyllable.append(c);
                //if last wovel
                if (i == word.length()-2){
                    sbSyllable.append(word.charAt(i+1));
                    i++;
                }
                syllables.add(new Syllable(sbSyllable.toString()));
                sbSyllable = new StringBuilder();
            }else{
                //a syllable should not begin with two CONSONANTS.
                String tempSyl = sbSyllable.toString();
                if (tempSyl.length() == 1){
                    if (!TurkishLanguage.isVowel(tempSyl.charAt(0))){        //prev char were consonant too
                        if (syllables.size() == 0) throw new IrregularWordException("The word " + word + " is not a regular Turkish word.");
                        int lastPos = syllables.size()-1;
                        String str = syllables.get(lastPos).getText();
                        str = str + tempSyl;
                        if (isLastChar){
                            str = str + c;                //if it's the last char as consonant, add it to latest syllable. test 4 word syylabbles. ex: 'park'
                        }
                        syllables.set(lastPos, new Syllable(str));                   //update prev syllable.
                        sbSyllable = new StringBuilder(c);
                    }
                }
                sbSyllable.append(c);
            }
        }
    }

    public ArrayList<String> getSyllables(){
        ArrayList<String> syllables = new ArrayList<>();
        for (Syllable syllable : this.syllables){
            syllables.add(syllable.getText());
        }
        return syllables;
    }
}
