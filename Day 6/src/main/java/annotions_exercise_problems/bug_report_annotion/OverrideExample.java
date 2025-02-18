package annotions_exercise_problems.bug_report_annotion;

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
    @BugReport(description = "Null pointer exception occurs in edge cases.")
    @BugReport(description = "Performance issue when processing large data sets.")
    public void processTask() {
        System.out.println("Processing task with potential bugs reported.");
    }
}

// Main class to test the annotations
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

        // Retrieving and displaying BugReport annotation details
        Method method = TaskManager.class.getMethod("processTask");
        BugReports bugReports = method.getAnnotation(BugReports.class);

        if (bugReports != null) {
            for (BugReport bugReport : bugReports.value()) {
                System.out.println("Bug Report: " + bugReport.description());
            }
        }
    }
}