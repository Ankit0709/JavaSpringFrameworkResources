package com.springboot.SpringBootJpaH2.employees.repository;

import com.springboot.SpringBootJpaH2.employees.modals.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
