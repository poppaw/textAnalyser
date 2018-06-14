import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileContent implements IterableText<String> {
    private String fileName;
    private List<String> words;
    private List<String> letters; //Aga doesn't agree with it.
    //private String rawText = "";
    static Scanner reader;

    FileContent(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        words = new ArrayList<>();
        letters = new ArrayList<>();
        reader = new Scanner(new File(fileName));
        while (reader.hasNext()) {
            String aWord = reader.next();
                words.add(aWord);
                //rawText += aWord + " ";//nobody knows if needs it;
                for (char ch: aWord.toCharArray()) {
                    letters.add(String.valueOf(ch));   
                }
        }
    }

    @Override //?necessary Override?
    public Iterator<String> wordIterator(){ //throws NoSuchElementException
        return words.iterator();

        // class WordIt{
        /*
        * Throw NoSuchElementException as defined by the Iterator contract,
        * not IndexOutOfBoundsException.
        
        int index = 0;
        hasNext(){
            return index < words.size();
        }

      if (!hasNext())
        throw new NoSuchElementException();
      return words.get(index++); // 1st possible implementation;*/
        
    }

    @Override // as above;
    public Iterator<String> charIterator(){ //throws NoSuchElementException
        return letters.iterator();

        //class charIt{
        /*
        * Throw NoSuchElementException as defined by the Iterator contract,
        * not IndexOutOfBoundsException.
        
        int index = 0;
        hasNext(){
            return index < letters.size();
        }

      if (!hasNext())
        throw new NoSuchElementException();
      return letters.get(index++); // 1st possible implementation;
    }
      */
    }


    public List<String> getWords(){ //should be default acc. to Aga
        return words;
    }

    List<String> getLetters(){ //default, not public!!!!            
        return letters;
    }

    public int getTextSize(){ //mogłoby być użyteczne gdyby nie specyfikacja
        return words.size();
    }

    public int lettersNumber(){ // j.w.
        return letters.size();
    }
    
    public String toString(){
        return words.toString();
    }

    public String lettersToString(){ // nobody knows...
        return letters.toString();
    }
    
    public String getFileName(){
        return fileName;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileContent test = new FileContent("test.txt");
        //System.out.println(test.getTextSize());
        System.out.println(test.wordIterator().next());
        //System.out.println(test.lettersNumber());
        Iterator<String> pluszak = test.wordIterator();
        while(pluszak.hasNext()) System.out.println(pluszak.next());
        //System.out.println("Letters:\n" + test.letters);
    }




}