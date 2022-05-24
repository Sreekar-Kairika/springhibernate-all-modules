package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequestMapping("/employees")
public class EmployeeController {

    //load employee data

    private List<Employee> theEmployee;

    @PostConstruct
    private void LoadData(){
        Employee emp1 = new Employee(1,"sreekar","Kairika","sree@gmail.com");
        Employee emp2 = new Employee(2,"sunny","Kairika","sree@gmail.com");
        Employee emp3 = new Employee(3,"sk","Kairika","sree@gmail.com");

        theEmployee = new ArrayList<>();

        theEmployee.add(emp1);
        theEmployee.add(emp2);
        theEmployee.add(emp3);

    }

    //add mapping to list

    @GetMapping("list")
    public String listEmployees(Model theModel){
        theModel.addAttribute("employees",theEmployee);

        return "list-employees";
    }

}
