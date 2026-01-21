package models;

import java.util.ArrayList;
import java.util.List;

public class Student {
   
    
    private String id;              // Unique identifier
    private String name;            // Student's full name
    private int age;                // Student's age
    private String email;           // Contact email
    private List<Course> enrolledCourses;  // Courses student is taking
    private List<Grade> grades;     // All grades received
    
    public Student(String id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }
    
    public void enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);  // Bidirectional relationship
            System.out.println(name + " enrolled in " + course.getCourseName());
        }
    }
    
    public void addGrade(Grade grade) {
        grades.add(grade);
    }
    
    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        
        double totalPoints = 0.0;
        for (Grade grade : grades) {
            totalPoints += grade.getGradePoints();
        }
        
        return totalPoints / grades.size();
    }
    
    public String generateReportCard() {
        StringBuilder report = new StringBuilder();
        
        report.append("=".repeat(50)).append("\n");
        report.append("REPORT CARD FOR: ").append(name.toUpperCase()).append("\n");
        report.append("=".repeat(50)).append("\n");
        report.append("ID: ").append(id).append("\n");
        report.append("Age: ").append(age).append("\n");
        report.append("Email: ").append(email).append("\n");
        report.append("-".repeat(50)).append("\n");
        
        report.append("COURSES ENROLLED:\n");
        for (Course course : enrolledCourses) {
            report.append("  - ").append(course.getCourseCode())
                  .append(": ").append(course.getCourseName())
                  .append(" (").append(course.getCredits()).append(" credits)\n");
        }
        
        report.append("-".repeat(50)).append("\n");
        report.append("GRADES:\n");
        for (Grade grade : grades) {
            report.append("  - ").append(grade.getCourse().getCourseName())
                  .append(": ").append(grade.getScore())
                  .append(" (").append(grade.getGradeLetter()).append(")\n");
        }
        
        report.append("-".repeat(50)).append("\n");
        report.append("OVERALL GPA: ").append(String.format("%.2f", calculateGPA())).append("\n");
        report.append("=".repeat(50));
        
        return report.toString();
    }
    
    // ========== GETTERS & SETTERS ==========
    // These provide CONTROLLED access to private fields
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age > 0 && age < 120) {  // Validation!
            this.age = age;
        }
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        // Basic email validation
        if (email != null && email.contains("@")) {
            this.email = email;
        }
    }
    
    public List<Course> getEnrolledCourses() {
        // Return a COPY to prevent external modification
        return new ArrayList<>(enrolledCourses);
    }
    
    public List<Grade> getGrades() {
        return new ArrayList<>(grades);
    }
    
    @Override
    public String toString() {
        return String.format("Student[ID: %s, Name: %s, Age: %d, GPA: %.2f]", 
                            id, name, age, calculateGPA());
    }
}