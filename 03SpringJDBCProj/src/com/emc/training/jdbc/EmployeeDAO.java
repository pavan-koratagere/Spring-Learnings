package com.emc.training.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO
{
    @Autowired
    private JdbcTemplate template;

    // not needed if @Autowired is used
    // public void setTemplate(JdbcTemplate template)
    // {
    // this.template = template;
    // }

    public void addEmployee(int id, String name, String designation, double salary)
    {
        String sql = "insert into Employee_tbl values(?, ?, ?, ?)";
        int count = template.update(sql, id, name, designation, salary);
        if (count > 0)
        {
            System.out.println("row inserted successfully");
        } else
        {
            System.out.println("error while inserting row");
        }
    }

    public List<Employee> getAllEmployees()
    {
        String sql = "select * from Employee_tbl order by empid";
        return template.query(sql, new EmployeeRowMapper());
    }

    public Employee findEmployee(int id)
    {
        String sql = "select * from employee_tbl where empid= ?";
        return template.queryForObject(sql, new EmployeeRowMapper(), id);
    }
}
