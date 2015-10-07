package com.emc.training.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class EmployeeRowMapper implements ParameterizedRowMapper<Employee>
{
    @Override
    public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException
    {
        // Employee emp = new Employee();
        // emp.setId(15);
        // emp.setName("Prasad");
        // emp.setDesignation("Team Lead");
        // emp.setSalary(3500);

        Employee emp = new Employee();
        emp.setId(rs.getInt(1));
        emp.setName(rs.getString(2));
        emp.setDesignation(rs.getString(3));
        emp.setSalary(rs.getDouble(4));

        return emp;
    }
}
