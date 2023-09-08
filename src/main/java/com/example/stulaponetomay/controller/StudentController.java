package com.example.stulaponetomay.controller;

import com.example.stulaponetomay.Service.StudentServiceInterfaceImpl;
import com.example.stulaponetomay.dto.StudentDto;
import com.example.stulaponetomay.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentServiceInterfaceImpl studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{rollNo}")
    public Student getStudentById(@PathVariable long rollNo){
        return studentService.getStudentById(rollNo);
    }

    @PostMapping
    public void addStudent(@RequestBody StudentDto studentDto){
        studentService.saveStudent(studentDto);
    }

    @PutMapping("{rollNo}")
    public void updateStudentById(@PathVariable long rollNo, @RequestBody StudentDto studentDto){
        studentService.updateStudentById(rollNo, studentDto);
    }

    @DeleteMapping("{rollNo}")
    public void deleteStudentById(@PathVariable long rollNo){
        studentService.deleteStudentById(rollNo);
    }
}
