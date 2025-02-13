package read_user_input_from_console;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("src/main/java/read_user_input_from_console/user_data.txt")) {

            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(br.readLine());

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            fw.write("Name: " + name + "\nAge: " + age + "\nFavorite Language: " + language);
            System.out.println("Data saved successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
