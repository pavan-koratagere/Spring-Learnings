package com.emc.training.jaxb;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

@Component
public class EmployeeList
{
   private Map<Integer, Employee> list = new TreeMap<Integer, Employee>();

   public EmployeeList()
   {
      super();
      list.put(1, new Employee(1, "Adam", "Developer"));
      list.put(2, new Employee(2, "Bob", "Developer"));
      list.put(3, new Employee(3, "Charles", "Developer"));
      list.put(4, new Employee(4, "David", "Developer"));
   }

   public int addEmployee(Employee e)
   {
      int nextId = list.get(list.size()).getId() + 1;
      e.setId(nextId);
      list.put(nextId, e);
      return nextId;
   }

   public void modifyEmployee(int id, Employee e)
   {
      Employee emp = list.get(id);
      emp.setName(e.getName());
      emp.setDesignation(e.getDesignation());
   }

   public Employees getAllEmployees()
   {
      return new Employees(new ArrayList<Employee>(list.values()));
   }

   public Employee findEmployee(int id)
   {
      return list.get(id);
   }

   public void removeEmployee(int id)
   {
      list.remove(id);
   }

}
