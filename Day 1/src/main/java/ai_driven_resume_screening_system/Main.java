package ai_driven_resume_screening_system;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist());

        seResume.process();
        dsResume.process();

        List<JobRole> jobRoles = Arrays.asList(new SoftwareEngineer(), new DataScientist());
        ResumeProcessor.processAllResumes(jobRoles);
    }
}
