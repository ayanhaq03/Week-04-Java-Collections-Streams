package List_Interface.find_nth_element_from_end;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class findNthElement {
   //method to find nth element form the end
    public static char nthElement(LinkedList<Character> ls , int n){
         //using iterator to iterate over linked list
        Iterator<Character> slow = ls.iterator();
        Iterator<Character> fast = ls.iterator();

               //increasing the fast pointer first
                for(int i = 0 ; i < n ; i++){
                    fast.next();
                }
               //increasing both fast and slow pointer together
                while(fast.hasNext()){
                    fast.next();
                    slow.next();
                }

                return slow.next();
    }
    public static void main(String[] args) {

        LinkedList<Character> ls = new LinkedList<>(Arrays.asList('A','B','C','D','E'));
        System.out.println(nthElement(ls,2));
    }
}
