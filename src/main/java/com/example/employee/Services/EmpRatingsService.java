package com.example.employee.Services;

import com.example.employee.Models.EmpRatings;
import com.example.employee.Models.Employee;
import com.example.employee.Repositories.EmpRatingsRepository;
import com.example.employee.Repositories.EmpRepository;
import com.example.employee.RequestDtos.EmpRatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class EmpRatingsService {
    @Autowired
    private EmpRatingsRepository empRatingsRepository;
    @Autowired
    private EmpRepository empRepository;
    public void getRatingsLess() {
        List<EmpRatings> empRatingsList = empRatingsRepository.findAll();

        for(int i=0; i<empRatingsList.size(); i++){
            EmpRatings empRatings = empRatingsList.get(i);
            if(empRatings.getTechnicalRating()<2.5 || empRatings.getCommunicationRating()<2.5){
                Employee employee = empRatings.getEmployee();
                System.out.println(employee.getEmail()+"notified about rating");
            }
        }
       // return new ArrayList<>();
    }

    public String addRatings(EmpRatingDto empRatingDto) {
        Optional<Employee> employeeOptional =empRepository.findByEmpId(empRatingDto.getEmpid());
        Employee employee = employeeOptional.get();

        EmpRatings empRatings = new EmpRatings();

        empRatings.setCommunicationRating(empRatingDto.getCommunicationRating());
        empRatings.setTechnicalRating(empRatingDto.getTechnicalRating());
        empRatings.setMonth(empRatingDto.getMonth());
        empRatings.setYear(empRatingDto.getYear());
        empRatings.setRemarks(empRatingDto.getRemarks());
        empRatings.setTechnology(empRatingDto.getTechnology());
        empRatings.setEmployee(employee);
        employee.getEmpRatingsList().add(empRatings);
       // empRatingsRepository.save(empRatings);
        empRepository.save(employee);

        System.out.println("ratings added");
        return "added rating";
    }
    @Scheduled(cron = "*/5 * * * * *")
    public void schedulingTask() throws InterruptedException{
        //cron = "0 0 17 1-10 * ?" -> every month 1 to 10 date 5 pm
        System.out.println("sheduling task for every 30 sec");
    }

//    #logging.level.com.example.springbootloggingexample.controller=DEBUG
//#
//        ## Logging pattern for the console
//#logging.pattern.console= %date{ISO8601} %-5level %class{0}:%L - [%X] %msg%n
//#
//        ##logging pattern for file
//#logging.pattern.file=%date{ISO8601} %-5level %class{0}:%L - [%X] %msg%n
//#
//        ## output file
//#logging.file.name=application.log

 //   https://github.com/sumitMultani/spring-boot-logging-example/blob/master/src/main/resources/logback.xml
}
