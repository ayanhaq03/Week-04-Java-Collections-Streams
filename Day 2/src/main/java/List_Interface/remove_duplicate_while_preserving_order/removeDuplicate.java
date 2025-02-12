package List_Interface.remove_duplicate_while_preserving_order;

import java.util.*;

public class removeDuplicate {

    public static HashSet<Integer> removeDuplicate(ArrayList<Integer> ls){
        //adding all element in linkedhashset to preserve order
        LinkedHashSet<Integer> st = new LinkedHashSet<>();
        for(int i : ls){
            st.add(i);
        }
        return st;
    }
    public static void main(String[] args) {

        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(3,1,2,2,3,4));


        System.out.println(    removeDuplicate(ls));
    }
}
