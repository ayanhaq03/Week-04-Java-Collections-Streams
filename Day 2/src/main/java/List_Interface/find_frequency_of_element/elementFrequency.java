package List_Interface.find_frequency_of_element;

import java.util.*;

public class elementFrequency {

    //method to find frequency of element in list
    public static HashMap<String,Integer> printFreq(ArrayList<String> ls){
        HashMap<String,Integer> mp = new HashMap<>();
        //storing frequency of elements in hashmap
        for(String s : ls){
            mp.put(s, mp.getOrDefault(s,0)+1);
        }

        return mp;
    }
    public static void main(String[] args) {

        ArrayList<String> ls = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange"));

        System.out.println(    printFreq(ls));

    }
}
