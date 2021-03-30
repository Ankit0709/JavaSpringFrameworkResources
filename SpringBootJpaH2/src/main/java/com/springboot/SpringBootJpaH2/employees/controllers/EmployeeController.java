package com.springboot.SpringBootJpaH2.employees.controllers;

import com.google.gson.JsonObject;
import com.springboot.SpringBootJpaH2.employees.modals.Employee;
import com.springboot.SpringBootJpaH2.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(value = "/getEmployees")
    public List<Employee>  getAllEmployees(){
        return employeeRepository.findAll();
    }
    @PostMapping(value = "/addEmployee",consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String addEmployee(@RequestBody  Employee employee){
        JsonObject response = new JsonObject();
       try{
           employeeRepository.save(employee);
           response.addProperty("success", "Employee Added!");
       }
       catch (Exception ex){
           ex.printStackTrace();
           response.addProperty("failure", "Error Occurs!");
       }
       return response.toString();
    }

    @DeleteMapping(value = "/deleteEmployee/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        JsonObject response = new JsonObject();
        try{
            Optional<Employee> employee = employeeRepository.findById(id);
            if(employee.isEmpty()){
                response.addProperty("failure", "Employee with Given Id not Found!");
            }
            else{
                employeeRepository.delete(employee.get());
                response.addProperty("success", "Employee Deleted!");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            response.addProperty("failure", "Error Occurs!");
        }
        return response.toString();
    }
    @PutMapping(value = "/updateEmployee/{id}",consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee emp){
        JsonObject response = new JsonObject();
        try{
            Optional<Employee> employee = employeeRepository.findById(id);
            if(employee.isEmpty()){
                response.addProperty("failure", "Employee with Given Id not Found!");
            }
            else{
                emp.setEmpId(employee.get().getEmpId());
                employeeRepository.save(emp);
                response.addProperty("success", "Employee Updated!");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            response.addProperty("failure", "Error Occurs!");
        }
        return response.toString();
    }

}
