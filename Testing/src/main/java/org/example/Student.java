package org.example;

public class Student extends PERSON implements ComparableById {


   private int studentId;
   private String course;


    public Student(String name, int age, String address , int studentId, String course) {
        super(name , age , address);
        this.studentId=studentId;
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("org.example.Student ID must be a positive integer");
        }
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
         return studentId + ": " + course;
    }
    @Override
    public String getDetails() {
        return super.getDetails() + "\norg.example.Student ID: " + getStudentId() + "\nCourse: " + getCourse();
    }

    @Override
    public boolean compareById(int id) {
        return this.studentId == id;
    }
}
