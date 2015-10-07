package com.emc.training.marshalling;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class TestMarshall
{
    public static void main(String[] args)
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(EmployeeList.class);
            Marshaller marshaller = context.createMarshaller();
            Employee emp1 = new Employee(1, "Rajkumar", "Manager");
            Employee emp2 = new Employee(2, "Raghav", "Manager");

            EmployeeList list = new EmployeeList();
            list.addEmployee(emp1);
            list.addEmployee(emp2);

            FileOutputStream out = new FileOutputStream("empList.xml");

            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(list, out);
            out.close();
            System.out.println("marshalling done");
        } catch (JAXBException | IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main1(String[] args)
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = context.createMarshaller();
            Employee emp = new Employee(1, "Rajkumar", "Manager");
            FileOutputStream out = new FileOutputStream("emp.xml");
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(emp, out);
            out.close();
            System.out.println("marshalling done");
        } catch (JAXBException | IOException e)
        {
            e.printStackTrace();
        }
    }
}
