package com.emc.training.aop.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployeeAOP
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-aop-employee.xml");
        EmployeeManager manager = context.getBean(EmployeeManager.class);

        manager.getEmployeeById(1);
        manager.createEmployee(new EmployeeDTO());
    }
}
