package Set_Interface.find_subset;

import java.util.Arrays;
import java.util.HashSet;

public class findSubset {
     //method to check one set is subset of another or not
    public static boolean checkSubset(HashSet<Integer> st , HashSet<Integer> st2){
         boolean ans = true;

         //iterating over set 1 and checking if each element exists in set 2 or not
        for (int i : st) {
            if (!st2.contains(i)) {
                ans = false;
                return ans;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        HashSet<Integer> st = new HashSet<>(Arrays.asList(2,3));
        HashSet<Integer> st2 = new HashSet<>(Arrays.asList(1,2,3,4));

        System.out.println(checkSubset(st,st2));

    }

}
