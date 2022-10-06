package com.example.newbook.service;

import com.example.newbook.exception.EmployeeAlredyAddedException;
import com.example.newbook.exception.EmployeeNotFoundException;
import com.example.newbook.exception.EmployeeStorageIsFullException;
import com.example.newbook.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class EmployeeService {


        private static final int SIZE = 5;

        private final List<Employee> employees;

        public EmployeeService() {
            this.employees = new ArrayList<>();
        }


        public Employee add(String firstName,
                            String lastName,
                            int department,
                            double salary) {
            Employee employee = new Employee(firstName, lastName, department, salary);

            if (employees.contains(employee)) {
                throw new EmployeeAlredyAddedException();
            }

            if (employees.size() >= SIZE) {
                throw new EmployeeStorageIsFullException();
            }
            employees.add(employee);
            return employee;
        }

    public Employee remove(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName,department, salary);
            if (employees.contains(employee)) {
                employees.remove(employee);
                return employee;
            }
        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName,department, salary);;
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    public Collection<Employee> getALL() {
        return null;
    }
}

