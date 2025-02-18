package reflection.basic_level_problems.invoke_private_method;

import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) {
        try {
            // Create an instance of Calculator
            Calculator calculator = new Calculator();

            // Get the private method 'multiply'
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

            // Make the method accessible
            multiplyMethod.setAccessible(true);

            // Invoke the private method with arguments
            int result = (int) multiplyMethod.invoke(calculator, 5, 10);

            // Print the result
            System.out.println("Result of multiplication: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}