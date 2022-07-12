package com.nextn.employeesystemapi.utils;

import com.nextn.employeesystemapi.entity.EmployeeEntity;
import com.nextn.employeesystemapi.model.Employee;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

@Component
public class HelperFunctionsForEmployeeService {
    public Employee changeModel(EmployeeEntity employeeEntity){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }
}
