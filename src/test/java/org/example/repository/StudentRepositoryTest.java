package org.example.repository;

import org.example.entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @AfterEach
    public void tearDown() {
        studentRepository.deleteAll();
    }

    @Test
    public void shouldSaveAllRecords() {
        Student student1 = new Student();
        student1.setName("One");

        Student student2 = new Student();
        student2.setName("One");

        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);

        int size = studentRepository.saveAll(students).size();
        assertEquals(2, size);
    }
}
