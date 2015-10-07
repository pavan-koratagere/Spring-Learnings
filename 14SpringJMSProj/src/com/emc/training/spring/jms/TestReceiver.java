package com.emc.training.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class TestReceiver
{
   public static void main(String[] args)
   {
      ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
      JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
      Queue q = (Queue) ctx.getBean("destination");

      Message msg = template.receive(q);
      if (msg instanceof TextMessage)
      {
         TextMessage textMsg = (TextMessage) msg;
         try
         {
            System.out.println(textMsg.getText());
         } catch (JMSException e)
         {
            e.printStackTrace();
         }
      }
      System.out.println("message received");
   }
}
