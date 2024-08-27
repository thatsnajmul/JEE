package com.thatsnajmul.MySpringBootProject.service;

import com.thatsnajmul.MySpringBootProject.entity.Department;
import com.thatsnajmul.MySpringBootProject.entity.Student;
import com.thatsnajmul.MySpringBootProject.repository.DepartmentRepository;
import com.thatsnajmul.MySpringBootProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public void saveStudent(Student student) {

        studentRepository.save(student);
    }

    //DATA GET/SHOW
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //DATA DELETE
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    //DATA FIND BY ID
    public Student findStudentById(Long id) {
        return studentRepository.findById().get();
    }

    public void updateStudent(Student student, Long id) {
        studentRepository.save(student);
    }

}
