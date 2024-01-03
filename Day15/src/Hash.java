import java.util.ArrayList;
import java.util.HashMap;

public class Hash {
    HashMap<String, String> ASCII;
    ArrayList<String> input;
    ArrayList<Integer> results;

    public Hash() throws Exception{
        this.ASCII = new HashMap<>();
        this.input = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    /**
     * Adds input into list.
     *
     * @param a String Input characters.
     */
    public void load(String a){
        input.clear();
        String[] seq = a.split("\\,");
        for(String c: seq){
            input.add(c);
        }
    }

    /**
     * Loads ASCII code into hashmap 'ASCII' from file '15ASCII'.
     *
     * @param a
     */
    public void loadASCII(String a){
        String[] ascii = a.split("\\s");
        ASCII.put(ascii[0], ascii[1]);
    }

    int curValue = 0;

    /**
     * Goes through list 'input' and sets apart each element
     * and makes them single characters in array 'character'.
     * Takes all characters and assures they match with some key
     * in HashMap 'ASCII'. As it spots match it takes the keys value.
     * Value gets handled as instructed(multiplied by 17, and remainder when divided by 256).
     * CurValues are stored in list 'results'.
     */
    public void getResults() throws Exception{
        results.clear();
        int temp = 0;
        for(String in: input){
            String[] character = in.split("");
            curValue = 0;
            temp = 0;
            for(int i = 0; i < character.length; i++) {
                    if (ASCII.containsKey(character[i])) {
                        curValue = Integer.parseInt(ASCII.get(character[i]));
                        curValue = curValue + temp;
                        curValue = curValue * 17;
                        curValue = curValue % 256;
                        temp = curValue;
                        if(i == (character.length - 1)){
                            results.add(curValue);
                        }
                    } else {
                        throw new Exception("Something went wrong");
                    }
                }
        }
    }

    /**
     * Sums all elements in ArrayList.
     *
     * @return int Sum of results.
     */
    public int sum(){
        int sum = 0;
        for(int res: results){
            sum += res;
        }
        return sum;
    }


    //Getters and setters
    public HashMap<String, String> getASCII() {
        return ASCII;
    }

    public void setASCII(HashMap<String, String> ASCII) {
        this.ASCII = ASCII;
    }

    public ArrayList<String> getInput() {
        return input;
    }

    public void setInput(ArrayList<String> input) {
        this.input = input;
    }

    public void setResults(ArrayList<Integer> results) {
        this.results = results;
    }
}
