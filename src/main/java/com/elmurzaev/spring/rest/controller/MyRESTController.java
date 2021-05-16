package com.elmurzaev.spring.rest.controller;

import com.elmurzaev.spring.rest.entity.Employee;
import com.elmurzaev.spring.rest.exception_handling.EmployeeIncorrectData;
import com.elmurzaev.spring.rest.exception_handling.NoSuchEmployeeException;
import com.elmurzaev.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class MyRESTController {
    private EmployeeService employeeService;

    @Autowired
    public MyRESTController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> index(){
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

    @GetMapping("{id}")
    public Employee show(@PathVariable int id){
        Employee employee = employeeService.show(id);
        if (employee == null) throw new NoSuchEmployeeException("There is no employee with id = "+
                id + " in database");
        return employee;
    }

    @PostMapping()
    public Employee add(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @PatchMapping()
    public Employee edit(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){
        if (employeeService.show(id) == null) throw new NoSuchEmployeeException("There is no employee with id = "+
                id + " in database");
        employeeService.delete(id);
        return "Employee with id = " + id + " was deleted";
    }
}
