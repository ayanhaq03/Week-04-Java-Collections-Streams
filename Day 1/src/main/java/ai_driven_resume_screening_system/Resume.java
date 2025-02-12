package ai_driven_resume_screening_system;

// Generic Resume class
class Resume<T extends JobRole> {
    T jobRole;

    Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    void process() {
        jobRole.processResume();
    }
}
