package Dictionary;

import java.io.*;
import java.util.Collections;
import java.util.Locale;

public class TxtDictionary extends Dictionary{

    public TxtDictionary(WordComparator comparator){
        super(comparator);
    }

    public TxtDictionary(String filename, WordComparator comparator){
        super(comparator);
        this.filename = filename;
        loadFromText(filename);
    }

    public TxtDictionary clone(){
        return new TxtDictionary(filename, comparator);
    }

    public void addNumber(String name){
        addWithFlag(name, "IS_SAYI");
    }

    public void addRealNumber(String name){
        addWithFlag(name, "IS_REELSAYI");
    }

    public void addFraction(String name){
        addWithFlag(name, "IS_KESIR");
    }

    public void addTime(String name){
        addWithFlag(name, "IS_ZAMAN");
    }

    public boolean addWithFlag(String name, String flag){
        TxtWord word;
        if (getWord(name.toLowerCase(new Locale("tr"))) == null){
            word = new TxtWord(name.toLowerCase(new Locale("tr")));
            word.addFlag(flag);
            int insertIndex = -Collections.binarySearch(words, word, comparator) - 1;
            if (insertIndex >= 0){
                words.add(insertIndex, word);
            }
            return true;
        } else {
            word = (TxtWord) getWord(name.toLowerCase(new Locale("tr")));
            word.addFlag(flag);
        }
        return false;
    }

    public boolean addProperNoun(String name){
        return addWithFlag(name, "IS_OA");
    }

    public boolean addNoun(String name){
        return addWithFlag(name, "CL_ISIM");
    }

    public boolean addVerb(String name){
        return addWithFlag(name, "CL_FIIL");
    }

    public void mergeDictionary(String secondFilename, String mergedFilename){
        FileReader first, second;
        FileWriter outfile;
        BufferedReader firstfile, secondfile;
        String st1, st2;
        String word1, word2, flag;
        try{
            first = new FileReader(filename);
            firstfile = new BufferedReader(first);
            second = new FileReader(secondFilename);
            secondfile = new BufferedReader(second);
            outfile = new FileWriter(mergedFilename);
            st1 = firstfile.readLine();
            st2 = secondfile.readLine();
            while (st1 != null && st2 != null){
                word1 = st1.split(" ")[0];
                word2 = st2.split(" ")[0];
                if (word1.compareToIgnoreCase(word2) < 0){
                    outfile.write(st1 + "\n");
                    st1 = firstfile.readLine();
                } else {
                    if (word1.compareToIgnoreCase(word2) > 0){
                        outfile.write(st2 + "\n");
                        st2 = secondfile.readLine();
                    } else {
                        flag = st2.split(" ")[1];
                        if (st1.contains(flag)){
                            outfile.write(st1 + "\n");
                        } else {
                            outfile.write(st1 + " " + flag + "\n");
                        }
                        st1 = firstfile.readLine();
                        st2 = secondfile.readLine();
                    }
                }
            }
            if (st1 == null && st2 != null){
                while (st2 != null){
                    outfile.write(st2 + "\n");
                    st2 = secondfile.readLine();
                }
            }
            outfile.close();
        }
        catch (FileNotFoundException fileNotFoundException){
            System.out.println("Dosya bulunamadı");
        }
        catch (IOException e) {
            System.out.println("Dosya okunamadı");
        }
    }

    private void loadFromText(String filename){
        int i;
        String line;
        String[] list;
        TxtWord currentWord;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF8"));
            line = br.readLine();
            while (line != null){
                list = line.split(" ");
                if (list.length > 0){
                    currentWord = new TxtWord(list[0]);
                    for (i = 1; i < list.length; i++){
                        currentWord.addFlag(list[i]);
                    }
                    words.add(currentWord);
                }
                line = br.readLine();
            }
        }
        catch (FileNotFoundException fileNotFoundException){
            System.out.println("File " + filename + " not found");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(words, comparator);
    }

    public void saveAsTxt(String filename){
        FileWriter outfile;
        int i;
        try{
            outfile = new FileWriter(filename);
            for (i = 0; i < words.size(); i++){
                outfile.write(words.get(i).toString() + '\n');
            }
            outfile.close();
        }
        catch (IOException ioException){
            System.out.println("Output file can not be opened");
        }
    }
}
