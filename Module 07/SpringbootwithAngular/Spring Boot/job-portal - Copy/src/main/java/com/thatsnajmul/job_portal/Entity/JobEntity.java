package com.thatsnajmul.job_portal.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "jobs")
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobTitle;
    private String companyName;
    private String jobType;
    private String jobLocation;
    private String jobExperience;
    private String jobMinSalary;
    private String jobMaxSalary;
    private String jobCategory;
    private String jobDeadline;
    private String companyImage; // URL or file path
    private String jobDescription;



    // Getters and Setters (Use Lombok's @Data annotation to avoid boilerplate code)

}
