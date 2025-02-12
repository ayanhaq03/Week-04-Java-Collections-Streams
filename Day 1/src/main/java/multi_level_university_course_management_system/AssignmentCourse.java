package multi_level_university_course_management_system;

class AssignmentCourse extends CourseType {
    AssignmentCourse(String courseName) {
        super(courseName);
    }

    @Override
    void displayCourse() {
        System.out.println("Assignment-based Course: " + courseName);
    }
}