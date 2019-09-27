package Dictionary;

import Dictionary.Trie.Trie;

import java.io.*;
import java.util.Collections;
import java.util.Locale;

public class TxtDictionary extends Dictionary {

    /**
     * A constructor of {@link TxtDictionary} class which takes a {@link WordComparator} as an input and calls its super
     * class {@link Dictionary} with given {@link WordComparator}.
     *
     * @param comparator {@link WordComparator} type input.
     */
    public TxtDictionary(WordComparator comparator) {
        super(comparator);
    }

    public TxtDictionary(){
        super(new TurkishWordComparator());
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("turkish_dictionary.txt").getFile());
        this.filename = file.getName();
        loadFromText(classLoader.getResourceAsStream("turkish_dictionary.txt"));
    }

    /**
     * Another constructor of {@link TxtDictionary} class which takes a String filename and a {@link WordComparator} as inputs.
     * And calls its super class {@link Dictionary} with given {@link WordComparator}, assigns given filename input to the
     * filename variable. Then, it calls loadFromText method with given filename.
     *
     * @param filename   String input.
     * @param comparator {@link WordComparator} input.
     */
    public TxtDictionary(String filename, WordComparator comparator) {
        super(comparator);
        this.filename = filename;
        try {
            loadFromText(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " not found");
        }
    }

    /**
     * The clone method which creates new {@link TxtDictionary} object with filename and comparator variables.
     *
     * @return new {@link TxtDictionary} object.
     */
    public TxtDictionary clone() {
        return new TxtDictionary(filename, comparator);
    }

    /**
     * The addNumber method takes a String name and calls addWithFlag method with given name and IS_SAYI flag.
     *
     * @param name String input.
     */
    public void addNumber(String name) {
        addWithFlag(name, "IS_SAYI");
    }

    /**
     * The addRealNumber method takes a String name and calls addWithFlag method with given name and IS_REELSAYI flag.
     *
     * @param name String input.
     */
    public void addRealNumber(String name) {
        addWithFlag(name, "IS_REELSAYI");
    }

    /**
     * The addFraction method takes a String name and calls addWithFlag method with given name and IS_KESIR flag.
     *
     * @param name String input.
     */
    public void addFraction(String name) {
        addWithFlag(name, "IS_KESIR");
    }

    /**
     * The addTime method takes a String name and calls addWithFlag method with given name and IS_ZAMAN flag.
     *
     * @param name String input.
     */
    public void addTime(String name) {
        addWithFlag(name, "IS_ZAMAN");
    }

    /**
     * The addProperNoun method takes a String name and calls addWithFlag method with given name and IS_OA flag.
     *
     * @param name String input.
     * @return true if given name is in words {@link java.util.ArrayList}, false otherwise.
     */
    public boolean addProperNoun(String name) {
        return addWithFlag(name, "IS_OA");
    }

    /**
     * The addNoun method takes a String name and calls addWithFlag method with given name and CL_ISIM flag.
     *
     * @param name String input.
     * @return true if given name is in words {@link java.util.ArrayList}, false otherwise.
     */
    public boolean addNoun(String name) {
        return addWithFlag(name, "CL_ISIM");
    }

    /**
     * The addVerb method takes a String name and calls addWithFlag method with given name and CL_FIIL flag.
     *
     * @param name String input.
     * @return true if given name is in words {@link java.util.ArrayList}, false otherwise.
     */
    public boolean addVerb(String name) {
        return addWithFlag(name, "CL_FIIL");
    }

    /**
     * The addAdjective method takes a String name and calls addWithFlag method with given name and IS_ADJ flag.
     *
     * @param name String input.
     * @return true if given name is in words {@link java.util.ArrayList}, false otherwise.
     */
    public boolean addAdjective(String name) {
        return addWithFlag(name, "IS_ADJ");
    }

    /**
     * The addAdverb method takes a String name and calls addWithFlag method with given name and IS_ADVERB flag.
     *
     * @param name String input.
     * @return true if given name is in words {@link java.util.ArrayList}, false otherwise.
     */
    public boolean addAdverb(String name) {
        return addWithFlag(name, "IS_ADVERB");
    }

    /**
     * The addPronoun method takes a String name and calls addWithFlag method with given name and IS_ZM flag.
     *
     * @param name String input.
     * @return true if given name is in words {@link java.util.ArrayList}, false otherwise.
     */
    public boolean addPronoun(String name) {
        return addWithFlag(name, "IS_ZM");
    }

    /**
     * The addWithFlag method takes a String name and a flag as inputs. First it creates a {@link TxtWord} word, then if
     * given name is not in words {@link java.util.ArrayList} it creates new {@link TxtWord} with given name and assigns it to
     * the word and adds given flag to the word, it also add newly created word to the words {@link java.util.ArrayList}'s index
     * found by performing a binary search and return true at the end. If given name is in words {@link java.util.ArrayList},
     * it adds it the given flag to the word.
     *
     * @param name String input.
     * @param flag String flag.
     * @return true if given name is in words {@link java.util.ArrayList}, false otherwise.
     */
    public boolean addWithFlag(String name, String flag) {
        TxtWord word;
        if (getWord(name.toLowerCase(new Locale("tr"))) == null) {
            word = new TxtWord(name.toLowerCase(new Locale("tr")));
            word.addFlag(flag);
            int insertIndex = -Collections.binarySearch(words, word, comparator) - 1;
            if (insertIndex >= 0) {
                words.add(insertIndex, word);
            }
            return true;
        } else {
            word = (TxtWord) getWord(name.toLowerCase(new Locale("tr")));
            if (!word.containsFlag(flag)){
                word.addFlag(flag);
            }
        }
        return false;
    }

    /**
     * The mergeDictionary method takes a String inputs; secondFileName and mergedFileName. It reads given files line by
     * line and splits them according to spaces and write each word to file whichever comes first lexicographically and
     * continue to read files till the end.
     *
     * @param secondFileName String input.
     * @param mergedFileName String input.
     */
    public void mergeDictionary(String secondFileName, String mergedFileName) {
        FileReader first, second;
        FileWriter outfile;
        BufferedReader firstfile, secondfile;
        String st1, st2;
        String word1, word2, flag;
        try {
            first = new FileReader(filename);
            firstfile = new BufferedReader(first);
            second = new FileReader(secondFileName);
            secondfile = new BufferedReader(second);
            outfile = new FileWriter(mergedFileName);
            st1 = firstfile.readLine();
            st2 = secondfile.readLine();
            while (st1 != null && st2 != null) {
                word1 = st1.split(" ")[0];
                word2 = st2.split(" ")[0];
                if (word1.compareToIgnoreCase(word2) < 0) {
                    outfile.write(st1 + "\n");
                    st1 = firstfile.readLine();
                } else {
                    if (word1.compareToIgnoreCase(word2) > 0) {
                        outfile.write(st2 + "\n");
                        st2 = secondfile.readLine();
                    } else {
                        flag = st2.split(" ")[1];
                        if (st1.contains(flag)) {
                            outfile.write(st1 + "\n");
                        } else {
                            outfile.write(st1 + " " + flag + "\n");
                        }
                        st1 = firstfile.readLine();
                        st2 = secondfile.readLine();
                    }
                }
            }
            while (st1 != null) {
                outfile.write(st1 + "\n");
                st1 = firstfile.readLine();
            }
            while (st2 != null) {
                outfile.write(st2 + "\n");
                st2 = secondfile.readLine();
            }
            outfile.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Dosya bulunamadı");
        } catch (IOException e) {
            System.out.println("Dosya okunamadı");
        }
    }

    /**
     * The loadFromText method takes a String filename as an input. It reads given file line by line and splits according to space
     * and assigns each word to the String array. Then, adds these word with their flags to the words {@link java.util.ArrayList}.
     * At the end it sorts the words {@link java.util.ArrayList}.
     *
     * @param fileInputStream File stream input.
     */
    private void loadFromText(InputStream fileInputStream) {
        int i;
        String line;
        String[] list;
        TxtWord currentWord;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, "UTF8"));
            line = br.readLine();
            while (line != null) {
                list = line.split(" ");
                if (list.length > 0) {
                    currentWord = new TxtWord(list[0]);
                    for (i = 1; i < list.length; i++) {
                        currentWord.addFlag(list[i]);
                    }
                    words.add(currentWord);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(words, comparator);
    }

    /**
     * The saveAsTxt method takes a filename as an input and prints out the items of words {@link java.util.ArrayList}.
     *
     * @param filename String input.
     */
    public void saveAsTxt(String filename) {
        BufferedWriter outfile;
        int i;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filename), "UTF-8");
            outfile = new BufferedWriter(writer);
            for (i = 0; i < words.size(); i++) {
                outfile.write(words.get(i).toString() + "\n");
            }
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }

    /**
     * The addWordWhenRootSoften is used to add word to Trie whose last consonant will be soften.
     * For instance, in the case of Dative Case Suffix, the word is 'müzik' when '-e' is added to the word, the last
     * char is drooped and root became 'müzi' and by changing 'k' into 'ğ' the word transformed into 'müziğe' as in the
     * example of 'Herkes müziğe doğru geldi'.
     * <p>
     * In the case of accusative, possessive of third person and a derivative suffix, the word is 'kanat' when '-i' is
     * added to word, last char is dropped, root became 'kana' then 't' transformed into 'd' and added to Trie. The word is
     * changed into 'kanadı' as in the case of 'Kuşun kırık kanadı'.
     *
     * @param trie the name of the Trie to add the word.
     * @param last the last char of the word to be soften.
     * @param root the substring of the word whose last one or two chars are omitted from the word to bo softed.
     * @param word the original word.
     */
    private void addWordWhenRootSoften(Trie trie, char last, String root, TxtWord word) {
        switch (last) {
            case 'p':
                trie.addWord(root + 'b', word);
                break;
            case '\u00e7': //ç
                trie.addWord(root + 'c', word);
                break;
            case 't':
                trie.addWord(root + 'd', word);
                break;
            case 'k':
            case 'g':
                trie.addWord(root + '\u011f', word); //ğ
                break;
        }
    }

    /**
     * The prepareTrie method is used to create a Trie with the given dictionary. First, it gets the word from dictionary,
     * then checks some exceptions like 'ben' which does not fit in the consonant softening rule and transforms into 'bana',
     * and later on it generates a root by removing the last char from the word however if the length of the word is greater
     * than 1, it also generates the root by removing the last two chars from the word.
     * <p>
     * Then, it gets the last char of the root and adds root and word to the result Trie. There are also special cases such as;
     * lastIdropsDuringSuffixation condition, if it is true then addWordWhenRootSoften method will be used rather than addWord.
     * Ex : metin + i = metni
     * isPortmanteauEndingWithSI condition, if it is true then addWord method with rootWithoutLastTwo will be used.
     * Ex : ademelması + lar = ademelmaları
     * isPortmanteau condition, if it is true then addWord method with rootWithoutLast will be used.
     * Ex : mısıryağı + lar = mısıryağları
     * vowelEChangesToIDuringYSuffixation condition, if it is then addWord method with rootWithoutLast will be used
     * depending on the last char whether it is 'e' or 'a'.
     * Ex : ye + iniz - yiyiniz
     * endingKChangesIntoG condition, if it is true then addWord method with rootWithoutLast will be used with added 'g'.
     * Ex : ahenk + i = ahengi
     *
     * @return the resulting Trie.
     */
    public Trie prepareTrie() {
        Trie result = new Trie();
        String root, rootWithoutLast, rootWithoutLastTwo;
        char last, lastBefore = ' ';
        int length;
        for (int i = 0; i < size(); i++) {
            TxtWord word = (TxtWord) getWord(i);
            root = word.getName();
            length = root.length();
            if (root.equals("ben")) {
                result.addWord("bana", word);
            }
            rootWithoutLast = root.substring(0, length - 1);
            if (length > 1) {
                rootWithoutLastTwo = root.substring(0, length - 2);
            } else {
                rootWithoutLastTwo = "";
            }
            if (length > 1){
                lastBefore = root.charAt(length - 2);
            }
            last = root.charAt(length - 1);
            result.addWord(root, word);
            if (word.lastIdropsDuringSuffixation() || word.lastIdropsDuringPassiveSuffixation()) {
                if (word.rootSoftenDuringSuffixation()) {
                    addWordWhenRootSoften(result, last, rootWithoutLastTwo, word);
                } else {
                    result.addWord(rootWithoutLastTwo + last, word);
                }
            }
            // NominalRootNoPossesive
            if (word.isPortmanteauEndingWithSI()) {
                result.addWord(rootWithoutLastTwo, word);
            }
            if (word.rootSoftenDuringSuffixation()) {
                addWordWhenRootSoften(result, last, rootWithoutLast, word);
            }
            if (word.isPortmanteau()) {
                if (word.isPortmanteauFacedVowelEllipsis()){
                    result.addWord(rootWithoutLastTwo + last + lastBefore, word);
                } else {
                    if (word.isPortmanteauFacedSoftening()){
                        switch (lastBefore){
                            case 'b':
                                result.addWord(rootWithoutLastTwo + 'p', word);
                                break;
                            case 'c':
                                result.addWord(rootWithoutLastTwo + 'ç', word);
                                break;
                            case 'd':
                                result.addWord(rootWithoutLastTwo + 't', word);
                                break;
                            case 'ğ':
                                result.addWord(rootWithoutLastTwo + 'k', word);
                                break;
                        }
                    } else {
                        result.addWord(rootWithoutLast, word);
                    }
                }
            }
            if (word.vowelEChangesToIDuringYSuffixation() || word.vowelAChangesToIDuringYSuffixation()) {
                switch (last) {
                    case 'e':
                        result.addWord(rootWithoutLast, word);
                        break;
                    case 'a':
                        result.addWord(rootWithoutLast, word);
                        break;
                }
            }
            if (word.endingKChangesIntoG()) {
                result.addWord(rootWithoutLast + 'g', word);
            }
        }
        return result;
    }

}
