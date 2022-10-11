package com.example.newbook.service;

import com.example.newbook.exception.EmployeeAlredyAddedException;
import com.example.newbook.exception.EmployeeNotFoundException;
import com.example.newbook.exception.EmployeeStorageIsFullException;
import com.example.newbook.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeeService {


        private static final int LIMIT = 5;

        private final Map<String, Employee> employees = new HashMap<>();
        private final ValidatorService validatorService;

        private String getKey(String firstName, String lastName){
            return firstName + "|" + lastName;
        }



    public EmployeeService(ValidatorService validatorService) {
        this.validatorService = validatorService;
        }


        public Employee add(String firstName,
                            String lastName,
                            int department,
                            double salary) {
            Employee employee = new Employee(
                    validatorService.validate(firstName),
                    validatorService.validate(lastName),
                    department,
                    salary
            );

            String key = getKey(firstName, lastName);

            if (employees.containsKey(key)) {
                throw new EmployeeAlredyAddedException();
            }

            if (employees.size() >= LIMIT) {

                employees.put(key, employee);
                return employee;
            }
            throw new EmployeeStorageIsFullException();
        }

    public Employee remove(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
            if (employees.containsKey(employee)){
                return employee;
            }
        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String lastName,int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);;
        if (employees.containsKey(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Map<String, Employee> findAll() {
        return  new HashMap<>();
    }
    public Collection<Employee> getALL() {
        return null;
    }


}

