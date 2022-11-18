package com.example.employee_crud.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Book extends IdClass {

    private String title;
    private double price;
    private LocalDate yearPublished;
    private String imgUrl;



}
