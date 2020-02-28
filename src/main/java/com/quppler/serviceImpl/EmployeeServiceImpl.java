package com.quppler.serviceImpl;

import com.quppler.DAO.EmployeeDao;
import com.quppler.model.Address;
import com.quppler.model.Department;
import com.quppler.model.Employee;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeDao {

    @Override
    @Cacheable(value="twentySecondCache" , key = "'EmployeeInCache' +#empolyeeId", condition = "#isCacheable != null && #isCacheable")
    public Optional<Employee> fetchEmployeeById(String empId, boolean isCacheable) throws InterruptedException{
    Thread.sleep(5000);
    return Arrays.asList( new Employee("1001","Eddie","Capel","55",new Address(
            "101","Park Street","Manhattan","New York","993031"), Department.OFFICER),
            new Employee("1002","Vijay","Kumar","28",new Address(
                    "102","Park Street","Manhattan","New York","993031"), Department.FINANCE),
            new Employee("1003","Rahul","Sharma","30",new Address(
                    "104","Park Street","Manhattan","New York","993031"), Department.ACCOUNTING))
            .stream().filter(t -> t.getId().equalsIgnoreCase(empId)).findFirst();



    }
}
