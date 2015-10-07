package com.emc.training.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOPAnnotations
{

    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-aop-with-annotations.xml");
        Instrumentalist i = (Instrumentalist) ctx.getBean("instrumentalist");
        i.play();
        // i.play(3);
        // i.play("my favorite song");

    }
}
