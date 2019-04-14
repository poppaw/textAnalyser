import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileContent implements IterableText<String> {

    private String fileName;
    private List<String> words;
    private List<String> letters; //Aga suggests without it.
    //private String rawText = "";
    static Scanner reader;

    public FileContent(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        words = new ArrayList<>();
        letters = new ArrayList<>();
        reader = new Scanner(new File(fileName));
        while (reader.hasNext()) {
            String aWord = reader.next();
                words.add(aWord);
                //rawText += aWord + " ";//nobody knows if we need it;
                for (char ch: aWord.toCharArray()) {
                    letters.add(String.valueOf(ch));   
                }
        }
    }

    @Override //?necessary Override?
    public Iterator<String> wordIterator(){ //throws NoSuchElementException
        return words.iterator();
    }
    //2nd implementation:
        // class WordIt{
        /*
        * Throw NoSuchElementException,
        * not IndexOutOfBoundsException.
        
        int index = 0;
        hasNext(){
            return index < words.size();
        }
        next(){
            if (!hasNext())
                throw new NoSuchElementException();
            return words.get(index++);
        }*/

    @Override // @Override?;
    public Iterator<String> charIterator(){ //throws NoSuchElementException
        return letters.iterator();
    }

        //2nd implementation;
        //class charIt{
        /*
        * Throw NoSuchElementException not IndexOutOfBoundsException. 
        int index = 0;
        hasNext(){
            return index < letters.size();
        }
        next()
            if (!hasNext())
                throw new NoSuchElementException();
            return letters.get(index++);
        }
        */

    /*
    * necessary only in case of 2nd Iterator implementation:

        List<String> getWords(){ //default; 
            return words;
        }

        List<String> getLetters(){ //default;           
            return letters;
        }
    */

    public String getFileName(){
        return fileName;
    }
}