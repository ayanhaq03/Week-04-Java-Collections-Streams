package reflection.intermediate_level_problems.dynamic_method_invocation;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Load the MathOperations class dynamically
            Class<?> mathClass = Class.forName("MathOperations");

            // Create an instance of MathOperations
            Object mathInstance = mathClass.getDeclaredConstructor().newInstance();

            // Get the method dynamically based on user input
            Method method = mathClass.getMethod(methodName, int.class, int.class);

            // Invoke the method dynamically
            int result = (int) method.invoke(mathInstance, num1, num2);
            System.out.println("Result: " + result);

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}