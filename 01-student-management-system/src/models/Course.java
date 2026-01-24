package models;

import java.util.ArrayList;
import java.util.List;

public class Course {
    // Identity of this class
    private String code;
    private String name;

    // Composition: A course owns students
    private List<Student> students;

    // Constructor - our valid birth
    public Course(String code, String name) {
        this.code = code;
        this.name = name;
        this.students = new ArrayList<>();
    }

    // Behavior: enroll student
    public void enrollStudent(Student student) {
        if (student != null && !students.contains(student)) {
            students.add(student);
        }
    }
    
    // Behavior: remove student
    public void removeStudent(Student student) {
        students.remove(student);
    }
    
    // Derived info
    public int getStudentCount() {
        return students.size();
    }

    // ADD THIS METHOD TO FIX THE ERROR
    public void displayInfo() {
        System.out.println("   Course: " + name + " (" + code + ")");
        System.out.println("   Students enrolled: " + getStudentCount());
    }

    // Safe accessors (getters)
    public String getCode() { 
        return code;
    }
    
    public String getName() { 
        return name; 
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students); // Return copy for safety
    }
}