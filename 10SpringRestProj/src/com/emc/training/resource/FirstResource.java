package com.emc.training.resource;

import java.text.MessageFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.training.jaxb.Employee;

@Controller
@RequestMapping("/first")
public class FirstResource
{

    @RequestMapping(produces = "text/html", method = RequestMethod.GET)
    public @ResponseBody String getMessage()
    {
        return "<h2>Welcome to REST!!!!</h2>";
    }

    @RequestMapping(value = "/{name}", produces = "text/html", method = RequestMethod.GET)
    public @ResponseBody String getMessage(@PathVariable("name") String strName)
    {
        return MessageFormat.format("<h2>Welcome to REST!!!! {0}</h2>", strName);
    }

    @RequestMapping(value = "/{fname}/{lname}", produces = "text/html", method = RequestMethod.GET)
    public @ResponseBody String getMessage(@PathVariable("fname") String fname, @PathVariable("lname") String lname)
    {
        return MessageFormat.format("<h2>Welcome to REST!!!! - {1}, {0}.</h2>", fname, lname);
    }

    @RequestMapping(value = "/emp", produces = "text/xml", method = RequestMethod.GET)
    public @ResponseBody Employee getEmployee()
    {
        return new Employee(1, "Adam", "Manager");
    }

    @RequestMapping(value = "/employee", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody Employee getEmployeeData()
    {
        return new Employee(1, "Chris", "Manager");
    }
}
