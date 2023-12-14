
import java.util.ArrayList;

public class FirstPart {

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

    public FirstPart() {
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
