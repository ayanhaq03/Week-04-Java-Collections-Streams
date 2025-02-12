package Set_Interface.convert_set_to_sorted_set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class setToSortedSet {

    //method to sort a set in ascending order
    public static ArrayList<Integer> toSortedSet(HashSet<Integer> st){
        //adding element to treeSet for sorting
        TreeSet<Integer> ts = new TreeSet<>();
        ts.addAll(st);
        //adding element in list
        ArrayList<Integer> ans = new ArrayList<>();
        ans.addAll(ts);
        return ans;
    }
    public static void main(String[] args) {
        HashSet<Integer> st = new HashSet<>(Arrays.asList(5,3,9,1));
        System.out.println(toSortedSet(st));
    }
}
