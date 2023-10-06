package com.example.employee.Controllers;

import com.example.employee.Models.Employee;
import com.example.employee.RequestDtos.EmpRatingDto;
import com.example.employee.Services.EmpRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empRatings")
public class EmpRatingsController {
    @Autowired
    private EmpRatingsService empRatingsService;

    @PostMapping("addRatings")
    public String addRatings(@RequestBody EmpRatingDto empRatingDto) {
        return empRatingsService.addRatings(empRatingDto);
    }

    @GetMapping("getRatingsLess")
    public void getRaingsLess(){
        empRatingsService.getRatingsLess();
    }
}
