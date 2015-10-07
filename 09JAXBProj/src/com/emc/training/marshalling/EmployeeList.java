package com.emc.training.marshalling;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeList
{
    private List<Employee> list = new ArrayList<Employee>();

    @XmlElementRef
    public List<Employee> getList()
    {
        return list;
    }

    public void setList(List<Employee> list)
    {
        this.list = list;
    }

    public void addEmployee(Employee e)
    {
        list.add(e);
    }
}
