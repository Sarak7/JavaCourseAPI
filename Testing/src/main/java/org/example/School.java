package org.example;

import java.io.*;
import java.util.*;

public class School {
    private List<Student> students;

    public School() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int studentId) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId() == studentId) {
                iterator.remove();
                System.out.println("Student with ID " + studentId + " removed.");
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    // Method to display all students
    public void displayAllStudents() {
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student.getDetails());
            System.out.println("------------------------");
        }
    }

    public void sortStudentsByName() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
    }

    // Method to find a student by studentId using binary search
    public Student findStudentById(int studentId) {
        int low = 0;
        int high = students.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Student student = students.get(mid);
            if (student.getStudentId() == studentId) {
                return student;
            } else if (student.getStudentId() < studentId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    // Method to write students to a file
    public void writeStudentsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.write(student.getDetails());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read students from a file and populate the list
    public void readStudentsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String name = parts[0].split(": ")[1];
                int age = Integer.parseInt(parts[1].split(": ")[1]);
                String address = parts[2].split(": ")[1];
                int studentId = Integer.parseInt(parts[3].split(": ")[1]);
                String course = parts[4].split(": ")[1];
                students.add(new Student(name, age, address, studentId, course));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
