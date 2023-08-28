package com.example.SimpleApplication.controller;

import com.example.SimpleApplication.entity.Student;
import com.example.SimpleApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public Student register(@RequestBody Student student) {
        Student registeredStudent = studentService.ragisterStudent(student);
        return registeredStudent;
    }

    @PutMapping("/update/{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(studentId, student);
        return updatedStudent;
    }

    @GetMapping("/get/{studentId}")
    public Student getStudent(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        return student;
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }

    @GetMapping("/get/all")
    public Student getAllStudent() {
        return null;
    }

}
