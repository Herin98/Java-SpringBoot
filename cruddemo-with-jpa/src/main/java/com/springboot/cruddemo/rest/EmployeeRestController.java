package com.springboot.cruddemo.rest;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        List<Employee> employeeList=employeeService.showAll();
        return employeeList;
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findByID(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Employee id not found");
        }
        return  theEmployee;
    }
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return theEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String  deleteEmployee(@PathVariable  int employeeId ){
        Employee tempEmployee=employeeService.findByID(employeeId);
        if(tempEmployee==null){
            throw  new RuntimeException("Employee id not found: "+employeeId);
        }
        employeeService.delete(employeeId);
        return "Employee with id :"+employeeId+"is deleted";

    }

    @GetMapping("/employees/email/{email}")
    public List<Employee> findBymail(@PathVariable  String email){
        System.out.println("In controller: " + email);
        List<Employee> employeeList=employeeService.findBymail(email);
        System.out.println("In controller: " + employeeList.toString());
        return employeeList;
    }
}
