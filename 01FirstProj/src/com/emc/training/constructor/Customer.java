package com.emc.training.constructor;

import java.text.MessageFormat;

public class Customer
{
    private int id;
    private String name;
    private double balance;

    public Customer(int id)
    {
        super();
        this.id = id;
    }

    public Customer(int id, String name)
    {
        super();
        this.id = id;
        this.name = name;
    }

    public Customer(int id, double balance)
    {
        super();
        this.id = id;
        this.balance = balance;
    }

    @Override
    public String toString()
    {
        return MessageFormat.format("Customer [id={0}, name={1}, balance={2}]", id, name, balance);
    }

}
