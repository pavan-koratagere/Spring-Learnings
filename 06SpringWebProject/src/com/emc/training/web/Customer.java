package com.emc.training.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("customer1")
@Scope("request")
public class Customer
{
    private int id = 1;
    private String name = "default";
    private double balance = 1000;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

}
