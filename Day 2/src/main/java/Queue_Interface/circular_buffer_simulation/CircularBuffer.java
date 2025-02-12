package Queue_Interface.circular_buffer_simulation;


class CircularBuffer {
    private int[] buffer;
    private int size;
    private int front;
    private int rear;
    private int count;

    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    public void insert(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % size;

        if (count < size) {
            count++;
        } else {
            // Overwrite the oldest element
            front = (front + 1) % size;
        }
    }

    public void display() {
        System.out.print("Buffer: ");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.display(); // Output: Buffer: 1 2 3

        buffer.insert(4); // Overwrites 1
        buffer.display(); // Output: Buffer: 2 3 4

        buffer.insert(5); // Overwrites 2
        buffer.display(); // Output: Buffer: 3 4 5
    }
}
