package com.emc.training.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController
{
    @RequestMapping("/first.req")
    public String handleRequest(Map<String, Object> model)
    {
        // model name is "message"; use this in jsp
        model.put("message", "Welcome to Spring MVC");
        return "showMessage"; // configured through view resolver
    }
}
