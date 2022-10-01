package com.aop.springaop.controller;

import com.aop.springaop.model.Employee;
import com.aop.springaop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
@ComponentScan
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // http://localhost:8085/emp/addEmp?empId=1&name=harsh
    @RequestMapping(value = {"/addEmp"}, method = RequestMethod.GET)
    public Employee addEmployee(@RequestParam(value = "name") String name, @RequestParam(value = "empId") String empId) {
        return employeeService.createEmployee(name, empId);
    }

    // http://localhost:8085/emp/removeEmp?empId=1
    @RequestMapping(value = "/removeEmp", method = RequestMethod.GET)
    public String removeEmployee( @RequestParam("empId") String empId) {
        employeeService.deleteEmployee(empId);
        return "Employee removed";
    }
}