import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

public class WordIterator implements Iterator<String> {
    private Iterator<String> iter;//3rd version;
    //in case of 2nd implementation:
    //private List<String> words;
    //private int index;
    
    WordIterator(FileContent text){
        iter = text.wordIterator();
        //this.words = text.getWords();
    }

    public boolean hasNext() {
        return iter.hasNext(); // 3rd version 2nd simpl impl.;
        //return index < words.size(); //2nd possible implementation;
      }
  
      public String next() throws NoSuchElementException {
        return iter.next(); // 3rd version simpl.impl.;
        /*
         * Throw NoSuchElementException as defined by the Iterator contract,
         * not IndexOutOfBoundsException.
         */
            // 2nd possible implementation
        //if (!hasNext())
          //throw new NoSuchElementException();
        //return words.get(index++); // 1st possible implementation;
      }

    public static void main(String[] args) throws FileNotFoundException {
        FileContent test = new FileContent("test.txt");
        WordIterator witer = new WordIterator(test);
        while(witer.hasNext()){
            System.out.println(witer.next());
            //System.out.println(witer.hasNext());
        }
    }  
}