package com.emc.training.controller;

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

import com.emc.training.model.Customer;
import com.emc.training.model.CustomerList;

/**
 * Servlet implementation class CustomerContoller
 */
@WebServlet("/CustomerContoller")
public class CustomerContoller extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerContoller()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        int id = Integer.parseInt(request.getParameter("custId"));
        ServletContext servletCtx = getServletContext();
        ApplicationContext appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletCtx);
        CustomerList list = (CustomerList) appCtx.getBean("customerList");
        Customer cust = list.findCustomer(id);
        request.setAttribute("customer", cust);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customerDetails.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
        // TODO Auto-generated method stub
    }

}
