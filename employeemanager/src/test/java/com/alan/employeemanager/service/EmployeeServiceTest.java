package com.alan.employeemanager.service;
import com.alan.employeemanager.model.Employee;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;

    @Test
    void addEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Alan");
        employee.setEmail("alan@.com");
        employee.setJobTitle("Java");
        employee.setPhone("12345678");
        employee.setImageUrl("image.com");
        employee.setEmployeeCode(UUID.randomUUID().toString());

        employee = employeeService.addEmployee(employee);
        Employee empFromDao = employeeService.findEmployeeById(employee.getId());

//        Long actualEmpId = employee.getId();
        assertEquals(employee, empFromDao);
        assertEquals(1L, employee.getId());
        assertEquals("Alan", employee.getName());
        assertEquals("alan@a.com", employee.getEmail());
        assertEquals("Java", employee.getJobTitle());
        assertEquals("12345678", employee.getPhone());
        assertEquals("image.com", employee.getImageUrl());
        assertEquals("Alan", employee.getName());
        assertEquals("1234abcd", employee.getEmployeeCode());

    }

    @Test
    void findAllEmployees() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void findEmployeeById() {
    }

    @Test
    void deleteEmployee() {
    }
}