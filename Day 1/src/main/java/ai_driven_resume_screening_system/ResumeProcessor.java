package ai_driven_resume_screening_system;
import java.util.*;

// Wildcard method to process multiple job roles
class ResumeProcessor {
    static void processAllResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            resume.processResume();
        }
    }
}