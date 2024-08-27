package com.thatsnajmul.MySpringBootProject.controller;

import com.thatsnajmul.MySpringBootProject.entity.Student;
import com.thatsnajmul.MySpringBootProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/savestudentform")
    public String saveStudent(Model m) {
        m.addAttribute("as", new Student());
        m.addAttribute("title", "Add New Student");
        return "savestudentform";
    }

    @PostMapping("/savestudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/showAllStudent";
    }

    @RequestMapping("/showAllStudent")
    public String showAllStudent(Model m) {
        List<Student> studentList = studentService.getAllStudents();
        m.addAttribute("studentList", studentList);
        m.addAttribute("title", "All Students");
        return "showallstudent";
    }

    @RequestMapping("deletestudent/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        return "redirect:/showAllStudent";
    }

    @RequestMapping("editstudent/{id}")
    public String editStudent(@PathVariable("id")Long id, Model m){
        Student s=studentService.findById(id);
        m.addAttribute("as", s);
        return "savestudentform";

    }
}
