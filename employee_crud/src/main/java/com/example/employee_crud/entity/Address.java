package com.example.employee_crud.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
public class Address implements Serializable {

    private String streetName;
    private String phoneNumber;
    private String email;

}
