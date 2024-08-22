package com.thatsnajmul.MySpringBootProject.controller;

import com.thatsnajmul.MySpringBootProject.entity.Department;
import com.thatsnajmul.MySpringBootProject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepertmentRestController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

//    @PostMapping("/save")
//    public String saveDepartment(@RequestBody Department department) {
//        departmentService.saveDepartment(department);
//    }
//
//
//    @DeleteMapping
//    public String deleteDepartment(@PathVariable("id",Long){
//        departmentService.deleteDepartment(id);
//    }


}
