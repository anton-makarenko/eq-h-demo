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

    @Autowired
    private BookRepository bookRepository;

    @AfterEach
    public void tearDown() {
//        studentRepository.deleteAll();
    }

    @Test
    public void shouldSaveAllRecords() {
        Student student1 = new Student();
        student1.setName("One");
//        student1.setBooks(initBooks());

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

    @Test
    public void shouldBeEquals() {
        Student student1 = new Student();
        student1.setName("One");

        Student student2 = new Student();
        student2.setName("Two");

        studentRepository.save(student1);
        studentRepository.save(student2);

        Book book1 = new Book();
        book1.setName("Book1");
        book1.setStudent(student1);
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setName("Book2");
        book2.setStudent(student2);
        bookRepository.save(book2);

        Book book3 = new Book();
        book3.setName("Book3");
        book3.setStudent(student1);
        bookRepository.save(book3);

        student1.setBooks(Set.of(book1, book3));
        student2.setBooks(Set.of(book2));

        List<Student> students = studentRepository.findByNameIn(Set.of("One", "Two"));
        assertEquals(List.of(student1, student2), students);
    }

    private Set<Book> initBooks() {
        Set<Book> books = new HashSet<>();
        Book book1 = new Book();
        book1.setName("Book1");

        Book book2 = new Book();
        book2.setName("Book2");
        books.add(book1);
        books.add(book2);
        return books;
    }
}
