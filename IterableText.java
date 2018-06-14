import java.util.Iterator;

public interface IterableText<String> {

    public Iterator<String> wordIterator();
    public Iterator<String> charIterator();

}