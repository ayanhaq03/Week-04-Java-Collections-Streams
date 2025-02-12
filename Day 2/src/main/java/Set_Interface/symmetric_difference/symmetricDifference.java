package Set_Interface.symmetric_difference;

import java.util.Arrays;
import java.util.HashSet;

public class symmetricDifference {

    public static HashSet<Integer> SymmetricDiff(HashSet<Integer> st , HashSet<Integer> st2){

        HashSet<Integer> ans = new HashSet<>();
        //adding all element of set 1 which is not present is set 2
        for(int i : st2){
            if(!st.contains(i)){
                ans.add(i);
            }
        }
        //adding all element of set 2 which is not present is set 1

        for(int i : st){
            if(!st2.contains(i)){
                ans.add(i);
            }
        }

        return ans;
    }
    public static void main(String[] args) {

        HashSet<Integer> st = new HashSet<>(Arrays.asList(1,2,3));
        HashSet<Integer> st2 = new HashSet<>(Arrays.asList(3,4,5));

        System.out.println(SymmetricDiff(st,st2));
    }
}
