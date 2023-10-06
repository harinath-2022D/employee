package com.example.employee.Controllers;

import com.example.employee.Models.Employee;
import com.example.employee.Services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/addEmp")
    public String addEmp(@RequestBody Employee emp){
        return empService.addEmp(emp);
    }
}
