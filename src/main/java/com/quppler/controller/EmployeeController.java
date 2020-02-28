package com.quppler.controller;

import com.quppler.DAO.EmployeeDao;
import com.quppler.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/getById")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam(name = "employeeId") String id, @RequestParam(name = "isCacheable") boolean isCacheable) throws InterruptedException {
        Optional<Employee> emp = employeeDao.fetchEmployeeById(id, isCacheable);
        return ResponseEntity.status(HttpStatus.OK).body(emp.get());
    }
}
