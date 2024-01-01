import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        Logic log = new Logic();



        try{
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Nikolka_skola\\Programování\\Java\\AdventOfCode2023\\Inputs\\input9.txt "));
            String line;
            long totalSum = 0;
            while((line = reader.readLine()) != null){
                long lineSum = 0;
                log.spliting(line);
                log.firstdifference();
                log.deducting(log.firstdifference());
                lineSum = log.sumList();
                totalSum += lineSum;
            }
            System.out.println("Sum:" + totalSum);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}