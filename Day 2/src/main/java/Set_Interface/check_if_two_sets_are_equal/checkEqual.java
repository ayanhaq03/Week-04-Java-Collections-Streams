package Set_Interface.check_if_two_sets_are_equal;

import java.util.Arrays;
import java.util.HashSet;

public class checkEqual {
  //method to check two set are equal or not
    public static boolean check(HashSet<Integer> st , HashSet<Integer> st2){

        boolean ans = true;
        //if size are different return false
        if(st.size()!=st2.size()) return false;
        else {
            for (int i : st) {
                if (!st2.contains(i)) {
                    ans = false;
                    return ans;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {

        HashSet<Integer> st = new HashSet<>(Arrays.asList(1,2,3));
        HashSet<Integer> st2 = new HashSet<>(Arrays.asList(3,2,1));

        System.out.println(  check(st,st2));
    }
}
