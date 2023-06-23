package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SUBJECTS")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 50, unique = true)
    private String name;
}
