package com.example.newbook.model;

import java.util.Objects;

public class Employee {

    private final String firstname;
    private final String lastName;

    private  final int department;

    private  final double salary;



    public Employee(String firstname, String lastName, int department, double salary) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;


    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true;
    }
        if (o == null || getClass() != o.getClass()) {return false;}

        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && Objects.equals(firstname, employee.firstname) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastName, department, salary);
    }

    @Override
    public String toString() {
        return String.format("ФИ: %s %s", firstname, lastName, department, salary);
    }
}
