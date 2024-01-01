import java.util.ArrayList;

public class Cards {

    ArrayList<String> winning;
    ArrayList<String> nums;
    ArrayList<Integer> sumOfPoints;


    public Cards() {
        this.winning = new ArrayList<>();
        this.nums = new ArrayList<>();
        sumOfPoints = new ArrayList<>();
    }

    /**
     * Splits card by non digit characters and adds
     * winning numbers into list of winning numbers
     * and other numbers adds into list of nums.
     * Numbers are String.
     *
     * @param a Line of numbers(card).
     */
    public void split(String a) {
        winning = new ArrayList<>();
        nums = new ArrayList<>();
        String[] parts = a.split("\\D+");
        for (int j = 1; j < 12; j++) {
                winning.add(parts[j]);
            }
        for (int p = 12; p < 36; p++) {
                nums.add(parts[p]);
            }
    }
    int matches = 0;

    /**
     * Searches for same number in 'nums' list as in the 'winning' list.
     *
     * @return int Quantity of matched numbers.
     */
    public int searchWinNum(){
        matches = 0;
        for(String i: winning){
            if(nums.contains(i)){
                matches++;
            }
        }
        return matches;
    }

    int points = 0;

    /**
     * Assigns points to number of matched numbers.
     *
     * @return int How many points is the card worth.
     */

    public int points(){
        switch(matches){
            case 0:
                points = 0;
                sumOfPoints.add(points);
                return points;
            case 1:
                points = 1;
                sumOfPoints.add(points);
                return points;
            case 2:
                points = 2;
                sumOfPoints.add(points);
                return points;
            case 3:
                points = 4;
                sumOfPoints.add(points);
                return points;
            case 4:
                points = 8;
                sumOfPoints.add(points);
                return points;
            case 5:
                points = 16;
                sumOfPoints.add(points);
                return points;
            case 6:
                points = 32;
                sumOfPoints.add(points);
                return points;
            case 7:
                points = 64;
                sumOfPoints.add(points);
                return points;
            case 8:
                points = 128;
                sumOfPoints.add(points);
                return points;
            case 9:
                points = 256;
                sumOfPoints.add(points);
                return points;
            case 10:
                points = 512;
                sumOfPoints.add(points);
                return points;
            default:
                return 0;
        }
    }

    /**
     * Adds up points of each card together.
     *
     * @return int Total points.
     */
    public long sum(){
        long sum = 0;
        for(int points: sumOfPoints){
            sum += points;
        }
        return sum;
    }


}
