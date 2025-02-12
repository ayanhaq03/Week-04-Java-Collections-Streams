package List_Interface.reverse_list;

import java.util.*;

public class ReverseList {

  //method to reverse arraylist
    public static void arrayListReverse(ArrayList <Integer> ls){


        int i = 0  ;
        int j = ls.size()-1;
       //swapping element at i with element at j
        while(i<=j){

             int temp = ls.get(i);
             ls.set(i,ls.get(j));
             ls.set(j,temp);
             i++;
             j--;

        }
    }

    //method to reverse linked list
    public static void LinkedListReverse(LinkedList<Integer> ls) {

        int i = 0;
        int j = ls.size() - 1;

        //swapping element at i with element at j
        while (i <= j) {
            int temp = ls.get(i);
            ls.set(i, ls.get(j));
            ls.set(j, temp);
            i++;
            j--;
        }
    }
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        arrayListReverse(list);
        System.out.println(list);

        LinkedList<Integer> ls = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        LinkedListReverse(ls);
        System.out.println(ls);


    }
}
