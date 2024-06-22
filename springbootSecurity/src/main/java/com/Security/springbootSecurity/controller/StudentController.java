package com.Security.springbootSecurity.controller;

import com.Security.springbootSecurity.Entities.StudentEntities;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<StudentEntities> students = new ArrayList<>();
    @GetMapping("/students")
    public List<StudentEntities> students() {
      ;
        StudentEntities student1 = new StudentEntities();
        student1.setId(1);
        student1.setFirstName("kumari");
        student1.setLastName("somya");

        StudentEntities student2 = new StudentEntities();
        student2.setId(2);
        student2.setFirstName("Kumari");
        student2.setLastName("simmi");

        students.add(student1);
        students.add(student2);
        return students;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/students")
    public StudentEntities createStudent( @RequestBody StudentEntities studentEntities){
        students.add(studentEntities);
        return studentEntities;
    }



}
