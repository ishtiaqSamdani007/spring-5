package com.example.stulaponetomay.Service;

import com.example.stulaponetomay.dto.StudentDto;
import com.example.stulaponetomay.entity.Student;

import java.lang.invoke.CallSite;
import java.util.List;

public interface StudentServiceInterface {

    public void saveStudent(StudentDto studentDto);
    public void saveAllStudents(List<StudentDto> studentDtoList);

    public Student getStudentById(long rollNo);

    public List<Student> getAllStudents();

    public void updateStudentById(long rollNo, StudentDto studentDto);

    public void deleteStudentById(long rollNo);


}
