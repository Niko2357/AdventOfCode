import java.util.*;
import java.util.Map;

public class Part2 {
    HashMap<String, String[]> maps2;
    ArrayList<String> instructions;
    int step2 = 0;

    // Constructor
    public Part2() {
        this.maps2 = new HashMap<>();
        this.instructions = new ArrayList<>();
    }

    /**
     * Doesnt work.
     *
     * @return int Total steps.
     */
    public int steppings() {
        ArrayList<String> allAs = new ArrayList<>();
        for (Map.Entry<String, String[]> cur : maps2.entrySet()) {
            if (cur.getKey().matches("[A-Z]{2}A")) {
                allAs.add(cur.getKey());
            }
        }
        for (String c : instructions) {
            String temp = "DRA";
            for (String startingNode : allAs) {
                String currentKey;
                currentKey = temp;
                if (currentKey.matches("[A-Z]{2}A")) {
                    String[] nextValue = maps2.get(currentKey);
                    if (c.equals("L")) {
                        step2++;
                        temp = nextValue[0];
                    } else if (c.equals("R")) {
                        step2++;
                        temp = nextValue[1];
                    }
                }
            }
        }
        return step2;
    }

    /**
     * Adds needed letters into HashMap 'maps'.
     *
     * @param a One line of input file.
     */
    public void load(String a) {
        String[] letters = a.split("\\W+");
        maps2.put(letters[0], new String[] { letters[1], letters[2] });
    }

    /**
     * Changes one String instruction into individual
     * "L" or "R" instructions.
     */
    public void adjust() {
        step2 = 0;
        char[] temp = instructions.get(0).toCharArray();
        instructions.clear();
        for (char c : temp) {
            instructions.add(String.valueOf(c));
        }
    }

    //Getters and setters
    public HashMap<String, String[]> getMaps2() {
        return maps2;
    }

    public void setMaps2(HashMap<String, String[]> maps2) {
        this.maps2 = maps2;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }
}
