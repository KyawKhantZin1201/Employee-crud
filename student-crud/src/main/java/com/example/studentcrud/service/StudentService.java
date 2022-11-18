package com.example.studentcrud.service;

import com.example.studentcrud.dao.StudentDao;
import com.example.studentcrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public void saveStudent(Student student){
        studentDao.save(student);
    }

    public List<Student> findAllStudent(){
        return studentDao.findAll();
    }

    public Student findStudentById(int id){
        return studentDao.findById(id).orElseThrow(EntityNotFoundException::new);
    }

}
