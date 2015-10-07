package com.emc.training.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class TestSender
{
   public static void main(String[] args)
   {
      ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
      JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
      Queue q = (Queue) ctx.getBean("destination");
      MessageCreator creator = new MessageCreator()
      {
         @Override
         public Message createMessage(Session session) throws JMSException
         {
            TextMessage msg = session.createTextMessage();
            msg.setText("this is a sample message through spring jms");
            return msg;
         }
      };
      template.send(q, creator);
      System.out.println("message sent");
   }
}
