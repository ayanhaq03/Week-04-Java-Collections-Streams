package multi_level_university_course_management_system;

// Generic Course class
class Course<T extends CourseType> {
    T course;

    Course(T course) {
        this.course = course;
    }

    void showCourse() {
        course.displayCourse();
    }
}