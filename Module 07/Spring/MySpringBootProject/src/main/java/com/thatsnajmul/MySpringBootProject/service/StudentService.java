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
    @Autowired
    private DepartmentRepository departmentRepository;


    //DATA INSERT
    @Autowired
    private DepartmentService departmentService;
    public void saveStudent(Student student) {

        Department department =departmentRepository.findById(student.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"
                        +student.getDepartment().getId()));
        student.setDepartment(department);
        studentRepository.save(student);
    }

    //DATA GET/SHOW
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //DATA DELETE
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    //DATA FIND BY ID
    public Student findStudentById(int id) {
        return studentRepository.findById(id).get();
    }


}
