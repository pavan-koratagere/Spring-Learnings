package com.emc.training.hibernate.xml;

import java.text.MessageFormat;
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
public class TestHibernate
{
    public static void main(String[] args)
    {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

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

    public static void main1(String[] args)
    {
        Customer c1 = new Customer(1, "Rahul", 3000);
        Customer c2 = new Customer(2, "Ramesh", 1500);
        Customer c3 = new Customer(3, "Suresh", 1000);
        Customer c4 = new Customer(4, "Gopal", 2000);

        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

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
