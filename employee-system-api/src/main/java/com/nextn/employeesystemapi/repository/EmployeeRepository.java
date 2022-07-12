package com.nextn.employeesystemapi.repository;

import com.nextn.employeesystemapi.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
