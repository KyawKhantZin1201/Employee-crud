package com.example.studentcrud.constraint;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameNotAdmin implements ConstraintValidator<NotAdmin,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !s.equalsIgnoreCase("admin");
    }
}
