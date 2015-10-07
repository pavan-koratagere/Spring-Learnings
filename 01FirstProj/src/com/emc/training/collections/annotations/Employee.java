package com.emc.training.collections.annotations;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee
{
    private int empId = 101;
    private String empName = "Hari";
    private String designation = "Manager";
    private double salary = 1000;

    @Autowired
    private List<Address> addresses;

    public List<Address> getAddresses()
    {
        return addresses;
    }

    public void setAddresses(List<Address> addresses)
    {
        this.addresses = addresses;
    }

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

    @Override
    public String toString()
    {
        return MessageFormat.format("Employee [empId={0}, empName={1}, designation={2}, salary={3}, addresses={4}]",
                empId, empName, designation, salary, addresses);
    }

}
