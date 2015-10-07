package com.emc.training.jaxrs;

import java.text.MessageFormat;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "id", "name", "designation" })
public class Employee
{
   private int id;
   private String name;
   private String designation;

   public Employee()
   {
      super();
   }

   public Employee(int id, String name, String designation)
   {
      super();
      this.id = id;
      this.name = name;
      this.designation = designation;
   }

   public int getId()
   {
      return this.id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getName()
   {
      return this.name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getDesignation()
   {
      return this.designation;
   }

   public void setDesignation(String designation)
   {
      this.designation = designation;
   }

   @Override
   public String toString()
   {
      return MessageFormat.format("\nEmployee [id={0}, name={1}, designation={2}]", this.id, this.name,
            this.designation);
   }

}
