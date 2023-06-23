package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="STUDENTS")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name="NAME", length=50, nullable=false, unique = true)
    private String name;
}
