package models;

public class Student{
    //Here we define what Student has
    private String id;
    private String name;
    private int age;
    // Then we need constructor to create a student
    public Student(String id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    // then here me move to Getter which allows to read access
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    //the setters allow write access with control

    public void setName(String name){
        if (name != null & !name.trim().isEmpty()){
            this.name = name;
        }
    }

    public void setAge(int age){
        if (age >= 16 && age <= 60){
            this.age = age;
        }
    }
    // behavior method (I man what student can do)
    public String getInfo(){
        return "Student: " + name + "(ID:" + id + ", Age:" + age +")";   
    }

}