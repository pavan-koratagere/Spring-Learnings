package com.emc.training.jms;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestReceiver
{
   public static void main(String[] args)
   {
      Properties env = new Properties();
      env.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
      env.setProperty(Context.PROVIDER_URL, "jnp://localhost:1099");

      try
      {
         Context ctx = new InitialContext(env);
         QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("java:/ConnectionFactory");
         Queue queue = (Queue) ctx.lookup("queue/TrainingQueue");
         QueueConnection conn = factory.createQueueConnection();
         QueueSession session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);

         QueueReceiver receiver = session.createReceiver(queue);
         receiver.setMessageListener(new MyMessageListener());
         conn.start();
         System.out.println("waiting for response");
         Thread.sleep(5 * 60 * 1000);
      } catch (NamingException | JMSException | InterruptedException e)
      {
         e.printStackTrace();
      }
   }
}
