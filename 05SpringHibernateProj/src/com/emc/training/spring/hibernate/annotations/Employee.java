package com.emc.training.spring.hibernate.annotations;

import java.text.MessageFormat;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Hariprasad Manchi
 *
 */
@Entity
@Table(name = "employee_tbl")
public class Employee
{
    @Id
    @Column(name = "emp_id")
    private int employeeId;

    @Column(name = "emp_name")
    private String name;

    @Column
    private double balance;

    @OneToMany(cascade = { CascadeType.ALL })
    @JoinColumn(name = "employee")
    private List<Address> addresses;

    public List<Address> getAddresses()
    {
        return addresses;
    }

    public void setAddresses(List<Address> addresses)
    {
        this.addresses = addresses;
    }

    public Employee(int employeeId, String name, double balance)
    {
        super();
        this.employeeId = employeeId;
        this.name = name;
        this.balance = balance;
    }

    public Employee()
    {
        super();
    }

    public int getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    @Override
    public String toString()
    {
        return MessageFormat.format("Employee [empId={0}, name={1}, balance={2}]\n", employeeId, name, balance);
    }

}
