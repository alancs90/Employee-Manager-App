package com.alan.employeemanager.service;
import com.alan.employeemanager.model.Employee;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;

    @Test
    void addEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Alan");
        employee.setEmail("alan@a.com");
        employee.setJobTitle("Java");
        employee.setPhone("12345678");
        employee.setImageUrl("image.com");
        employee.setEmployeeCode("8d8b30e3-de52-4f1c-a71c-9905a8043dab");

        UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dab");

        try (MockedStatic<UUID> mockedUuid = Mockito.mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);
            employee = employeeService.addEmployee(employee);
            Employee empFromDao = employeeService.findEmployeeById(employee.getId());

            assertEquals(employee, empFromDao);
            assertEquals(1L, empFromDao.getId());
            assertEquals("Alan", empFromDao.getName());
            assertEquals("alan@a.com", empFromDao.getEmail());
            assertEquals("Java", empFromDao.getJobTitle());
            assertEquals("12345678", empFromDao.getPhone());
            assertEquals("image.com", empFromDao.getImageUrl());
            assertEquals(defaultUuid.toString(), empFromDao.getEmployeeCode());

            System.out.println(employee.toString());
            System.out.println(empFromDao.toString());
        }
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