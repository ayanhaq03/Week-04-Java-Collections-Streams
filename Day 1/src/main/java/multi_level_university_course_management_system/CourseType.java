package multi_level_university_course_management_system;

// Abstract class for different course types
abstract class CourseType {
    String courseName;

    CourseType(String courseName) {
        this.courseName = courseName;
    }

    abstract void displayCourse();
}
