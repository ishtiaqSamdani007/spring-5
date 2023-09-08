package com.example.stulaponetomay.dto;

import com.example.stulaponetomay.entity.Student;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LaptopDto {

    private int lid;
    private String lname;
    private Student student;
}
