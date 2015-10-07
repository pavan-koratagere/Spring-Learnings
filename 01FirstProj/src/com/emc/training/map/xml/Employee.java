package com.emc.training.map.xml;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Properties;

public class Employee
{
    private String empName = "Rohit";
    private Map<String, Address> map;

    private Properties remarks;

    public Employee(String empName)
    {
        super();
        this.empName = empName;
    }

    public Properties getRemarks()
    {
        return remarks;
    }

    public void setRemarks(Properties remarks)
    {
        this.remarks = remarks;
    }

    public Map<String, Address> getMap()
    {
        return map;
    }

    public void setMap(Map<String, Address> map)
    {
        this.map = map;
    }

    public Employee()
    {
        System.out.println("invoking the constructor of Employee");
    }

    public String getEmpName()
    {
        return empName;
    }

    public void setEmpName(String empName)
    {
        this.empName = empName;
    }

    @Override
    public String toString()
    {
        return MessageFormat.format("Employee [empName={0}, map={1}, remarks={2}]", empName, map, remarks);
    }

}
