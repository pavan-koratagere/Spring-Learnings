package com.emc.training.unmarshalling;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class TestUnmarshall
{
    public static void main1(String[] args)
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            FileInputStream fis = new FileInputStream("emp.xml");

            Employee e = (Employee) unmarshaller.unmarshal(fis);

            System.out.println(e.toString());
            System.out.println("unmarshalling done");
        } catch (JAXBException | IOException e)
        {
            e.printStackTrace();
        }
    }
}
