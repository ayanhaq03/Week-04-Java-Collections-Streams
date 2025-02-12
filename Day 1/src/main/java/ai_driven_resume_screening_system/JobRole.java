package ai_driven_resume_screening_system;

// Abstract class for job roles
abstract class JobRole {
    String roleName;

    JobRole(String roleName) {
        this.roleName = roleName;
    }

    abstract void processResume();
}