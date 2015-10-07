package com.emc.training.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee
{

    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-jdbc.xml");
        EmployeeDAO dao = ctx.getBean(EmployeeDAO.class);

        // insert operation
        // dao.addEmployee(10, "Aravind", "SSE", 3000);
        // dao.addEmployee(9, "Rajiv", "SSE", 3000);
        // dao.addEmployee(11, "Raghav", "SSE", 3000);
        // dao.addEmployee(12, "Rajesh", "SSE", 3000);
        // dao.addEmployee(13, "Sumesh", "SSE", 3000);

        System.out.println(dao.getAllEmployees());
        System.out.println("-------------------");
        System.out.println(dao.findEmployee(7));
    }

}
