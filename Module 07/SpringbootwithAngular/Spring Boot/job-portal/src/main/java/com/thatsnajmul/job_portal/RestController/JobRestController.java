package com.thatsnajmul.job_portal.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thatsnajmul.job_portal.Entity.JobEntity;
import com.thatsnajmul.job_portal.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/job")
@CrossOrigin("*")
public class JobRestController {


    private JobService jobService;

    @PostMapping("save-job")
    public ResponseEntity<String> saveJob(
            @RequestPart(value = "job") String jobJson,
            @RequestPart(value = "image") MultipartFile file
    ) throws IOException {

        // Convert JSON string to Hotel object
        ObjectMapper objectMapper = new ObjectMapper();
        JobEntity jobEntity = objectMapper.readValue(jobJson, JobEntity.class);

        // Save the hotel and the image
        try {
            jobService.saveJob(jobEntity, file);
            return new ResponseEntity<>("Job added successfully with image.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add job: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("")
    public ResponseEntity<List<JobEntity>> getAllHotel() {
        List<JobEntity> jobs = jobService.getAllJob();
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("j/searchjob")
    public ResponseEntity<List<JobEntity>> findJobByLocationName(@RequestParam(value = "jobLocationName") String jobLocationName) {
        List<JobEntity> jobs = jobService.findByLocationName(jobLocationName);
        return ResponseEntity.ok(jobs);
    }


    @GetMapping("{id}")
    public ResponseEntity<JobEntity> findJobById(@PathVariable Long id) {
        try {
            JobEntity jobs = jobService.findJobById(id);
            return ResponseEntity.ok(jobs);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
