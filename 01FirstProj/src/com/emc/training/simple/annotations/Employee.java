package com.emc.training.simple.annotations;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("emp")
@Scope("prototype")
public class Employee
{
    private int empId = 100;
    private String empName = "Suresh";
    private String designation = "Manager";
    private double salary = 2000;
    @Autowired
    private Address address;

    public Employee()
    {
        System.out.println("invoking the constructor of Employee");
    }

    public int getEmpId()
    {
        return empId;
    }

    public void setEmpId(int empId)
    {
        this.empId = empId;
    }

    public String getEmpName()
    {
        return empName;
    }

    public void setEmpName(String empName)
    {
        this.empName = empName;
    }

    public String getDesignation()
    {
        return designation;
    }

    public void setDesignation(String designation)
    {
        this.designation = designation;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return MessageFormat.format("Employee [empId={0}, empName={1}, designation={2}, salary={3}, address={4}]",
                empId, empName, designation, salary, address);
    }

}
