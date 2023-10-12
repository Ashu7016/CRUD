package com.CRUD.crud.Controller;

import com.CRUD.crud.exception.ResourceNotFoundException;
import com.CRUD.crud.model.Employee;
import com.CRUD.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/employees")

public class EmployeeController {


    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/course")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //rest API
    @PostMapping("/course")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //build get employee by id rest api

    @GetMapping("/course")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
                return ResponseEntity.ok(employee);

    }



    //update employee rest api
    @PutMapping({"id"})

    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " +id));

        updateEmployee.setFirstname(employeeDetails.getFirstname());
        updateEmployee.setLastname(employeeDetails.getLastname());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        Employee employee = employeeRepository.save(updateEmployee);
        return new ResponseEntity<>(employee ,HttpStatus.OK);
    }

    //Delete

    @DeleteMapping({"id"})

    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exit with id:" +id));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}




