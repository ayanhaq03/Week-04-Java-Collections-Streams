package annotions_exercise_problems.task_info_annotion;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.ArrayList;

// Custom annotation definition
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Class representing a legacy API
class LegacyAPI {
    // Deprecated old method
    @Deprecated
    public void oldFeature() {
        System.out.println("This feature is deprecated and should not be used.");
    }

    // New recommended method
    public void newFeature() {
        System.out.println("This is the new and recommended feature.");
    }
}

// TaskManager class using the custom annotation
class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void completeTask() {
        System.out.println("Completing a high-priority task assigned to John Doe.");
    }
}

// Main class to test the annotation and deprecated method
public class OverrideExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        // Creating an instance of LegacyAPI
        LegacyAPI api = new LegacyAPI();

        // Calling the deprecated method (will show a warning)
        api.oldFeature();

        // Calling the new recommended method
        api.newFeature();

        // Creating an ArrayList without generics
        @SuppressWarnings("unchecked")
        ArrayList rawList = new ArrayList();
        rawList.add("Unchecked Warning Suppressed");

        System.out.println(rawList.get(0));

        // Retrieving and displaying TaskInfo annotation details
        Method method = TaskManager.class.getMethod("completeTask");
        TaskInfo annotation = method.getAnnotation(TaskInfo.class);

        if (annotation != null) {
            System.out.println("Task Priority: " + annotation.priority());
            System.out.println("Assigned To: " + annotation.assignedTo());
        }
    }
}