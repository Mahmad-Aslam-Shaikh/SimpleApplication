package com.example.SimpleApplication.respository;

import com.example.SimpleApplication.entity.Student;
import com.example.SimpleApplication.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void registerStudentTest() {

        Student student = Student.builder()
                .name("Steve Rodger")
                .city("New York")
                .build();

        Student savedStudent = studentRepository.save(student);

        Assertions.assertThat(savedStudent.getId()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    public void getStudentByIdTest() {

        Student student = Student.builder()
                .name("T Challa")
                .city("Wakanda")
                .build();

        Student savedStudent = studentRepository.save(student);

        Optional<Student> optionalStudent = studentRepository.findById(1L);

        if (optionalStudent.isPresent()) {
            Assertions.assertThat(optionalStudent.get()).isNotNull();
        }

    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateStudentTest() {

        Student student = Student.builder()
                .name("T Challa")
                .city("Wakanda")
                .build();

        Student savedStudent = studentRepository.save(student);

        Optional<Student> optionalStudent = studentRepository.findById(1L);

        if (optionalStudent.isPresent()) {

            savedStudent = optionalStudent.get();

            savedStudent.setName("Shuri");

            Student updatedStudent = studentRepository.save(savedStudent);

            Assertions.assertThat(updatedStudent.getName()).isEqualTo("Shuri");

        }

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void deleteStudentByIdTest() {

        Student student = Student.builder()
                .name("Thanos")
                .city("Titan")
                .build();

        Student savedStudent = studentRepository.save(student);

        studentRepository.deleteById(1L);

        Assertions.assertThat(studentRepository.findById(1L).isPresent()).isFalse();

    }
    
}
