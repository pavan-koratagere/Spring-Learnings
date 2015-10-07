package com.emc.training.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOPXML
{

    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-aop-with-xml.xml");
        Instrumentalist i = (Instrumentalist) ctx.getBean("instrumentalist");
        i.play();
        i.play(3);
        i.play("my favorite song");

    }
}
