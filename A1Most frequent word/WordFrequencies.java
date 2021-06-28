
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String s : fr.words()) {
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1) {
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
        }
    }
    
    public void tester() {
        findUnique();
        System.out.println("# unique words: " + myWords.size());
        //for(int k=0; k<myWords.size(); k++) {
        //    System.out.println(myFreqs.get(k) + "\t" + myWords.get(k));
        //}
        int max = findIndexOfMax();
        System.out.println("The word that occurs most often and it count are: " + 
                           myWords.get(max) + " " + myFreqs.get(max));
    }
    
    public int findIndexOfMax() {
        int maxIndex = 0;
        int max = myFreqs.get(0);
        for(int k=0; k < myFreqs.size(); k++) {
            if(myFreqs.get(k) > max) {
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
}
