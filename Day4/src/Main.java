import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Cards card = new Cards();

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("D:\\Nikolka_skola\\Programování\\Java\\AdventOfCode2023\\Inputs\\input4.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                card.split(line);
                card.searchWinNum();
                card.points();
            }
            reader.close();
            System.out.println(card.sum());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}