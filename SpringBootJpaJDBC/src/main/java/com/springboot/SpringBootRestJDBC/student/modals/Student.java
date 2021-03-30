package com.springboot.SpringBootRestJDBC.student.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "StudentDetails")
public class Student {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name  ="Student_Id")
    private Integer studentId;
    @Column(name = "Student_Name")
    private String studentName;
    @Column(name = "Student_Mail")
    private String mailId;
    @Column(name = "Phone_Number")
    private String phoneNumber;
}
