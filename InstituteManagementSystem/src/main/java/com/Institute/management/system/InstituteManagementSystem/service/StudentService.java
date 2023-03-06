package com.Institute.management.system.InstituteManagementSystem.service;

import com.Institute.management.system.InstituteManagementSystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class StudentService {
    private List<Student> allStudents = new CopyOnWriteArrayList<>();

    // Get all student
    public List<Student> getStudents() {
        return allStudents;
    }

    // Get specific student
    public Student getStudent(int id) {
        Optional<Student> foundStudent = allStudents.stream().filter(
                student -> {
                    return student.id == id;
                }).findFirst();
        return foundStudent.orElse(null);

    }

    // Add student
    int id = 1;

    public Student addStudent(Student student) {
        student.id = this.id++;
        allStudents.add(student);

        return student;
    }

    // update student
    public Student updateStudent(int id, Student updatedStudent) {
        Student student = getStudent(id);
        student.name = updatedStudent.name;
        student.email = updatedStudent.email;

        return updatedStudent;
    }

    // Delete student
    public Student deleteStudent(int id) {
        Student student = getStudent(id);
        allStudents.remove(student);

        return student;
    }
}
