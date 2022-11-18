package com.example.employee_crud.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Employee {

    private String name;
    private double salary;
    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;

    @Embedded
    private Address address = new Address();


}
