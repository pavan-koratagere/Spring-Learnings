package com.emc.training.controller;

import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emc.training.model.Customer;
import com.emc.training.model.CustomerList;

@Controller
public class CustomerContoller extends HttpServlet
{
    @Autowired
    private CustomerList list = new CustomerList();

    @RequestMapping("/cust.req")
    public String handleRequest(Map<String, Object> model, @RequestParam("custId") int custId)
    {
        Customer cust = list.findCustomer(custId);

        // model name is "message"; use this in jsp
        model.put("customer", cust);
        return "customerDetails";
    }

}
