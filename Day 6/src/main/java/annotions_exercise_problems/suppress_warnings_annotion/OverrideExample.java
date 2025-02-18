package annotions_exercise_problems.suppress_warnings_annotion;

import java.util.ArrayList;

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

// Main class to test the deprecated method and suppress warnings
public class OverrideExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
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
    }
}