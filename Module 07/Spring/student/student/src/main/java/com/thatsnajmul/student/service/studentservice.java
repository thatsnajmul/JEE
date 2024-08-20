package com.thatsnajmul.student.service;
import org.springframework.stereotype.Service;
import com.thatsnajmul.student.entity.student;
import com.thatsnajmul.student.repository.StudentRepository;


import java.util.List;

@Service
public class studentservice {

    private final StudentRepository studentRepository;

    public studentservice(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(student student) {
        studentRepository.save(student);
    }

    public student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

}
