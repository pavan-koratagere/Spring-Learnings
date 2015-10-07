package com.emc.training.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employees
{
   private List<Employee> list = new ArrayList<Employee>();

   public Employees()
   {
   }

   public Employees(List<Employee> list)
   {
      super();
      this.list = list;
   }

   @XmlElementRef
   public List<Employee> getList()
   {
      return this.list;
   }

   public void setList(List<Employee> list)
   {
      this.list = list;
   }

   public void addEmployee(Employee e)
   {
      this.list.add(e);
   }

   @Override
   public String toString()
   {
      return "Employees [list=" + this.list + "]";
   }

}
