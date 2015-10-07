package com.emc.training.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.emc.training.web.Customer;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ServletContext servletContext = getServletContext();
        ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        Customer cust1 = (Customer) appContext.getBean("customer1");
        Customer cust2 = (Customer) appContext.getBean("customer2");

        // since the beans are scoped for request, we need not set the objects into request; they are available for jsp
        // request.setAttribute("cust1", cust1);
        // request.setAttribute("cust2", cust2);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/showCustomers.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
    }

}
