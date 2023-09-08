package com.example.stulaponetomay.Service;

import com.example.stulaponetomay.dao.StudentRepo;
import com.example.stulaponetomay.dto.StudentDto;
import com.example.stulaponetomay.entity.Student;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceInterfaceImpl implements StudentServiceInterface {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    private StudentDto convertToDto(Student student){
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }

    private Student convertToEntity(StudentDto studentDto){
        Student student = modelMapper.map(studentDto, Student.class);
        return student;
    }
    @Override
    public void saveStudent(StudentDto studentDto) {
        Student student = convertToEntity(studentDto);
        studentRepo.save(student);
    }

    @Override
    public void saveAllStudents(List<StudentDto> studentDtoList) {

        List<Student> studentList = studentDtoList.stream().map(studentDto -> convertToEntity(studentDto)).collect(Collectors.toList());
        studentRepo.saveAll(studentList);

    }

    @Override
    public Student getStudentById(long rollNo) {
        return studentRepo.findById(rollNo).get();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void updateStudentById(long rollNo, StudentDto studentDto) {
        Student student = studentRepo.findById(rollNo).get();
        student.setName(studentDto.getName());
//        student.setLaptop(studentDto.getLaptop());


    }

    @Override
    public void deleteStudentById(long rollNo) {
        studentRepo.deleteById(rollNo);
    }
}
