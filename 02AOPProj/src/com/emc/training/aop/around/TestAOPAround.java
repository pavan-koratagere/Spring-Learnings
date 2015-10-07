package com.emc.training.aop.around;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Hariprasad Manchi
 *
 */
public class TestAOPAround
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-aop-around.xml");
        MyNumber num = ctx.getBean(MyNumber.class);
        System.out.println(num.add(10, 10));
    }
}
