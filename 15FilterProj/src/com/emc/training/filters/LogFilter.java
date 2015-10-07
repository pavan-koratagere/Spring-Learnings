package com.emc.training.filters;

import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter
{
   private FilterConfig config;

   @Override
   public void destroy()
   {
   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
   ServletException
   {
      String uri = ((HttpServletRequest) request).getRequestURI();
      Date now = new Date();
      DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
      ServletContext context = config.getServletContext();
      context.log(MessageFormat.format("request for {0} is made at {1}", uri, sdf.format(now)));
      chain.doFilter(request, response);
   }

   @Override
   public void init(FilterConfig conf) throws ServletException
   {
      this.config = conf;
   }

}
