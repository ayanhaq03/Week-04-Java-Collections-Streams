package custom_exception;


import java.util.*;


// Custom Exception class
class InvalidAgeException extends Exception {


    // Constructor
    public InvalidAgeException() {
        // Throwing Exception message
        super("Age must be 18 or above");
    }
}


public class customException {


    // Method to Validate Age
    public static void validateAge(int age) throws InvalidAgeException{


        // Checking Age
        if(age < 18) {
            throw new InvalidAgeException();
        }


        else System.out.println("Access granted");
    }


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        // Taking age as input from the User
        System.out.print("Enter Age : ");
        int age = input.nextInt();


        // Calling method to check Age
        try {
            validateAge(age);
        }


        // Catching Exception
        catch (InvalidAgeException e) {
            System.out.println("InvalidAgeException : " + e.getMessage());
        }
    }
}
