package client.map;

import java.util.Map;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.emc.training.map.xml.Address;
import com.emc.training.map.xml.Employee;

public class TestWithMapAndProperties
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-with-map-properties.xml");
        Employee emp1 = (Employee) context.getBean("employee");
        System.out.println(emp1.toString());

        Map<String, Address> map = emp1.getMap();
        Properties remarks = emp1.getRemarks();
        remarks.list(System.out);
    }
}
