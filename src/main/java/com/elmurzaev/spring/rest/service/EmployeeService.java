package com.elmurzaev.spring.rest.service;


import com.elmurzaev.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void save(Employee employee);

    Employee show(int id);

    void delete(int id);
}
