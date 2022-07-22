package com.web.demo.controls;

import com.web.demo.model.Employee;
import com.web.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/empList")
    public String listEmployees(Model theModel) {
        List<Employee> employeeList = employeeService.getEmployeeList();
        theModel.addAttribute("employeeList", employeeList);
        return "employee/list-employees";
    }

    @GetMapping("/listDataTable")
    public String listEmployeeDataTable(Model theModel) {
        List<Employee> employeeList = employeeService.getEmployeeList();
        theModel.addAttribute("employeeList", employeeList);
        return "employee/employees";
    }

    @RequestMapping("/listEmp")
    @ResponseBody
    public List<Employee> getEmployeeList(){
        return employeeService.getEmployeeList();
    }
}
