package com.rh.spring.a1restcrudjpamysql.service;

import com.rh.spring.a1restcrudjpamysql.dao.EmployeeDao;
import com.rh.spring.a1restcrudjpamysql.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeService(@Autowired EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> findAll(){
        return employeeDao.findAll();
    }

    public Employee findById(int employeeId){
        return employeeDao.findById(employeeId).orElse(null);
    }

    public Employee save(Employee employee){
        return employeeDao.save(employee);
    }

    public void deleteById(int employeeId){
        employeeDao.deleteById(employeeId);
    }
}
