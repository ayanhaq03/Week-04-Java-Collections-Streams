package Queue_Interface.reverse_a_queue;


import java.util.*;

import java.util.*;

class queueReverse {
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        // Remove the front element
        int front = queue.remove();

        // Recursively reverse the remaining queue
        reverseQueue(queue);

        // Add the removed element back at the rear
        queue.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));

        System.out.println("Original Queue: " + queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}



