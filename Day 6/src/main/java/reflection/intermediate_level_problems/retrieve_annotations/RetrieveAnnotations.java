package reflection.intermediate_level_problems.retrieve_annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;

// Define a custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

// Apply the annotation to a class
@Author(name = "John Doe")
class SampleClass {
}

public class RetrieveAnnotations {
    public static void main(String[] args) {
        try {
            // Get the class
            Class<?> clazz = SampleClass.class;

            // Check if the annotation is present
            if (clazz.isAnnotationPresent(Author.class)) {
                // Retrieve the annotation
                Author authorAnnotation = clazz.getAnnotation(Author.class);
                System.out.println("Author: " + authorAnnotation.name());
            } else {
                System.out.println("No @Author annotation found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}