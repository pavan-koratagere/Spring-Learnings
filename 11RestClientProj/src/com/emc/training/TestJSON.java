package com.emc.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

public class TestJSON
{
    public static void main(String[] args)
    {
        String url = "http://localhost:8080/10SpringRestProj/rest/first/employee";
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        RestTemplate rt = (RestTemplate) ctx.getBean("template");

        Employee emp = (Employee) rt.getForObject(url, Employee.class);
        System.out.println(emp);

        String xml = rt.getForObject(url, String.class);
        System.out.println(xml);
    }
}
