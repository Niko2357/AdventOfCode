
import java.util.ArrayList;
public class FirstPart {

    char[] word;
    ArrayList<Integer> digid1 = new ArrayList<>();
    ArrayList<Integer> digid2 = new ArrayList<>();
    ArrayList<Integer> numbers = new ArrayList<>();
    int w;
    int r;

    /**
     * Separates String into single characters.
     * Selects first digit it finds and adds it into list 'digit1'.
     *
     * @param a One line of input file.
     */
    public void checkFirstNumber(String a) {
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

    /**
     * Separates String into single characters.
     * Searches for a digit from the back of array and
     * adds it into list called 'digit2'.
     *
     * @param a One line of input file.
     */
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

    /**
     * Creates two-digit number that is added into list named 'numbers'.
     */
    public void makeNumber() {
        int k = 0;
        for (int i = 0; i < Math.min(digid1.size(), digid2.size()); i++) {
            k = digid1.get(i) * 10 + digid2.get(i);
            numbers.add(k);
        }
    }

    /**
     * Sums up all two-digit numbers in 'numbers' list.
     *
     * @return int Sum of numbers.
     */
    public int count(){
        int sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            sum += numbers.get(i);
        }
        return sum;
    }

    //Constructor
    public FirstPart() {
    }

    //Getters and Setters

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
