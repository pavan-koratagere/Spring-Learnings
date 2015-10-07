package client.map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.emc.training.map.xml.Employee;

public class TestWithXML
{

    public static void main(String[] args)
    {
        ApplicationContext context = new FileSystemXmlApplicationContext(
                "C:\\workspace-sts-3.6.4\\FirstProj\\src\\beans-with-map-properties.xml");

        Employee emp = (Employee) context.getBean("employee");

        System.out.println(emp.toString());
    }

    public static void main1(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-with-map-properties.xml");

        Employee emp = (Employee) context.getBean("employee");

        System.out.println(emp.toString());
    }
}
