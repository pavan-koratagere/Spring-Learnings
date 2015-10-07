package com.emc.training.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CustomerList
{
    private Map<Integer, Customer> customers = new HashMap<Integer, Customer>();

    public CustomerList()
    {
        super();
        customers.put(1, new Customer(1, "Rajiv", 3010));
        customers.put(2, new Customer(2, "Ramesh", 4050));
        customers.put(3, new Customer(3, "Suresh", 5020));
        customers.put(4, new Customer(4, "Arjun", 6020));
        customers.put(5, new Customer(5, "Sachin", 7000));
        customers.put(6, new Customer(6, "Sathya", 3800));
        customers.put(7, new Customer(7, "Harish", 6800));
        customers.put(8, new Customer(8, "Subhash", 3090));
        customers.put(9, new Customer(9, "Amar", 3080));
        customers.put(10, new Customer(10, "Naveen", 3080));
    }

    public Customer findCustomer(int id)
    {
        return customers.get(id);
    }
}
