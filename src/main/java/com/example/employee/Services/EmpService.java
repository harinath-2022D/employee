package com.example.employee.Services;

import com.example.employee.Models.Employee;
import com.example.employee.Repositories.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmpService {
    @Autowired
    private EmpRepository empRepository;

    public String addEmp(Employee emp) {
        String empID = UUID.randomUUID().toString();
        emp.setEmpId(empID);
        empRepository.save(emp);
        return "employee with id "+empID+" added to db";
    }
}
