package com.emc.training.resource;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.training.jaxb.Employee;
import com.emc.training.jaxb.EmployeeList;
import com.emc.training.jaxb.Employees;

@Controller
@RequestMapping("/emp")
public class EmployeeResource
{
   @Autowired
   private EmployeeList empList;

   @RequestMapping(method = RequestMethod.GET, produces = { "application/xml", "application/json" })
   public @ResponseBody Employees getAllEmployees()
   {
      return this.empList.getAllEmployees();
   }

   @RequestMapping(value = "/{empId}", method = RequestMethod.GET, produces = { "application/xml", "application/json" })
   public @ResponseBody Employee getEmployee(@PathVariable("empId") int id)
   {
      return this.empList.findEmployee(id);
   }

   @RequestMapping(method = RequestMethod.POST, produces = "text/plain", consumes = { "application/xml",
         "application/json" })
   public @ResponseBody String addEmployee(@RequestBody Employee e)
   {
      int id = this.empList.addEmployee(e);
      return MessageFormat.format("Employee with {0} successfully added", id);
   }

   @RequestMapping(value = "/{empId}", method = RequestMethod.PUT, produces = "text/plain", consumes = {
         "application/xml", "application/json" })
   public @ResponseBody String updateEmployee(@RequestBody Employee e, @PathVariable("empId") int id)
   {
      this.empList.modifyEmployee(id, e);
      return MessageFormat.format("Employee with {0} successfully updated", id);
   }

   @RequestMapping(value = "/{empId}", method = RequestMethod.DELETE, produces = "text/plain")
   public @ResponseBody String removeEmployee(@PathVariable("empId") int id)
   {
      this.empList.removeEmployee(id);
      return MessageFormat.format("Employee with {0} successfully removed", id);
   }
}
