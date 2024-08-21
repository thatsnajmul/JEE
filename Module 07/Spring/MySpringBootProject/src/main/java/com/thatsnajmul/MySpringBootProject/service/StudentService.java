package com.thatsnajmul.MySpringBootProject.service;

import com.thatsnajmul.MySpringBootProject.entity.Student;
import com.thatsnajmul.MySpringBootProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    //DATA INSERT
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    //DATA GET/SHOW
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //DATA DELETE
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    //DATA FIND BY ID
    public Student findStudentById(int id) {
        return studentRepository.findById(id).get();
    }


}
