package com.thatsnajmul.MySpringBootProject.service;

import com.thatsnajmul.MySpringBootProject.entity.Department;
import com.thatsnajmul.MySpringBootProject.entity.Faculty;
import com.thatsnajmul.MySpringBootProject.repository.DepartmentRepository;
import com.thatsnajmul.MySpringBootProject.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;


    @Autowired
    private DepartmentRepository departmentRepository;

    public void saveFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public void deleteFacultyById(Long id) {
        facultyRepository.deleteById(id);
    }

    public  Faculty findById(Long id) {
        return facultyRepository.findById(id).get();
    }

    public void updateFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }
}
