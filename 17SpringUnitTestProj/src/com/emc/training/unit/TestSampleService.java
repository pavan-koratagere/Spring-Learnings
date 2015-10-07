package com.emc.training.unit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestSampleService
{
   @Autowired
   private SampleService service;

   @Test
   public void getMessageSuccess()
   {
      Assert.assertEquals("Welcome Arjun", service.getMessage("Arjun"));
   }
}
