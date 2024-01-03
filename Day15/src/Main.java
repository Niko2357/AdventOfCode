import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception{

        Hash hash = new Hash();

        try{
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Nikolka_skola\\Programování\\Java\\AdventOfCode2023\\Inputs\\input15.txt"));
            BufferedReader reader1 = new BufferedReader(new FileReader("D:\\Nikolka_skola\\Programování\\Java\\AdventOfCode2023\\Inputs\\15ASCII.txt"));
            String line;
            while((line = reader.readLine()) != null){
                hash.load(line);
            }
            while((line = reader1.readLine()) != null){
                hash.loadASCII(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        hash.getResults();
        System.out.println("Sum:" + hash.sum());

    }
}