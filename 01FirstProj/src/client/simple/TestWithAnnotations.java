package client.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.emc.training.simple.annotations.Employee;

public class TestWithAnnotations
{
    public static void main(String[] args)
    {
        ApplicationContext context = new FileSystemXmlApplicationContext(
                "C:\\workspace-sts-3.6.4\\FirstProj\\src\\simple-beans-annotations.xml");
        Employee emp1 = (Employee) context.getBean("emp");
        System.out.println(emp1.toString());

        Employee emp2 = (Employee) context.getBean("emp");
        System.out.println(emp2.toString());

        System.out.println(emp1 == emp2);

    }

}
