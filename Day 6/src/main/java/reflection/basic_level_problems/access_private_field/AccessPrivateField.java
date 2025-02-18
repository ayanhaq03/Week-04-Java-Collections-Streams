package reflection.basic_level_problems.access_private_field;

import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person(25);

            // Get the private field 'age'
            Field ageField = Person.class.getDeclaredField("age");

            // Make the field accessible
            ageField.setAccessible(true);

            // Modify the private field value
            ageField.set(person, 30);

            // Retrieve the modified value
            System.out.println("Modified Age: " + ageField.get(person));

            // Display the modified age using the method
            person.displayAge();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}