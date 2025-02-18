package custom_annotions.beginner_level_problems.important_method_annotion;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.ArrayList;

// Custom annotation definition
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Container annotation for repeatable BugReport annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Custom annotation to mark important methods
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

// Class representing a legacy system
class LegacySystem {
    // Deprecated old method
    @Deprecated
    public void oldFeature() {
        System.out.println("This feature is deprecated and should not be used.");
    }

    // New recommended method
    @ImportantMethod(level = "MEDIUM")
    public void newFeature() {
        System.out.println("This is the new and recommended feature.");
    }
}

// TaskHandler class using the custom annotation
class TaskHandler {
    @BugReport(description = "Null pointer exception occurs in edge cases.")
    @BugReport(description = "Performance issue when processing large data sets.")
    public void processTask() {
        System.out.println("Processing task with potential bugs reported.");
    }

    @ImportantMethod
    public void executeCriticalTask() {
        System.out.println("Executing a high-priority critical task.");
    }
}

// Main class to test the annotations
public class AnnotationDemo {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        // Creating an instance of LegacySystem
        LegacySystem system = new LegacySystem();

        // Calling the deprecated method (will show a warning)
        system.oldFeature();

        // Calling the new recommended method
        system.newFeature();

        // Creating an ArrayList without generics
        @SuppressWarnings("unchecked")
        ArrayList rawList = new ArrayList();
        rawList.add("Unchecked Warning Suppressed");

        System.out.println(rawList.get(0));

        // Retrieving and displaying BugReport annotation details
        Method method = TaskHandler.class.getMethod("processTask");
        BugReports bugReports = method.getAnnotation(BugReports.class);

        if (bugReports != null) {
            for (BugReport bugReport : bugReports.value()) {
                System.out.println("Bug Report: " + bugReport.description());
            }
        }

        // Retrieving and displaying ImportantMethod annotation details
        for (Method m : TaskHandler.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod important = m.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + m.getName() + " | Level: " + important.level());
            }
        }
    }
}