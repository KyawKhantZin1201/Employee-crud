package com.example.studentcrud.controller;

import com.example.studentcrud.entity.Student;
import com.example.studentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class studentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String studentForm(Model model){
        model.addAttribute("student",new Student());
        return "student-form";
    }

    @PostMapping("/save-student")
    public String saveStudent(@Valid Student student, BindingResult result){
        if(result.hasErrors()){
            return "student-form";
        }
        studentService.saveStudent(student);
        return "redirect:/list-students";
    }

    @GetMapping("/list-students")
    public String listStudents(Model model){
        model.addAttribute("students",studentService.findAllStudent());
        return "all-students";
    }



}
