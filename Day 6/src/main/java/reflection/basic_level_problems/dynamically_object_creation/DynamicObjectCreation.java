package reflection.basic_level_problems.dynamically_object_creation;

import java.lang.reflect.Constructor;

class Student {
    private String name;

    // Default constructor
    public Student() {
        this.name = "Default Student";
    }

    // Parameterized constructor
    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            // Load the Student class dynamically
            Class<?> studentClass = Class.forName("Student");

            // Get the no-argument constructor
            Constructor<?> constructor = studentClass.getConstructor();

            // Create a new instance dynamically without using 'new' keyword
            Object studentInstance = constructor.newInstance();

            // Invoke the display method
            studentClass.getMethod("display").invoke(studentInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}