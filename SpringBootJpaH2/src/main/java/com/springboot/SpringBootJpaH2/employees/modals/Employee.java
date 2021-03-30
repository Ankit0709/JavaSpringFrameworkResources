package com.springboot.SpringBootJpaH2.employees.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_Id")
    private Integer empId;
    @Column(name = "Employee_Name")
    private String empName;
    @Column(name = "Employee_Designation")
    private String designation;
    @Column(name ="Employee_MailId")
    private String mailId;
    @Column(name = "Employee_PhoneNumber")
    private String phoneNumber;
}
