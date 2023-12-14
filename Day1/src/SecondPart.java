
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SecondPart extends FirstPart {
    ArrayList<String> expression = new ArrayList<>();

    Map<String, String> num = new HashMap<>();

    public SecondPart() {
    }

    public void writeFile(File a)throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(a));
            for(int i = 0; i < expression.size(); i++){
                writer.write(expression.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addedHash(){
        num.put("one", "o1e");
        num.put("two", "t2o");
        num.put("three", "t3e");
        num.put("four", "f4r");
        num.put("five", "f5e");
        num.put("six", "s6");
        num.put("seven", "s7n");
        num.put("eight", "e8t");
        num.put("nine", "n9e");
    }

    public String convert(String a){
        for(String word: num.keySet()){
            a = a.replace(word, num.get(word));
        }
        expression.add(a);
        return a;
    }



    //+Part 1
    char[] word;
    ArrayList<Integer> digid1 = new ArrayList<>();
    ArrayList<Integer> digid2 = new ArrayList<>();
    ArrayList<Integer> numbers = new ArrayList<>();
    int w;
    int r;

    public void checkFirstNumber(String a) throws Exception{
        char[] word = a.toCharArray();
        boolean num = false;
        for(int u = 0; u < word.length; u++){
            if(Character.isDigit(word[u])){
                w = Character.getNumericValue(word[u]);
                digid1.add(w);
                num = true;
                break;
            }else{
                num = false;
            }
        }
    }

    public void checkLastNumber(String a) {
        char[] word = a.toCharArray();
        boolean num = false;
        for(int u = word.length -1; u >= 0; u--){
            if(Character.isDigit(word[u])){
                r = Character.getNumericValue(word[u]);
                digid2.add(r);
                num = true;
                break;
            }else{
                num = false;
            }
        }
    }



    public void makeNumber() {
        int k = 0;
        for (int i = 0; i < Math.min(digid1.size(), digid2.size()); i++) {
            k = digid1.get(i) * 10 + digid2.get(i);
            numbers.add(k);
        }
    }


    public Integer count(){
        int sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            sum += numbers.get(i);
        }
        return sum;
    }


    public ArrayList<String> getExpression() {
        return expression;
    }

    public void setExpression(ArrayList<String> expression) {
        this.expression = expression;
    }

    public Map<String, String> getNum() {
        return num;
    }

    public void setNum(HashMap<String, String> num) {
        this.num = num;
    }

    public ArrayList<Integer> getDigid1() {
        return digid1;
    }

    public void setDigid1(ArrayList<Integer> digid1) {
        this.digid1 = digid1;
    }

    public ArrayList<Integer> getDigid2() {
        return digid2;
    }

    public void setDigid2(ArrayList<Integer> digid2) {
        this.digid2 = digid2;
    }

    public char[] getWord() {
        return word;
    }

    public void setWord(char[] word) {
        this.word = word;
    }


    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

}
