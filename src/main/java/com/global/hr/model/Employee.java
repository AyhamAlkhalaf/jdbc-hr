package com.global.hr.model;

public class Employee {

    private long employeeid;
    private String name;
    private  double salary;

    public Employee(long employeeid, String name, double salary) {
        this.employeeid = employeeid;
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }

    public long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(long employeeid) {
        this.employeeid = employeeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
