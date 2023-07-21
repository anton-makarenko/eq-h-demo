package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="STUDENTS")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(name="NAME", length=50, nullable = false, unique = true)
    private String name;

    @EqualsAndHashCode.Exclude
    @Column(name = "CREATED", nullable = false, columnDefinition = "timestamp default current_timestamp(3)", insertable = false, updatable = false)
    private LocalDateTime created;

    @EqualsAndHashCode.Exclude
    @Column(name = "UPDATED", nullable = false, columnDefinition = "timestamp default current_timestamp(3)", insertable = false)
    private LocalDateTime updated;

//    @ToString.Exclude
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books;

//    @ManyToMany
//    private Set<Teacher> teachers;
}
