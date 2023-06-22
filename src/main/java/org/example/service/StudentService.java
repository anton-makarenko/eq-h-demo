package org.example.service;

import lombok.Data;
import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class StudentService {
    private final StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> saveAll(List<Student> students) {
        return studentRepository.saveAll(students);
    }
}
