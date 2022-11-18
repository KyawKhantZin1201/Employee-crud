package com.example.employee_crud.controller;

import com.example.employee_crud.entity.Employee;
import com.example.employee_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String employeeForm(Model model){
        model.addAttribute("employee",new Employee());
        return "employee-form";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(Employee employee, BindingResult result){
        if(result.hasErrors()){
            System.out.println("Employee :" + employee);
            return "employee-form";
        }
        employeeService.saveEmployee(employee);
        System.out.println("Employee: "+employee);
        return "redirect:/list-employees";
    }

    @GetMapping("/list-employees")
    public String listEmployees(Model model){
        model.addAttribute("employees",employeeService.findAllEmployees());
        return "employee-list";
    }

    @GetMapping("/list-employees/delete/{empId}")
    public String deleteEmployee(@PathVariable int empId){
        employeeService.deleteEmployeeById(empId);
        return "redirect:/list-employees";
    }

    @GetMapping("/list-employees/update")
    public String updateEmployee(Model model,@RequestParam("id") int id){
        employeeId = id ;
        System.out.println("Id: "+id);
        model.addAttribute("employees", employeeService.findEmployeeById(id));
        return "update-employee";
    }
    private int employeeId;

    @PostMapping("/list-employees/update")
    public String saveUpdateEmployee(Employee employee){
        employee.setId(employeeId);
        employeeService.updateEmployee(employee);
        return "redirect:/list-employees";
    }



}
