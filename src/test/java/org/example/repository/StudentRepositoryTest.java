package org.example.repository;

import org.example.entity.Book;
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
        student1.setBooks(initBooks());

        Student student2 = new Student();
        student2.setName("Two");

        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);

        int size = studentRepository.saveAll(students).size();
        assertEquals(2, size);
    }

    @Test
    public void shouldSaveOneStudent() {

    }

    private Set<Book> initBooks() {
        Set<Book> books = new HashSet<>();
        Book book1 = new Book();
        book1.setName("Book1");

        Book book2 = new Book();
        book2.setName("book2");
        books.add(book1);
        books.add(book2);
        return books;
    }
}
