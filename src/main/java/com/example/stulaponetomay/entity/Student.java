package com.example.stulaponetomay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "student")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollno;

    private String name;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Laptop> laptop;
}
