package Dictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Math.*;

public class VectorizedDictionary extends Dictionary implements Serializable {

    /**
     * A constructor of {@link VectorizedDictionary} class which takes a {@link WordComparator} as an input and calls its
     * super class {@link Dictionary} with {@link WordComparator} input.
     *
     * @param comparator {@link WordComparator} type input.
     */
    public VectorizedDictionary(WordComparator comparator) {
        super(comparator);
    }

    /**
     * The readObject method takes an {@link ObjectInputStream} as an input and calls defaultReadObject method with this
     * {@link ObjectInputStream} to read the non-static and non-transient fields of the current class. Then, sorts the
     * words {@link ArrayList}.
     *
     * @param inputStream {@link ObjectInputStream} type input.
     * @throws ClassNotFoundException exception.
     * @throws IOException            exception.
     */
    private void readObject(ObjectInputStream inputStream) throws ClassNotFoundException, IOException {
        inputStream.defaultReadObject();
        words.sort(comparator);
    }

    /**
     * The addWord method takes a {@link VectorizedWord} as an input and adds it to the words {@link ArrayList}.
     *
     * @param word {@link VectorizedWord} input.
     */
    public void addWord(VectorizedWord word) {
        words.add(word);
    }

    /**
     * The save method takes a String fileName as an input and writes {@link Object} to the created output stream.
     *
     * @param fileName String input.
     */
    public void save(String fileName) {
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

    /**
     * The mostSimilarWord method takes a String name as an input, declares a maxDistance as -MAX_VALUE and creates a
     * {@link VectorizedWord} word by getting the given name from words {@link ArrayList}. Then, it loops through the
     * words {@link ArrayList} and if the current word is not equal to given input it calculates the distance between current
     * word and given word by using dot product and updates the maximum distance. It then returns the result {@link VectorizedWord}
     * which holds the most similar word to the given word.
     *
     * @param name String input.
     * @return VectorizedWord type result which holds the most similar word to the given word.
     */
    public VectorizedWord mostSimilarWord(String name) {
        double maxSimilarity = -Double.MAX_VALUE;
        VectorizedWord result = null;
        VectorizedWord word = (VectorizedWord) getWord(name);
        if (word == null) {
            return null;
        }
        for (Word currentWord : words) {
            VectorizedWord current = (VectorizedWord) currentWord;
            if (!current.equals(word)) {
                double similarity = 0;
                try {
                    similarity = word.getVector().cosineSimilarity(current.getVector());
                } catch (VectorSizeMismatch vectorSizeMismatch) {
                }
                if (similarity > maxSimilarity) {
                    maxSimilarity = similarity;
                    result = current;
                }
            }
        }
        return result;
    }

    /**
     * The mostSimilarKWords method takes a String name and an integer k as inputs, and creates an {@link ArrayList} resultWords
     * of type {@link VectorizedWord} and a {@link VectorizedWord} word by getting the given name from words {@link ArrayList}.
     * Then, it loops through the words {@link ArrayList} and adds current word to the resultWords. It then sort resultWords {@link ArrayList}
     * and if the size of the {@link ArrayList} is greater than given input k, it removes items from the ending. Then, it returns
     * resultWords {@link ArrayList}.
     *
     * @param name String input.
     * @param k Integer input.
     * @return ArrayList result.
     */
    public List<VectorizedWord> mostSimilarKWords(String name, int k) {
        class WordComparator implements Comparator<VectorizedWord> {
            private VectorizedWord comparedWord;

            /**
             * A constructor of WordComparator class which takes a {@link VectorizedWord} as an input and assigns to the
             * comparedWord variable.
             *
             * @param comparedWord {@link VectorizedWord} type input.
             */
            public WordComparator(VectorizedWord comparedWord) {
                this.comparedWord = comparedWord;
            }

            /**
             * The compare method takes two {@link VectorizedWord}s as inputs and finds out the dot products as result1
             * and result2, then it calls the compare method wirth result1 and result2. It returns the value {@code 0}
             * if result1 is  numerically equal to result2; a value less than {@code 0} if result1 is numerically less than
             * result2; and a value greater than {@code 0} if result1 is numerically greater than result2.
             *
             * @param wordA {@link VectorizedWord} type input.
             * @param wordB {@link VectorizedWord} type input.
             * @return the value {@code 0} if result1 is  numerically equal to result2; a value less than {@code 0} if
             * result1 is numerically less than result2; and a value greater than {@code 0} if result1 is numerically
             * greater than result2.
             */
            public int compare(VectorizedWord wordA, VectorizedWord wordB) {
                Vector v = comparedWord.getVector(), vA = wordA.getVector(), vB = wordB.getVector();
                double result1 = 0, result2 = 0;
                try {
                    result1 = v.cosineSimilarity(vB);
                    result2 = v.cosineSimilarity(vA);
                } catch (VectorSizeMismatch vectorSizeMismatch) {
                    vectorSizeMismatch.printStackTrace();
                }
                return Double.compare(result1, result2);
            }
        }
        ArrayList<VectorizedWord> resultWords = new ArrayList<>();
        VectorizedWord word = (VectorizedWord) getWord(name);
        if (word == null) {
            return resultWords;
        }
        for (Word currentWord : words) {
            resultWords.add((VectorizedWord) currentWord);
        }
        Collections.sort(resultWords, new WordComparator(word));
        return resultWords.subList(0, k);
    }

    /**
     * The kMeansClustering method takes an integer iteration and k as inputs. K-means clustering aims to partition n observations
     * into k clusters in which each observation belongs to the cluster with the nearest mean.
     *
     * @param iteration Integer input.
     * @param k         Integer input.
     * @return ArrayList result which holds the k-means clustered words.
     */
    public ArrayList[] kMeansClustering(int iteration, int k) {
        ArrayList<Word>[] result = new ArrayList[k];
        Vector[] means = new Vector[k];
        int vectorSize = ((VectorizedWord) words.get(0)).getVector().size();
        for (int i = 0; i < k; i++) {
            result[i] = new ArrayList<>();
            means[i] = new Vector(vectorSize, 0);
        }
        for (int i = 0; i < words.size(); i++) {
            result[i % k].add(words.get(i));
            try {
                means[i % k].add(((VectorizedWord) words.get(i)).getVector());
            } catch (VectorSizeMismatch vectorSizeMismatch) {
            }
        }
        for (int i = 0; i < k; i++) {
            means[i].divide(result[i].size());
            means[i].divide(Math.sqrt(means[i].dotProduct()));
        }
        for (int i = 0; i < iteration; i++) {
            for (int j = 0; j < k; j++) {
                result[j].clear();
            }
            for (Word word : words) {
                VectorizedWord vectorizedWord = (VectorizedWord) word;
                double maxClusterSimilarity = 0;
                try {
                    maxClusterSimilarity = means[0].cosineSimilarity(vectorizedWord.getVector());
                } catch (VectorSizeMismatch vectorSizeMismatch) {
                }
                int maxClusterIndex = 0;
                for (int j = 1; j < k; j++) {
                    double clusterDistance = 0;
                    try {
                        clusterDistance = means[j].cosineSimilarity(vectorizedWord.getVector());
                    } catch (VectorSizeMismatch vectorSizeMismatch) {
                    }
                    if (clusterDistance > maxClusterSimilarity) {
                        maxClusterSimilarity = clusterDistance;
                        maxClusterIndex = j;
                    }
                }
                result[maxClusterIndex].add(word);
            }
            for (int j = 0; j < k; j++) {
                means[j].clear();
                for (Word word : result[j]) {
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
    public void sort(){
        words.sort(comparator);
    }

}
