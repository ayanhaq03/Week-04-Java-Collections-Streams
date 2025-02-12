package ai_driven_resume_screening_system;



// Specific job roles
class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    void processResume() {
        System.out.println("Processing resume for Software Engineer...");
    }
}