
import java.util.ArrayList;

public class Logic {

    ArrayList<Integer> numbers;

    ArrayList<Integer> firstDifference;
    ArrayList<Integer> lastNums;
    public Logic() {
        this.numbers = new ArrayList<>();
        this.firstDifference = new ArrayList<>();
        this.lastNums = new ArrayList<>();
    }

    /**
     * Method splits String by whitespace and
     * loads it into new ArrayList called
     * numbers as int. Also adds last number of
     * final return ArrayList in another list for
     * further use.
     *
     * @param a String One line in a file.
     * @return ArrayList<Integer> numbers
     */
    public ArrayList<Integer> spliting(String a) {
        numbers.clear();
        for(String c: a.split("\\s+")){
            int num = Integer.parseInt(c);
            numbers.add(num);
        }
        lastNums.add(numbers.get(numbers.size() - 1));
        return numbers;
    }

    /**
     * Subtracts elements(numbers) next to each other
     * and adds them into new ArrayList. Adds last number of
     * final return ArrayList in another list for
     * further use.
     *
     * @return ArrayList<Integer> Results of subtraction in ArrayList.
     */
    public ArrayList<Integer> firstdifference(){
        for(int i = 0; i < numbers.size() -1 ; i++){
            int difference = numbers.get(i + 1) - numbers.get(i);
            firstDifference.add(Math.abs(difference));
        }
        lastNums.add(firstDifference.get(firstDifference.size() - 1));
        return firstDifference;
    }

    /**
     * Methods checks if all numbers in ArrayList are zero.
     *
     * @param nums Input ArrayList to check truthfulness.
     * @return boolean Whether list is full of zeros returns true or returns false if not.
     */
    public boolean areZeros(ArrayList<Integer> nums){
        for(int lop: nums){
            if(lop != 0){
                return false;
            }
        }
        return true;
    }



    /**
     * The method deducting subtracts elements(numbers)
     * next to each other and loads them into the same
     * arraylist. Uses recursion. Adds last number of
     * final return ArrayList in another list for further use.
     *
     * @param list (ArrayList<Integer>) from which we want to get differences between elements
     * @return ArrayList<Integer> List of all zeros.
     */
     public ArrayList<Integer> deducting(ArrayList<Integer> list) {
        if(list.isEmpty() || areZeros(list)){
            return list;
        }else {
            ArrayList<Integer> temp = new ArrayList<>();
            lastNums.add(list.size() - 1);
            for (int i = 0; i < list.size() - 1; i++) {
                if(i < list.size() - 1){
                int difference = list.get(i + 1) - list.get(i);
                temp.add(Math.abs(difference));
                }
            }
            list.clear();
            list.addAll(temp);
            if(list.size() > 0) {
                this.lastNums.add(list.get(list.size() - 1));
            }
            deducting(list);
        }
        return list;
    }


    /**
     * Adds up all elements in ArrayList.
     *
     * @return int Sum of all elements in ArrayList.
     */
    public int sumList(){
        ArrayList<Integer> sumed = new ArrayList<>(lastNums);
        if(sumed.size() >= 3) {
            sumed.remove(2);
        }
        lastNums.clear();
        int sum = 0;
        for(int i = 0; i < sumed.size(); i++){
            sum += sumed.get(i);
        }
        return sum;
    }



    //Getters and setters
    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<Integer> getFirstDifference() {
        return firstDifference;
    }

    public void setFirstDifference(ArrayList<Integer> firstDifference) {
        this.firstDifference = firstDifference;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public ArrayList<Integer> getLastNums() {
        return lastNums;
    }

    public void setLastNums(ArrayList<Integer> lastNums) {
        this.lastNums = lastNums;
    }
}
