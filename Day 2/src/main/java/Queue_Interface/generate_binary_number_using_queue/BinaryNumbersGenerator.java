package Queue_Interface.generate_binary_number_using_queue;
import java.util.*;

class BinaryNumbersGenerator {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < N; i++) {
            String current = queue.poll();
            result.add(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateBinaryNumbers(5));
    }
}
