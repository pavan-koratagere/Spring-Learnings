package com.emc.training.hibernate.annotations;

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
@Table(name = "cust_tbl")
public class Customer
{
    @Id
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name")
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

    public Customer(int customerId, String name, double balance)
    {
        super();
        this.customerId = customerId;
        this.name = name;
        this.balance = balance;
    }

    public Customer()
    {
        super();
    }

    public int getCustomerId()
    {
        return customerId;
    }

    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
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
        return MessageFormat.format("Customer [customerId={0}, name={1}, balance={2}]\n", customerId, name, balance);
    }

}
