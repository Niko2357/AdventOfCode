import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Cube {

    private int red = 12;
    private int green = 13;
    private int blue = 14;

    int possibleGames = 0;

    String[] cubes;
    String game;
    public void splitGame(String a){
        cubes = a.split(":");
        int index = 0;
        game = cubes[0];
        String[] helpArr = new String[cubes.length -1];
        System.arraycopy(cubes, 0, helpArr, 0, 0);
        System.arraycopy(cubes, 0 +1, helpArr, 0, helpArr.length - 0);
        for(int i = 0; i < cubes.length; i++){

        }
        System.out.println(Arrays.toString(cubes));
        System.out.println(Arrays.toString(helpArr));
        System.out.println(game);
    }

    public void addingToMap(){

    }

}
