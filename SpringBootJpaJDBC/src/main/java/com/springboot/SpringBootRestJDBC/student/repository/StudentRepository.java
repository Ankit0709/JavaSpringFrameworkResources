package com.springboot.SpringBootRestJDBC.student.repository;

import com.springboot.SpringBootRestJDBC.student.modals.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Integer> {

}
