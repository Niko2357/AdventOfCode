import java.util.ArrayList;
import java.util.HashMap;
public class Map {
    HashMap<String, String[]> maps;
    ArrayList<String> instructions;

    //Constructor
    public Map(){
        this.maps = new HashMap<>();
        this.instructions = new ArrayList<>();
    }

    String cur = "AAA";
    int steps  = 0;

    /**
     * Goes through HashMap 'maps' according to instructions.
     * Changes current key of HashMap and counts steps every
     * time it reaches value of a HashMap.
     *
     * @return int Total steps.
     */
    public int steps(){
        while (!cur.equals("ZZZ")) {
            for(String c: instructions){
            if (c.equals("L")) {
                cur = maps.get(cur)[0];
                steps++;
            } else if (c.equals("R")) {
                cur = maps.get(cur)[1];
                steps++;
            }
        }
        }
        return steps;
    }

    /**
     * Adds needed letters into HashMap 'maps'.
     *
     * @param a One line of input file.
     */
    public void load(String a){
        String[] letters = a.split("\\W+");
        maps.put(letters[0], new String[]{letters[1], letters[2]});
    }

    /**
     * Changes one String instruction into individual
     * "L" or "R" instructions.
     */
    public void adjust(){
        steps = 0;
        char[] temp = instructions.get(0).toCharArray();
        instructions.clear();
        for(char c: temp){
            instructions.add(String.valueOf(c));
        }
    }


    //Getters and setters
    public HashMap<String, String[]> getMaps() {
        return maps;
    }

    public void setMaps(HashMap<String, String[]> maps) {
        this.maps = maps;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }
}
