package com.emc.training.marshalling;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "id", "name", "designation" })
public class Employee
{
    private int id;
    private String name;
    private String designation;

    public Employee()
    {
        super();
    }

    public Employee(int id, String name, String designation)
    {
        super();
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

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

    public String getDesignation()
    {
        return designation;
    }

    public void setDesignation(String designation)
    {
        this.designation = designation;
    }

}
