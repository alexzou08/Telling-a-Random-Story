
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.Scanner;
import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;
 

public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> counts;
    
    public CharactersInPlay() {
        names = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    
    public void update(String person) {
            
            if(! names.contains(person)){
                names.add(person);
                counts.add(1);
            } else {
                int index = names.indexOf(person);
                counts.set(index,counts.get(index)+1);
            }
        
    }
    
    public void findAllCharacters() {
        FileResource fr = new FileResource();
        String person = null;
        names.clear();
        counts.clear();
        for(String line : fr.lines()) {
            int idxPeriod = line.indexOf("."); 
            if(idxPeriod != -1) {
                person = line.substring(0,idxPeriod);
                update(person);
            }
        }
    }
    
    public void tester() {
        findAllCharacters();
        for(int k=0; k < names.size(); k++) {
            if(counts.get(k) > 100) {
                System.out.println(names.get(k)+ "\t" +counts.get(k));
            }
        }
        charactersWithNumParts(10,15);
    }
    
    public void charactersWithNumParts(int num1, int num2) {
        System.out.println("num1 is " + num1 + "\t" + "num2 is " + num2);
        for(int k=0; k < names.size(); k++) {
            if(counts.get(k) >= num1 && counts.get(k) <= num2) {
                System.out.println(names.get(k)+ "\t" +counts.get(k)); 
            }
        }
    }
}
