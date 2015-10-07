package client.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.emc.training.simple.xml.Employee;

public class TestWithXML
{
    public static void main(String[] args)
    {
        ApplicationContext context = new FileSystemXmlApplicationContext(
                "C:\\workspace-sts-3.6.4\\FirstProj\\src\\simple-beans.xml");
        Employee emp1 = (Employee) context.getBean("employee");
        System.out.println(emp1.toString());

        Employee emp2 = (Employee) context.getBean("employee");
        System.out.println(emp2.toString());

        System.out.println(emp1 == emp2);

    }

    public static void main1(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Employee emp = (Employee) context.getBean("employee");

        System.out.println(emp.toString());
    }
}
