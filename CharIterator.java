import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

public class CharIterator implements Iterator<String> {

    private Iterator<String> iter;//3rd version;
    //private List<String> letters;// in case of 2nd implement.
    //private int index = 0; //in case of 2nd implementation of Iterator methods (hasNext() and next();)


    public CharIterator(FileContent text){
      iter = text.charIterator(); //3rd version
      //this.letters = text.getLetters(); in case of 2nd implementation. 
    }

    public boolean hasNext() {
        return iter.hasNext(); //3rd version: simple implementation
        //return index < letters.size(); //in case of 2nd possible implementation;
    }
    
    public String next() throws NoSuchElementException {
      return iter.next(); //3rd version: simple impl.;
      
      /*
        * Throw NoSuchElementException as defined by the Iterator contract,
        * not IndexOutOfBoundsException.
        2nd possible implementation:
      if (!hasNext())
        throw new NoSuchElementException();
      //return letters.get(index++);
      */
      
    }

    //main for tests only;
    public static void main(String[] args) throws FileNotFoundException {
      FileContent test = new FileContent("test.txt");
      CharIterator chiter = new CharIterator(test);
      
      while (chiter.hasNext()){
        System.out.println(chiter.next());;
        //System.out.println(iter.index); //test for 1st implementation
        System.out.println(chiter.hasNext());
      } 
    }

}