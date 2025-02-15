package exception_propogation_method;

public class ExceptionPropagationExample {

    public static void method1(int p, int q) throws ArithmeticException {

        // Checking for Exception
        try {
            System.out.println("p/q : " + p/q);
        }
        catch (ArithmeticException e) {
            throw new ArithmeticException();
        }
    }

    public static void method2(int p, int q) throws ArithmeticException {

        // Calling method1
        try {
            method1(p, q);
        }
        catch (ArithmeticException e) {
            throw new ArithmeticException();
        }
    }

    public static void main(String[] args) {

        // Try block
        try {
            method2(10,0);
        }
        catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
