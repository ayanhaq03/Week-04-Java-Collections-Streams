package data_streams_store_and_retrieve_data;


import java.io.*;

public class dataStreamExample {
    public static void main(String[] args) {
        File file = new File("src/main/java/data_streams_store_and_retrieve_data/student_data.txt");

        // Write data
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read data
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            System.out.println("Roll No: " + dis.readInt());
            System.out.println("Name: " + dis.readUTF());
            System.out.println("GPA: " + dis.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
