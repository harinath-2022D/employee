package com.example.employee.Repositories;

import com.example.employee.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmpId(String empid);
}
