package com.example.stulaponetomay.dto;

import com.example.stulaponetomay.entity.Laptop;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto {

    private int rollno;

    private String name;

    private List<Laptop> laptop;
}
