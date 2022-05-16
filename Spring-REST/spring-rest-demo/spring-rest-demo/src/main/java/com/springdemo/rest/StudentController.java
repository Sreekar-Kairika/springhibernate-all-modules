package com.springdemo.rest;


import com.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    //define an end point for "/students" - return list of students

    private List<Student> theStudents;

    //define @PostConstruct to load the  student data

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Sreekar","Kairika"));
        theStudents.add(new Student("Poornima","Patel")) ;
        theStudents.add(new Student("Mario","Rossi"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    //retrieve single student by id
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){

        //just index into the list

        if(studentId>theStudents.size() || studentId<0)
            throw new StudentNotFoundException("Students is not found - "+studentId);

        return theStudents.get(studentId);
    }

}
