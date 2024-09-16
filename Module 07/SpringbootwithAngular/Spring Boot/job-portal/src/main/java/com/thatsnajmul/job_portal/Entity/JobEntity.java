package com.thatsnajmul.job_portal.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private float jobMinSalary;
    private float jobMaxSalary;
    private String jobCategory;
    private Date jobDeadline;
    private String companyImage; // URL or file path
    private String jobDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "joblaoctionId")
    private Location joblocation;

    // Getters and Setters (Use Lombok's @Data annotation to avoid boilerplate code)


}
