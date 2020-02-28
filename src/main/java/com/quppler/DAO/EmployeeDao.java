package com.quppler.DAO;

import com.quppler.model.Employee;
import java.util.Optional;

public interface EmployeeDao {

    public Optional<Employee> fetchEmployeeById(String empId, boolean isCacheable) throws InterruptedException;
}
