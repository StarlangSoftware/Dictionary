package Dictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Math.*;

public class VectorizedDictionary extends Dictionary implements Serializable{

    public VectorizedDictionary(WordComparator comparator) {
        super(comparator);
    }

    private void readObject(ObjectInputStream inputStream) throws ClassNotFoundException, IOException {
        inputStream.defaultReadObject();
        Collections.sort(words, comparator);
    }

    public void addWord(VectorizedWord word){
        words.add(word);
    }

    public void save(String fileName){
        FileOutputStream outFile;
        ObjectOutputStream outObject;
        try {
            outFile = new FileOutputStream(fileName);
            outObject = new ObjectOutputStream(outFile);
            outObject.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public VectorizedWord mostSimilarWord(String name){
        double maxDistance = -Double.MAX_VALUE;
        VectorizedWord result = null;
        VectorizedWord word = (VectorizedWord) getWord(name);
        if (word == null){
            return null;
        }
        for (Word currentWord:words){
            VectorizedWord current = (VectorizedWord) currentWord;
            if (!current.equals(word)){
                double distance = 0;
                try {
                    distance = word.getVector().dotProduct(current.getVector());
                } catch (VectorSizeMismatch vectorSizeMismatch) {
                }
                if (distance > maxDistance){
                    maxDistance = distance;
                    result = current;
                }
            }
        }
        return result;
    }

    public ArrayList<VectorizedWord> mostSimilarKWords(String name, int k){
        class WordComparator implements Comparator<VectorizedWord> {
            private VectorizedWord comparedWord;

            public WordComparator(VectorizedWord comparedWord){
                this.comparedWord = comparedWord;
            }

            public int compare(VectorizedWord wordA, VectorizedWord wordB) {
                Vector v = comparedWord.getVector(), vA = wordA.getVector(), vB = wordB.getVector();
                double result1 = 0, result2 = 0;
                try {
                    result1 = v.dotProduct(vB) / Math.sqrt(v.dotProduct() * vB.dotProduct());
                    result2 = v.dotProduct(vA) / Math.sqrt(v.dotProduct() * vA.dotProduct());
                } catch (VectorSizeMismatch vectorSizeMismatch) {
                    vectorSizeMismatch.printStackTrace();
                }
                return Double.compare(result1, result2);
            }
        }
        ArrayList<VectorizedWord> resultWords = new ArrayList<>();
        VectorizedWord word = (VectorizedWord) getWord(name);
        if (word == null){
            return resultWords;
        }
        for (Word currentWord:words){
            resultWords.add((VectorizedWord) currentWord);
        }
        Collections.sort(resultWords, new WordComparator(word));
        while (resultWords.size() > k){
            resultWords.remove(resultWords.size() - 1);
        }
        return resultWords;
    }

    public ArrayList[] kMeansClustering(int iteration, int k){
        ArrayList<Word>[] result = new ArrayList[k];
        Vector[] means = new Vector[k];
        int vectorSize = ((VectorizedWord) words.get(0)).getVector().size();
        for (int i = 0; i < k; i++){
            result[i] = new ArrayList<>();
            means[i] = new Vector(vectorSize, 0);
        }
        for (int i = 0; i < words.size(); i++){
            result[i % k].add(words.get(i));
            try {
                means[i % k].add(((VectorizedWord) words.get(i)).getVector());
            } catch (VectorSizeMismatch vectorSizeMismatch) {
            }
        }
        for (int i = 0; i < k; i++){
            means[i].divide(result[i].size());
            means[i].divide(Math.sqrt(means[i].dotProduct()));
        }
        for (int i = 0; i < iteration; i++){
            for (int j = 0; j < k; j++){
                result[j].clear();
            }
            for (Word word:words){
                VectorizedWord vectorizedWord = (VectorizedWord) word;
                double maxClusterDistance = 0;
                try {
                    maxClusterDistance = means[0].dotProduct(vectorizedWord.getVector());
                } catch (VectorSizeMismatch vectorSizeMismatch) {
                }
                int maxClusterIndex = 0;
                for (int j = 1; j < k; j++){
                    double clusterDistance = 0;
                    try {
                        clusterDistance = means[j].dotProduct(vectorizedWord.getVector());
                    } catch (VectorSizeMismatch vectorSizeMismatch) {
                    }
                    if (clusterDistance > maxClusterDistance){
                        maxClusterDistance = clusterDistance;
                        maxClusterIndex = j;
                    }
                }
                result[maxClusterIndex].add(word);
            }
            for (int j = 0; j < k; j++){
                means[j].clear();
                for (Word word:result[j]){
                    try {
                        means[j].add(((VectorizedWord) (word)).getVector());
                    } catch (VectorSizeMismatch vectorSizeMismatch) {
                    }
                }
                means[j].divide(result[j].size());
                means[j].divide(Math.sqrt(means[j].dotProduct()));
            }
        }
        return result;
    }

}
