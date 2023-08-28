package com.example.SimpleApplication.service;

import com.example.SimpleApplication.entity.Student;

public interface StudentService {
    Student ragisterStudent(Student student);

    Student updateStudent(Long studentId, Student student);

    Student getStudentById(Long studentId);

    void deleteStudentById(Long studentId);
}
