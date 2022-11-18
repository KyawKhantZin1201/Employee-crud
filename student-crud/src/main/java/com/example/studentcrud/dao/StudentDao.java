package com.example.studentcrud.dao;

import com.example.studentcrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Integer> {
}
