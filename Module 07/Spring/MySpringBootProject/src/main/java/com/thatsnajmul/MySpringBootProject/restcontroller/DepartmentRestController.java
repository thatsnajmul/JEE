package com.thatsnajmul.MySpringBootProject.restcontroller;

import com.thatsnajmul.MySpringBootProject.entity.Department;
import com.thatsnajmul.MySpringBootProject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dep")
public class DepartmentRestController {

    @Autowired
    private DepartmentService depService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return depService.getAllDepartments();
    }

    //Save
    @PostMapping("/save")
    public void saveDepartment(@RequestBody Department department) {
        depService.saveDepartment(department);
    }

    //Get Data
    public DepartmentService getDepService() {
        return depService;
    }


    //Delete
    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable("id") Long id) {
        depService.deleteDepartment(id);
    }


    //Edit
    @PutMapping("/update")
    public void updateDepartment(@RequestBody Department department) {
        depService.updateDepartment(department);
    }
}
