package client.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.emc.training.constructor.Customer;

public class TestWithXML
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-with-constructor.xml");
        Customer cust = (Customer) context.getBean("customer");

        System.out.println(cust.toString());
    }
}
