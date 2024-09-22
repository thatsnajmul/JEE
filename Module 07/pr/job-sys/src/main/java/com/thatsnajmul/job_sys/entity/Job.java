package com.thatsnajmul.job_sys.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String companyName;
    private String jobType;
    private String location;
    private int experience;
    private double minSalary;
    private double maxSalary;
    private String category;
    private LocalDate deadline;
    private String companyImageUrl;
    private String jobDescription;
    private String cvDownloadUrl;

    // Getters and Setters
}

