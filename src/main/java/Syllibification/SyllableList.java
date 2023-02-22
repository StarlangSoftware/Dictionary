package Syllibification;

import Language.TurkishLanguage;

import java.util.ArrayList;

public class SyllableList {
    private ArrayList<Syllable> syllables;

    /**
     * A constructor of {@link SyllableList} class which takes a String word as an input. First it creates a syllable {@link ArrayList}
     * and a {@link StringBuilder} sbSyllable. Then it loops i times, where i ranges from 0 to length of given word, first
     * it gets the ith character of given word and checks whether it is a vowel and the last character of the word.
     * <p>
     * If it is a vowel it appends it to the sbSyllable and if it is the last vowel it also appends the next character to the sbSyllable.
     * Then, it adds the sbSyllable tot he syllables {@link ArrayList}.
     * <p>
     * If it is not a vowel, and the sbSyllable's length is 1 also the previous character is a consonant it gets the last item of
     * syllables {@link ArrayList} since there cannot be a Turkish word which starts with two consonants. However, if it is
     * two last characters of word, then it adds it to the syllable {@link ArrayList}. At the end, it updates the syllables {@link ArrayList}.
     *
     * @param word String input.
     * @throws IrregularWordException if it is not a regular Turkish word.
     */
    public SyllableList(String word) throws IrregularWordException {
        syllables = new ArrayList<Syllable>();
        StringBuilder sbSyllable = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            boolean isVowel = TurkishLanguage.isVowel(c);
            boolean isLastChar = i == word.length() - 1;
            if (isVowel) {
                sbSyllable.append(c);
                // If it is the last vowel.
                if (i == word.length() - 2) {
                    sbSyllable.append(word.charAt(i + 1));
                    i++;
                }
                syllables.add(new Syllable(sbSyllable.toString()));
                sbSyllable = new StringBuilder();
            } else {
                // A syllable should not start with two consonants.
                String tempSyl = sbSyllable.toString();
                if (tempSyl.length() == 1) {
                    // The previous character was also a consonant.
                    if (!TurkishLanguage.isVowel(tempSyl.charAt(0))) {
                        if (syllables.size() == 0){
                            sbSyllable.append(c);
                            continue;
                        }
                        int lastPos = syllables.size() - 1;
                        String str = syllables.get(lastPos).getText();
                        str = str + tempSyl;
                        if (isLastChar) {
                            // If the last char is also a consonant, add it to latest syllable. Ex: 'park'.
                            str = str + c;
                        }
                        // Update previous syllable.
                        syllables.set(lastPos, new Syllable(str));
                        sbSyllable = new StringBuilder();
                    }
                }
                sbSyllable.append(c);
            }
        }
    }

    /**
     * The getSyllables method creates a new {@link ArrayList} syllables and loops through the globally defined syllables
     * {@link ArrayList} and adds each item to the newly created syllables {@link ArrayList}.
     *
     * @return ArrayList syllables.
     */
    public ArrayList<String> getSyllables() {
        ArrayList<String> syllables = new ArrayList<>();
        for (Syllable syllable : this.syllables) {
            syllables.add(syllable.getText());
        }
        return syllables;
    }
}
