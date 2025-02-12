package ai_driven_resume_screening_system;


class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist");
    }

    @Override
    void processResume() {
        System.out.println("Processing resume for Data Scientist...");
    }
}