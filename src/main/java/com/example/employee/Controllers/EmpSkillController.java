package com.example.employee.Controllers;

import com.example.employee.Repositories.EmpSkillRepo;
import com.example.employee.Services.EmpSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empskill")
public class EmpSkillController {

    @Autowired
    private EmpSkillService empSkillService;

    @PostMapping("/addPosition")
    public String addPosition(@RequestParam("empid") String empid, @RequestParam("position") String position, @RequestParam("skill") String skill){
        return empSkillService.addPosition(empid,position,skill);
    }
}
