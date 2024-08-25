package com.thatsnajmul.MySpringBootProject.service;

import com.thatsnajmul.MySpringBootProject.entity.Department;
import com.thatsnajmul.MySpringBootProject.entity.Faculty;
import com.thatsnajmul.MySpringBootProject.repository.DepartmentRepository;
import com.thatsnajmul.MySpringBootProject.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    //For Save
    @Autowired
    private FacultyRepository facultyRepository;
    public void saveDepartment(Department department) {
        Faculty faculty = facultyRepository.findById(department.getFaculty().getId())
                .orElseThrow(
                        () -> new RuntimeException("User Not Found has ID"+department.getFaculty().getId())
                );
        department.setFaculty(faculty);
        departmentRepository.save(department);
    }


    //For View
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    //For Delete
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }


    //For
    public Department findDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }

    //For Update
    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }

}
