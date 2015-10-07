package com.emc.training.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener
{
   @Override
   public void onMessage(Message msg)
   {
      if (msg instanceof TextMessage)
      {
         TextMessage txtMessage = (TextMessage) msg;
         try
         {
            System.out.println("Received Msg: " + txtMessage.getText());
         } catch (JMSException e)
         {
            e.printStackTrace();
         }
      }
   }
}
