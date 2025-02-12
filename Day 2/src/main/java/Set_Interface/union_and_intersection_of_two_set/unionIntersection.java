package Set_Interface.union_and_intersection_of_two_set;

import java.util.Arrays;
import java.util.HashSet;

public class unionIntersection {
    //method to find union of two set
    public static HashSet<Integer> Union(HashSet<Integer> st , HashSet<Integer> st2){
        HashSet<Integer> ans = new HashSet<>();
        //adding all element of set 1 and set 2 in resultant set
        ans.addAll(st);
        ans.addAll(st2);

        return ans;
    }
    //method to find intersection of two set
    public static HashSet<Integer> Intersection(HashSet<Integer> st , HashSet<Integer> st2){
       HashSet<Integer> ans = new HashSet<>();
       //adding all common elements of both set
        for(int i : st2){
            if(st.contains(i)){
                ans.add(i);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        HashSet<Integer> st = new HashSet<>(Arrays.asList(1,2,3));
        HashSet<Integer> st2 = new HashSet<>(Arrays.asList(3,4,5));

        System.out.println(" Intersection of two set is : "+ Intersection( st,st2));
        System.out.println(" Union of two set is  : "+Union(st,st2));

    }
}
