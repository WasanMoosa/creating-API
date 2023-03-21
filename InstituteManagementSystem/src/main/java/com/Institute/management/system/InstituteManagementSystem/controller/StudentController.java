package com.Institute.management.system.InstituteManagementSystem.controller;

import com.Institute.management.system.InstituteManagementSystem.model.Student;
import com.Institute.management.system.InstituteManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class StudentController {
    @Autowired
    private StudentService studentService;

    // To get all Student
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    // To get one student
    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable int id) {

        return studentService.getStudent(id);
    }

    // Add student to the list
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return student;
    }

    // Update existing student using his id
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return student;
    }

    // Delete existing student using his id
    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return studentService.deleteStudent(id);
    }
}
