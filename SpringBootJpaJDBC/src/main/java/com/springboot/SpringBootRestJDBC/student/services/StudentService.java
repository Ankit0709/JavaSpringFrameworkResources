package com.springboot.SpringBootRestJDBC.student.services;

import com.springboot.SpringBootRestJDBC.student.modals.Student;
import com.springboot.SpringBootRestJDBC.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents(){
        return repository.findAll();
    }
    public String saveStudent(Student student){
        repository.save(student);
        return "Data Saved";
    }
    public Optional<Student> getStudentById(Integer id){
        return repository.findById(id);
    }
    public String removeStudent(Integer id){
        Optional<Student> student = getStudentById(id);
        if(student.isEmpty()){
            return "No Student with given id is found";
        }
        else{
            repository.delete(student.get());
            return "Student Deleted !";
        }
    }
    public String updateStudent(Integer id,Student student){
        Optional<Student> newStudent = getStudentById(id);
        if(newStudent.isEmpty()){
            return "No Student with given id is found";
        }
        student.setStudentId(id);
        repository.save(student);
        return "Student Updated !";
    }

}
