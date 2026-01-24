package services;

import models.Student;
import models.Course;
import java.util.HashMap;
import java.util.Map;

/**
 * SCHOOL SERVICE (DAY 3)
 * Manages students, courses, and enrollments
 */
public class SchoolService {

    // 2️⃣ Storage: in-memory maps for fast lookup
    private Map<String, Student> students;   // studentId → Student
    private Map<String, Course> courses;     // courseCode → Course

    // 3️⃣ Birth: initialize collections
    public SchoolService() {
        students = new HashMap<>();
        courses = new HashMap<>();
    }

    // 4️⃣ Student operations
    public void addStudent(Student student) {
        students.put(student.getId(), student);
        System.out.println("✅ Student added: " + student.getName());
    }

    public Student findStudent(String studentId) {
        return students.get(studentId);
    }

    public void removeStudent(String studentId) {
        Student removed = students.remove(studentId);
        if (removed != null) {
            System.out.println("✅ Student removed: " + removed.getName());
        }
    }

    // 4️⃣ Course operations
    public void addCourse(Course course) {
        courses.put(course.getCode(), course);
        System.out.println("✅ Course added: " + course.getName());
    }

    // 5️⃣ Coordination: enroll student in course
    public void enrollStudentInCourse(String studentId, String courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (student == null) {
            System.out.println("❌ Student not found: " + studentId);
            return;
        }

        if (course == null) {
            System.out.println("❌ Course not found: " + courseCode);
            return;
        }

        course.enrollStudent(student);
    }

    // 5️⃣ Display operations (system-wide views)
    public void displayAllStudents() {
        System.out.println("\n=== ALL STUDENTS ===");
        if (students.isEmpty()) {
            System.out.println("No students in system.");
            return;
        }
        for (Student s : students.values()) {
            System.out.println(s.getInfo());
        }
    }

    public void displayAllCourses() {
        System.out.println("\n=== ALL COURSES ===");
        for (Course c : courses.values()) {
            c.displayInfo();
            System.out.println();
        }
    }
}