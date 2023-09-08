package com.example.stulaponetomay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "laptop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lid;

    private String lname;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "rollno")
//    @JsonIgnore
    private Student student;

}
