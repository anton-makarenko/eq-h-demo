package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="STUDENTS")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @EqualsAndHashCode.Exclude
    @Column(name="NAME", length=50, nullable = false, unique = true)
    private String name;

    @Column(name = "CREATED", nullable = false, columnDefinition = "timestamp default current_timestamp(3)", insertable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "UPDATED", nullable = false, columnDefinition = "timestamp default current_timestamp(3)", insertable = false)
    private LocalDateTime updated;

    @OneToMany(mappedBy = "student")
    private Set<Book> books = Set.of();

    @ManyToMany
    private Set<Teacher> teachers;
}
