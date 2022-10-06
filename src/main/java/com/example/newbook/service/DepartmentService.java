package com.example.newbook.service;

import com.example.newbook.exception.EmployeeNotFoundException;
import com.example.newbook.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public Employee findEmployeeWhithMaxSalaryFromDepartment(int department) {
        return employeeService.getALL().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findEmployeeWhithMinSalaryFromDepartment(int department) {
        return employeeService.getALL().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
    

    public Collection<Employee> findEmployeesFromDepartment(int department) {
        return employeeService.getALL().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> findEmployees() {
        return (Map<Integer, List<Employee>>) employeeService.getALL().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
