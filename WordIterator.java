import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

public class WordIterator implements Iterator<String> {
    private Iterator<String> iter; //in case 1st imolementation;
    //in case of 2nd implementation:
    //private List<String> words;
    //private int index;
    
    WordIterator(FileContent text){
        iter = text.wordIterator();
        //this.words = text.getWords(); //in case of 2nd impl.
    }

    public boolean hasNext() {
        return iter.hasNext();
        //return index < words.size(); //2nd possible implementation;
      }
  
      public String next() throws NoSuchElementException {
        return iter.next();
        /*
         * Throw NoSuchElementException,not IndexOutOfBoundsException.
         */
            // 2nd possible implementation:
        //if (!hasNext())
          //throw new NoSuchElementException();
        //return words.get(index++);
      }
}