package multiple_catch_blocks;

import java.util.*;


public class multipleCatchBlockExample {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        // Taking array as input from the User
        System.out.print("Enter the size of the Array : ");
        int n = input.nextInt();


        // Creating an Array of size 'n'
        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + i + "th element of the Array : ");
            arr[i] = input.nextInt();
        }


        // Taking index as input
        System.out.print("Enter the index : ");
        int index = input.nextInt();


        try {
            System.out.println("Value at index : " + index + " : " + arr[index]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
        catch (NullPointerException e) {
            System.out.println("Array is not initialized");
        }
    }
}

