package com.emc.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

public class TestRest
{
    public static void main(String[] args)
    {
        String url = "http://localhost:8080/10SpringRestProj/rest/first/Hariprasad";
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        RestTemplate rt = (RestTemplate) ctx.getBean("template");

        String msg = rt.getForObject(url, String.class);
        System.out.println(msg);
    }
}
