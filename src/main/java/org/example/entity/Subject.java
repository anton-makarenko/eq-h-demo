package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SUBJECTS")
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 50, unique = true)
    private String name;
}
