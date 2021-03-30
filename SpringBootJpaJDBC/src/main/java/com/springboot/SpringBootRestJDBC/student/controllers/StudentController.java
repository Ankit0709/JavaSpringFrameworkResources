package com.springboot.SpringBootRestJDBC.student.controllers;

import com.springboot.SpringBootRestJDBC.student.modals.Student;
import com.springboot.SpringBootRestJDBC.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getAllStudents")
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/getStudentById/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Integer id){
        Optional<Student> student = studentService.getStudentById(id);
        return student;
    }
    @PostMapping(value = "/addStudent", consumes = "application/json")
    public String addStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @DeleteMapping(value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Integer id){
        return  studentService.removeStudent(id);
    }
    @PutMapping(value = "/updateStudent/{id}")
    public String updateStudent(@PathVariable("id") Integer id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }
}
