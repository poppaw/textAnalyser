import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.io.FileNotFoundException;
import static java.lang.System.currentTimeMillis;


public class View {

    private FileContent content;
    private Iterator<String> charIt;
    private Iterator<String> wordIt;
    private StatisticalAnalysis charAnalyser;
    private StatisticalAnalysis wordAnalyser;


    public View(String fileName) throws FileNotFoundException {

            content = new FileContent(fileName);
            charIt = new CharIterator(content);
            wordIt = new WordIterator(content);
            charAnalyser = new StatisticalAnalysis(charIt);
            wordAnalyser = new StatisticalAnalysis(wordIt);
        }
    
    

    public void printAllAnalysis(){
        Long startTime = currentTimeMillis();
        printHead();
        printEntireSize(charAnalyser);
        printEntireSize(wordAnalyser);
        printDictSize(wordAnalyser);
        printMostPopular(wordAnalyser, 1);
        Long endTime = currentTimeMillis();
        System.out.println("Benchmark time: " + (endTime-startTime) + "mss.");

    }

    private void printHead(){
        System.out.printf("==%s==\n",content.getFileName());
    }

    private static void printEntireSize(StatisticalAnalysis analyser){
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

    private static void printDictSize(StatisticalAnalysis analyser){
        System.out.println("Dict size: " + analyser.dictionarySize());
    }

    private static void printMostPopular(StatisticalAnalysis analyser, int percentPoint){
        double percentageOfOccurrance = onePercent(analyser)*percentPoint;
        long occurance = Math.round(percentageOfOccurrance);
        int numberOfOccurrance = (int) occurance;
        Set<String> mostPopoular = analyser.occurMoreThan(numberOfOccurrance);
        System.out.printf("Most used words (>%d%%) :", percentPoint);
        System.out.println(mostPopoular);
    }

    private static double onePercent(StatisticalAnalysis analyser){ //double
        int hundredPerc = analyser.size();
        return hundredPerc/100.00;
    }

    
    /* moved to StartAnalyser
    public static void main(String[] args) throws FileNotFoundException {
        View test = new View("test.txt");
        test.printAllAnalysis();
    }
    */
}