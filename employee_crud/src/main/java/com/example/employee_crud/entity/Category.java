package com.example.employee_crud.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Category extends IdClass {

    private String categoryName;



}
