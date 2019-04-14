import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class StatisticalAnalysis {
    private Map<String, Integer> dictionary = new HashMap<>();
    private String className; //addictional pool - for printing;

    public StatisticalAnalysis(Iterator<String> iter){
        while (iter.hasNext()){
            String aStringLowered = iter.next().toLowerCase();
            dictionary.put(aStringLowered, dictionary.getOrDefault(aStringLowered, 0)+1);//1st possibility;
            //dictionary.merge(aStringLowered, 1, Integer::sum); //2nd possibility
        }
        this.className = iter.getClass().getName(); 
    }


    public int countOf(String... elems){
        int countOf = 0;
        for (String el: elems){
            countOf += dictionary.getOrDefault(el, 0);
        }
        return countOf;
    }
    
    public int dictionarySize(){
        return dictionary.size();
    }
    
    public int size(){
        /*
        *returns total number of elements;
        */
        int sum = 0;
        for(int occurance: dictionary.values())
            sum += occurance;
        return sum;
        //dictionary.forEach((k,v) -> sum += v); 
    }


    public Set<String> occurMoreThan(Integer n){
        Set<String> mostOccurring = new TreeSet<>();
        dictionary.forEach((k,v) -> { if(v>n) mostOccurring.add(k);});
        return mostOccurring;
    }

    public String getClassName(){ // not in UML;
        return className;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileContent test = new FileContent("test.txt");
        Iterator<String> iter = new WordIterator(test);
        StatisticalAnalysis sta = new StatisticalAnalysis(iter);
        System.out.println("class name of iter: "+sta.className);
        System.out.println("count of(a,b): " +sta.countOf("a","b"));
        System.out.println("dict size: " +sta.dictionarySize());
        System.out.println("size: " +sta.size());
        System.out.println("more than 10: " +sta.occurMoreThan(10));
        
    }

}