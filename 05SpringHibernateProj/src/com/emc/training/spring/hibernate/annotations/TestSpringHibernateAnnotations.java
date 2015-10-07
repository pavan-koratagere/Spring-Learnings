package com.emc.training.spring.hibernate.annotations;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Hariprasad Manchi
 *
 */
public class TestSpringHibernateAnnotations
{

    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        EmployeeDAO dao = (EmployeeDAO) ctx.getBean("employeeDAO");
        dao.addEmployee(new Employee(101, "Sachin", 1000));
        dao.addEmployee(new Employee(102, "Anil", 2000));
        dao.addEmployee(new Employee(103, "Karthik", 3000));

        List<Employee> list = dao.getAllEmployees();
        System.out.println(list);

    }
}
