package com.example.newbook.service;

import com.example.newbook.exception.EmployeeAlredyAddedException;
import com.example.newbook.exception.EmployeeNotFoundException;
import com.example.newbook.exception.EmployeeStorageIsFullException;
import com.example.newbook.model.Employee;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {


        private static final int SIZE = 5;

        private final Employee[] employees;

        public EmployeeService() {
            this.employees = new Employee[SIZE];
        }


        public Employee add(String firstName, String lastName) {
            Employee employee = new Employee(firstName, lastName);
            int index = -1;
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    index = i;
                    break;
                }
                if (employee.equals(employees[i])) {
                    throw new EmployeeAlredyAddedException();
                }
            }
            if (index == -1) {
                throw new EmployeeStorageIsFullException();
            } else {
                employees[index] = employee;
                return employee;
            }
        }

        public Employee remove(String firstName, String lastName) {
            Employee employee = new Employee(firstName, lastName);
            for (int i = 0; i < employees.length; i++) {
                if (employee.equals(employees[i])) {
                    employees[i] = null;
                    return employee;
                }
            }
            throw new EmployeeNotFoundException();
        }

        public Employee find(String firstName, String lastName) {
            Employee employee = new Employee(firstName, lastName);
            for (Employee element : employees) {
                if (employee.equals(element)) {
                    return employee;
                }
            }
            throw new EmployeeNotFoundException();
        }
    }

