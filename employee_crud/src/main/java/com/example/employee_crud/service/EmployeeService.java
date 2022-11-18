package com.example.employee_crud.service;

import com.example.employee_crud.dao.EmployeeDao;
import com.example.employee_crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void saveEmployee(Employee employee){
        employeeDao.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeDao.findAll();
    }

    public Employee findEmployeeById(int id){
        return employeeDao
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    /*Optional<Employee> findById(int id){
        return employeeDao.findById(id);
    }*/

    public void deleteEmployeeById(int id){
        employeeDao.deleteById(id);
    }

    public void updateEmployee(Employee employee){
        if(employeeDao.existsById(employee.getId())){
            employeeDao.saveAndFlush(employee);
        }
        else{
            throw new EntityNotFoundException();
        }
    }
}
