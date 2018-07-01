package Dictionary;

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
        loadFromText(filename);
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
            word.addFlag(flag);
        }
        return false;
    }

    /**
     * The mergeDictionary method takes a String inputs; secondFilename and mergedFilename. It reads given files line by
     * line and splits them according to spaces and write each word to file whichever comes first lexicographically and
     * continue to read files till the end.
     *
     * @param secondFilename String input.
     * @param mergedFilename String input.
     */
    public void mergeDictionary(String secondFilename, String mergedFilename) {
        FileReader first, second;
        FileWriter outfile;
        BufferedReader firstfile, secondfile;
        String st1, st2;
        String word1, word2, flag;
        try {
            first = new FileReader(filename);
            firstfile = new BufferedReader(first);
            second = new FileReader(secondFilename);
            secondfile = new BufferedReader(second);
            outfile = new FileWriter(mergedFilename);
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
            if (st1 == null && st2 != null) {
                while (st2 != null) {
                    outfile.write(st2 + "\n");
                    st2 = secondfile.readLine();
                }
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
     * and assigns each word to the String array. Then, adds these word with their flags tot he words {@link java.util.ArrayList}.
     * At the end it sorts the words {@link java.util.ArrayList}.
     *
     * @param filename String input.
     */
    private void loadFromText(String filename) {
        int i;
        String line;
        String[] list;
        TxtWord currentWord;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF8"));
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
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File " + filename + " not found");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
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
        FileWriter outfile;
        int i;
        try {
            outfile = new FileWriter(filename);
            for (i = 0; i < words.size(); i++) {
                outfile.write(words.get(i).toString() + '\n');
            }
            outfile.close();
        } catch (IOException ioException) {
            System.out.println("Output file can not be opened");
        }
    }
}
