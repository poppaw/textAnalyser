import java.io.FileNotFoundException;


public class StartAnalyser{


    public static void main(String[] args) {

        String fileName1 = args[0];
        try{
            View program = new View(fileName1);
            program.printAllAnalysis();
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }

        String fileName2 = args[1];
            try{
                View program = new View(fileName1);
                program.printAllAnalysis();
            }
            catch (FileNotFoundException e) {
                System.out.println(e);
            }
    }
}