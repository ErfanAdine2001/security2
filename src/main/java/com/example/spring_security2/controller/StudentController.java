package com.example.spring_security2.controller;

import com.example.spring_security2.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    private final List<Student> studentList = List.of(new Student(1L, "erfan"), new Student(2L, "ali"));

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")
    public Student getStudent(@PathVariable Long id) {
        return studentList.stream().filter(s -> id.equals(s.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("did not found student with this id "));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('student_write')")
    public void regester(@RequestBody Student student){
        System.out.println("regesterStudent");
        System.out.println("student =>"+ student);

    }



    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('student_write')")
    public void update(@PathVariable String id , @RequestBody Student student){
        System.out.println("update of student" + id);
        System.out.println("student =>"+student);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('student_write')")
    public void delete(@PathVariable String id){
        System.out.println("delete "+ id);
    }

}
