package com.emc.training.jms;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Sender
{
   public static void main(String[] args)
   {
      Properties env = new Properties();
      env.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
      // jnp is specialized RMI-IIOP protocol; jnp stands for jboss naming protocol
      env.setProperty(Context.PROVIDER_URL, "jnp://localhost:1099");

      try
      {
         Context ctx = new InitialContext(env);
         // from connection-factories-service.xml
         /**
          * <pre>
          * C:\jboss-5.1.0.GA\server\default\deploy\messaging\connection-factories-service.xml
          *
          * <attribute name="JNDIBindings">
          *          <bindings>
          *             <binding>/ConnectionFactory</binding>
          *             <binding>/XAConnectionFactory</binding>
          *             <binding>java:/ConnectionFactory</binding>
          *             <binding>java:/XAConnectionFactory</binding>
          *          </bindings>
          *       </attribute>
          * </pre>
          */
         QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("java:/ConnectionFactory");

         // from destinations-service.xml
         /**
          * <pre>
          * C:\jboss-5.1.0.GA\server\default\deploy\messaging\destinations-service.xml
          *
          * <mbean code="org.jboss.jms.server.destination.QueueService"
          *       name="jboss.messaging.destination:service=Queue,name=TrainingQueue"
          *       xmbean-dd="xmdesc/Queue-xmbean.xml">
          *       <depends optional-attribute-name="ServerPeer">jboss.messaging:service=ServerPeer</depends>
          *       <depends>jboss.messaging:service=PostOffice</depends>
          *    </mbean>
          * </pre>
          */
         Queue queue = (Queue) ctx.lookup("queue/TrainingQueue");

         QueueConnection conn = factory.createQueueConnection();
         QueueSession session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
         QueueSender sender = session.createSender(queue);
         TextMessage message = session.createTextMessage();
         message.setText("This is a first message in the queue");

         sender.send(message);
         conn.close();
         System.out.println("message is sent");
      } catch (NamingException | JMSException e)
      {
         e.printStackTrace();
      }
   }
}
