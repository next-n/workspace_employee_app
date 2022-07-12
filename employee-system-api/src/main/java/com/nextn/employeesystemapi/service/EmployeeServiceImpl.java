package com.nextn.employeesystemapi.service;

import com.nextn.employeesystemapi.entity.EmployeeEntity;
import com.nextn.employeesystemapi.model.Employee;
import com.nextn.employeesystemapi.repository.EmployeeRepository;
import com.nextn.employeesystemapi.utils.HelperFunctionsForEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private HelperFunctionsForEmployeeService helperFunctionsForEmployeeService;
    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
//        BeanUtils.copyProperties(employee, employeeEntity);
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
//        List<Employee> employees = employeeEntities.stream()
//                .map(e -> new Employee().builder().id(e.getId()).firstName(e.getFirstName()).lastName(e.getLastName()).emailId(e.getEmailId()).build()).toList();
//
        List<Employee> employees = employeeEntities.stream()
                .map(e -> helperFunctionsForEmployeeService.changeModel(e)).toList();
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeEntity.setId(id);
        employeeRepository.save(employeeEntity);
        return employee;
    }
}
