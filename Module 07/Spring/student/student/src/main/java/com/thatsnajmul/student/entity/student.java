package com.thatsnajmul.student.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "email")
    private String email;

    // Getters and setters
    // Constructors

}
