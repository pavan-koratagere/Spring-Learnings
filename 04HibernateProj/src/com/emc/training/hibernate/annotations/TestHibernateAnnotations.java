package com.emc.training.hibernate.annotations;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * 
 * @author Hariprasad Manchi
 *
 */
public class TestHibernateAnnotations
{
    public static void main1(String[] args)
    {
        Configuration conf = new Configuration().configure("hibernate-with-annotations.xml");

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        // List<Customer> list = session.createQuery("from Customer").list();

        String hqlAll = "select c from Customer as c";
        List<Customer> list = session.createQuery(hqlAll).list();
        System.out.println(list);

        String hqlSpecificColumn = "select c.customerId, c.balance from Customer as c";
        List<Object[]> customerData = session.createQuery(hqlSpecificColumn).list();
        for (Object[] data : customerData)
        {
            System.out.println(MessageFormat.format("CustomerID: {0}, Balance:{1}", data[0], data[1]));
        }

        session.close();
        factory.close();
    }

    public static void main(String[] args)
    {
        Customer c1 = new Customer(1, "Rahul", 3000);
        Customer c2 = new Customer(2, "Ramesh", 1500);
        Customer c3 = new Customer(3, "Suresh", 1000);
        Customer c4 = new Customer(4, "Gopal", 2000);

        Address a1 = new Address(101, "Hebbal", "Bangalore");
        Address a2 = new Address(102, "Punjakutta", "Hyderabad");
        Address a3 = new Address(103, "Salt Lake", "Kolkatta");
        Address a4 = new Address(104, "Bandra East", "Mumbai");
        Address a5 = new Address(105, "Bandra North", "Mumbai");
        Address a6 = new Address(106, "Bandra West", "Mumbai");

        List<Address> list1 = new ArrayList<Address>();
        list1.add(a1);
        list1.add(a2);

        List<Address> list2 = new ArrayList<Address>();
        list2.add(a3);
        list2.add(a4);

        c1.setAddresses(list1);
        c2.setAddresses(list2);
        c3.setAddresses(new ArrayList<Address>(Arrays.asList(a5)));
        c4.setAddresses(new ArrayList<Address>(Arrays.asList(a6)));

        Configuration conf = new Configuration().configure("hibernate-with-annotations.xml");

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(c1);
        session.save(c2);
        session.save(c3);
        session.save(c4);
        tx.commit();

        session.close();
        factory.close();
    }
}
