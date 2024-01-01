import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Map map = new Map();
        Part2 part = new Part2();

        try {
            File file = new File("D:\\Nikolka_skola\\Programování\\Java\\AdventOfCode2023\\Inputs\\input8.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            // map.instructions.add(reader.readLine());
            part.instructions.add(reader.readLine());
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                // map.load(line);
                part.load(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // map.adjust();
        // System.out.println(map.steps());

        part.adjust();
        System.out.println(part.steppings());
    }
}