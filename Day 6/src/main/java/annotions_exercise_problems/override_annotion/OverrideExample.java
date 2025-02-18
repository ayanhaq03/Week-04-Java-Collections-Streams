package annotions_exercise_problems.override_annotion;

// Parent class Animal
class Animal {
    // Method to be overridden
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Child class Dog that extends Animal
class Dog extends Animal {
    // Overriding makeSound() method
    @Override
    public void makeSound() {
        System.out.println("Bark! Bark!");
    }
}

// Main class to test the method overriding
public class OverrideExample {
    public static void main(String[] args) {
        // Creating an instance of Dog
        Dog myDog = new Dog();

        // Calling the overridden method
        myDog.makeSound(); // This will call the Dog's makeSound method
    }
}