import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Cube cube = new Cube();

        try{
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Nikolka_skola\\Programování\\Java\\AdventOfCode2023\\Inputs\\Day2_input.txt"));
            String line;
            while((line = reader.readLine()) != null);

        }catch (IOException e){
            e.printStackTrace();
        }

        cube.splitGame("Game 1: 12 blue; 2 green, 13 blue, 19 red; 13 red, 3 green, 14 blue");


    }
}