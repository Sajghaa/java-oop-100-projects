import models.Student;
import models.Course;
import services.SchoolService;

public class Main {
    public static void main(String[] args) {

        SchoolService school = new SchoolService();

        Student alice = new Student("S001", "Alice Johnson", 20);
        Student bob   = new Student("S002", "Bob Smith", 21);

        school.addStudent(alice);
        school.addStudent(bob);

        Course javaCourse = new Course("CS101", "Java Programming");
        Course mathCourse = new Course("MATH101", "Calculus");

        school.addCourse(javaCourse);
        school.addCourse(mathCourse);

        school.enrollStudentInCourse("S001", "CS101");
        school.enrollStudentInCourse("S002", "MATH101");

        school.displayAllStudents();
        school.displayAllCourses();

        Student found = school.findStudent("S001");
        if (found != null) {
            System.out.println(found.getInfo());
        }
    }
}