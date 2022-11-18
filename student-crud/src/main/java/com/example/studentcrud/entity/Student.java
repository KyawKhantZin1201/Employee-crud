package com.example.studentcrud.entity;

import com.example.studentcrud.constraint.NotAdmin;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotAdmin(message = "Name cannot be admin!")
    @NotEmpty(message = "Name cannot be empty!")
    @Size(min = 8,message = "Name must be between 6 and 15 letters.")
    private String name;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotEmpty(message = "School cannot be empty!")
    private String school;
    //@Pattern(regexp = "[a-zA-Z]*",message = "grade cannot contain illegal characters")
    @NotEmpty(message = "Grade cannot be empty!")
    private String grade;



}
