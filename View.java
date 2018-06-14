import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.io.FileNotFoundException;
import static java.lang.System.currentTimeMillis;



public class View {
    //private StatisticalAnalysis analyser;

    public static void printEntireSize(StatisticalAnalysis analyser){
        String type = removeSuffix(analyser);
        System.out.printf("%s count: %d \n", type, analyser.size());
    }

    private static String removeSuffix(StatisticalAnalysis analyser) {
        /*
         * classname options: string 'WordIterator' or 'CharIterator';
         * returns 'Word' or 'Char' as 4-chars substring of whole className;
         */
        return analyser.getClassName().substring(0,4);
        
    }

    public static void printDictSize(StatisticalAnalysis analyser){
        System.out.println("Dict size: " + analyser.dictionarySize());
    }

    public static void printMostPopular(StatisticalAnalysis analyser, int percentPoint){
        double percentageOfOccurrance = onePercent(analyser)*percentPoint;
        long occurance = Math.round(percentageOfOccurrance);
        int numberOfOccurrance = (int) occurance;
        Set<String> mostPopoular = analyser.occurMoreThan(numberOfOccurrance);
        System.out.printf("Most used words >%d percent :", percentPoint);
        System.out.println(mostPopoular);
    }

    public static double onePercent(StatisticalAnalysis analyser){ //double
        int hundredPerc = analyser.size();
        return hundredPerc/100.00;
    } 

    
    public static void main(String[] args) throws FileNotFoundException {
        Long startTime = currentTimeMillis();
        
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //System.out.println(timestamp);
        FileContent test = new FileContent("test.txt");
        Iterator<String> worditer = new WordIterator(test);
        Iterator<String> chariter = new CharIterator(test);
        //Map<String,Integer> sta = new StatisticalAnalysis(iter);
        StatisticalAnalysis staW = new StatisticalAnalysis(worditer);
        StatisticalAnalysis staCh = new StatisticalAnalysis(chariter);
        printEntireSize(staCh);
        printEntireSize(staW);
        printDictSize(staW);
        printMostPopular(staW,1); 
        Long endTime = currentTimeMillis();
        System.out.println("Current time: " + (endTime-startTime) + "mss.");
    }


}