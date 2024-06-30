package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudent;

    //define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData(){

        theStudent = new ArrayList<>();

        theStudent.add(new Student("Poornima" , "Patel"));
        theStudent.add(new Student("Mario" , "Rossi"));
        theStudent.add(new Student("Mary" , "Smith"));

    }

    // define endpoints for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudent;
    }

    // define endpoint or "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //check the studentId again list size
        if ((studentId>=theStudent.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }

        return theStudent.get(studentId);
    }




}

