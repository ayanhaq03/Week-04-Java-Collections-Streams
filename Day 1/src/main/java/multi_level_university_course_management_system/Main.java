package multi_level_university_course_management_system;

public class Main {

    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>(new ExamCourse("Mathematics"));
        Course<AssignmentCourse> history = new Course<>(new AssignmentCourse("History"));

        math.showCourse();
        history.showCourse();
    }

}
