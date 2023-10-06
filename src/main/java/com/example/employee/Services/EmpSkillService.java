package com.example.employee.Services;

import com.example.employee.Models.EmpSkill;
import com.example.employee.Models.Employee;
import com.example.employee.Repositories.EmpRepository;
import com.example.employee.Repositories.EmpSkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpSkillService {
    @Autowired
    private EmpSkillRepo empSkillRepo;

    @Autowired
    private EmpRepository empRepository;
    public String addPosition(String empid, String position, String skill) {

        Optional<Employee> employeeOptional = empRepository.findByEmpId(empid);
        Employee employee = employeeOptional.get();

        EmpSkill empSkill = new EmpSkill();
        empSkill.setSkill(skill);
        empSkill.setPosition(position);
        empSkill.setEndingDay("NA");
        empSkill.setEmployee(employee);

        employee.getEmpSkills().add(empSkill);
        //empSkillRepo.save(empSkill);
        empRepository.save(employee);

        return "added position";
    }
}
