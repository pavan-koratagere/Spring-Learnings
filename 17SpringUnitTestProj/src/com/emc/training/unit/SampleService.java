package com.emc.training.unit;

import java.text.MessageFormat;

import org.springframework.stereotype.Component;

@Component
public class SampleService
{
   public String getMessage(String name)
   {
      return MessageFormat.format("Welcome {0}", name);
   }

}
