package com.alan.employeemanager;

import com.alan.employeemanager.model.Employee;
import com.alan.employeemanager.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeResourceTest {

    @Mock
    private EmployeeService mockEmployeeService;

    @InjectMocks
    private EmployeeResource mockEmployeeResource;

    @Test
    void getAllEmployees() {

        when(mockEmployeeService.findAllEmployees()).thenReturn(new ArrayList<Employee>());
        ResponseEntity<List<Employee>> actualResponse = mockEmployeeResource.getAllEmployees();
        ResponseEntity<List<Employee>> expectedResponse = new ResponseEntity<>(new ArrayList<Employee>(), HttpStatus.OK);

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void getEmployeeById() {
    }

    @Test
    void addEmployee() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployee() {
    }
}