package com.example.newbook.model;

import java.util.Objects;

public class Employee {
    private final String firstname;
    private final String lastName;

    public Employee(String firstname, String lastName) {
        this.firstname = firstname;
        this.lastName = lastName;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;

        }
        if (o == null || getClass() != o.getClass()) {
            return false;

        }
        Employee employee = (Employee) o;
        return Objects.equals(firstname, employee.firstname) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastName);
    }

    @Override
    public String toString() {
        return "Employee" +
                "firstname='" + firstname +
                ", lastName='" + lastName;
    }
}
