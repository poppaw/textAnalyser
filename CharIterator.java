import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

public class CharIterator implements Iterator<String> {

    private Iterator<String> iter; //simple implementation
    // in case of 2nd implement of Iterator methods (hasNext() and next():
    //private List<String> letters;
    //private int index = 0;


    public CharIterator(FileContent text){
      iter = text.charIterator(); //3rd version
      //this.letters = text.getLetters(); in case of 2nd implementation. 
    }

    public boolean hasNext() {
        return iter.hasNext();
        //return index < letters.size(); //in case of 2nd implementation;
    }
    
    public String next() throws NoSuchElementException {
      return iter.next(); //simple;
      
      /*
        2nd possible implementation:
      if (!hasNext())
        throw new NoSuchElementException();
      //return letters.get(index++);
      */ 
    }
}