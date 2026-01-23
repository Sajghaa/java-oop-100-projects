package models;

import java.util.ArrayList;
import java.util.List;

public class Course{
    // Then here we must define the identity of this class

    private String code;
    private String name;

    // composition : A course owns students
    private List<Student> students;

    //constructor or our valid birth
    public Course(String code, String name){
        this.code = code;
        this.name = name;
        this.students = new ArrayList<>();
    }
    //Behavior: enroll student
    public void enrollStudent(Student student){
        if (student !=null && !students.contains(student)){
            students.add(student);
        }
    }
    
    //behavior: remove student
    public void removeStudent(Student student){
        students.remove(student);
    }
    //Derived info
    public int getStudentCount(){
        return students.size();
    }

    //safe accessors

    public String getCode() { return code;}
    public String getName() {return name; }

    public List<Student> getStudents(){
        return new ArrayList<>(students);
    }
}