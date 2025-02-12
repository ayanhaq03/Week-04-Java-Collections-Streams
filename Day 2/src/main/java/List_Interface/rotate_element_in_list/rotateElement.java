package List_Interface.rotate_element_in_list;

import java.util.ArrayList;
import java.util.Arrays;

public class rotateElement {
     //method to reverse list in particular range
    public static void reverse(ArrayList<Integer> ls , int i,int j){
        while(i<=j){
            int temp = ls.get(i);
            ls.set(i,ls.get(j));
            ls.set(j,temp);
            i++;
            j--;
        }
    }
    public static void rotate(ArrayList<Integer> ls , int idx){
        //reversing first half 0 to idx-1
        reverse(ls,0,idx-1);
        //reversing second half idx to size -1
        reverse(ls,idx,ls.size()-1);
        //reversing whole list
        reverse(ls,0,ls.size()-1);



    }
    public static void main(String[] args) {

        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(10,20,30,40,50));
        rotate(ls,2);
        System.out.println(ls);

    }
}
