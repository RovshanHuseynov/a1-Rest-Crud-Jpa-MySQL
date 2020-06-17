package com.rh.spring.a1restcrudjpamysql.controller;

import com.rh.spring.a1restcrudjpamysql.entity.Employee;
import com.rh.spring.a1restcrudjpamysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee get(@PathVariable("employeeId") int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee id is not found - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee add(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public Employee delete(@PathVariable("employeeId") int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee id is not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);
        return employee;
    }
}
