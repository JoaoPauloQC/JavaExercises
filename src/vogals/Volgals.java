package vogals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Volgals {


    private static List<Character> vogals = Arrays.asList('a','e','i','o','u');

    public static int checkingNum (String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++){
            System.out.println("here" + word.toLowerCase().toCharArray()[i]);

            if (vogals.contains(word.toLowerCase().toCharArray()[i])){
                count++;
            }
        }
        return count;
    }

}
