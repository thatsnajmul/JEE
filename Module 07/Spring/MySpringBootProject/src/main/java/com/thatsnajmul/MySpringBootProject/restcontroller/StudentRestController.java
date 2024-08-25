package com.thatsnajmul.MySpringBootProject.restcontroller;


import com.thatsnajmul.MySpringBootProject.entity.Student;
import com.thatsnajmul.MySpringBootProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/api")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    //Get all Student from Database
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students=studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    //Post
    @PostMapping("/save")
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);

    }

    //Update
    @PutMapping("/update/")
    public void updateStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.findStudentById(id);
    }




}
