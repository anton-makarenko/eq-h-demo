package org.example.controller;

import lombok.Data;
import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
@Data
public class StudentController {
    private final StudentService studentService;

    @PutMapping("/saveall")
    public ResponseEntity<List<Student>> saveAll(@RequestBody List<Student> students) {
        return ResponseEntity.ok(studentService.saveAll(students));
    }
}
