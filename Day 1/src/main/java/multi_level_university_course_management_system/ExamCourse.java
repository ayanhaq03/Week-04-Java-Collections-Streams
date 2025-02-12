package multi_level_university_course_management_system;

// Subclasses for different evaluation types
class ExamCourse extends CourseType {
    ExamCourse(String courseName) {
        super(courseName);
    }

    @Override
    void displayCourse() {
        System.out.println("Exam-based Course: " + courseName);
    }
}

