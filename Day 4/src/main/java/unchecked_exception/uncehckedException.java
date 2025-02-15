package unchecked_exception;


        import java.util.*;

public class uncehckedException {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Asking for input
        System.out.print("Enter two numbers : ");

        // Outer try checking if the input is not mismatched
        try {

            // Taking input from the user
            int num1 = input.nextInt();
            int num2 = input.nextInt();

            // Inner try checking if we are dividing the zero
            try {
                System.out.println("num1/num2 : " + (num1/num2));

            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Exception : Mismatched Input");
        }
        finally {
            System.out.println("-------------End-------------");
        }
    }
}