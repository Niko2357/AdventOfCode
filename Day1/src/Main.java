import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {

        FirstPart ch = new FirstPart();

        try{
            File file = new File("D:\\Nikolka_skola\\Programování\\Java\\AdventOfCode2023\\Day1_input");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                ch.checkFirstNumber(line);
            }
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                ch.checkLastNumber(line);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        //First part
        ch.makeNumber();
        System.out.println(ch.count());

        //Second part
        SecondPart s = new SecondPart();
        s.addedHash();
        BufferedReader reade = new BufferedReader(new FileReader("D:\\Nikolka_skola\\Programování\\Java\\AdventOfCode2023\\Day1_input"));
        BufferedWriter writ = new BufferedWriter(new FileWriter("D:\\Nikolka_skola\\Programování\\Java\\AdventOfCode2023\\MyInput"));
        String lin;
        while ((lin = reade.readLine()) != null) {
            s.convert(lin);
            writ.write(lin);
        }

        try{
            File fil = new File("D:\\Nikolka_skola\\Programování\\Java\\AdventOfCode2023\\MyInput");
            s.writeFile(fil);
            BufferedReader reader = new BufferedReader(new FileReader(fil));
            String line;

            while((line = reader.readLine()) != null) {
                  s.convert(line);
            }
            reader = new BufferedReader(new FileReader(fil));
            while((line = reader.readLine()) != null){
                s.checkFirstNumber(line);
            }
            reader = new BufferedReader(new FileReader(fil));
            while((line = reader.readLine()) != null){
                s.checkLastNumber(line);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        s.makeNumber();
        System.out.println(s.count());




    }


}
