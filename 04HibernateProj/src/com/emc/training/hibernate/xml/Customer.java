package com.emc.training.hibernate.xml;

import java.text.MessageFormat;

/**
 * 
 * @author Hariprasad Manchi
 *
 */
public class Customer
{
    private int customerId;
    private String name;
    private double balance;

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
