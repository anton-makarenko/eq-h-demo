package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
}
