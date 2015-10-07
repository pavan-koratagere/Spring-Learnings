package com.emc.training.jaxrs;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TestJaxRS
{
   public static void main(String[] args)
   {
      testPostRequest();
      testGetRequest();
   }

   private static void testPostRequest()
   {
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target("http://localhost:8080/10SpringRestProj/rest/emp");

      Employee emp1 = new Employee();
      emp1.setName("Rajesh");
      emp1.setDesignation("Supervisor");

      Response response = target.request(MediaType.APPLICATION_XML).accept(MediaType.TEXT_PLAIN).post(Entity.xml(emp1));
      System.out.println(response.readEntity(String.class));

      Employee emp2 = new Employee();
      emp2.setName("Sumesh");
      emp2.setDesignation("Supervisor Lead");

      response = target.request(MediaType.APPLICATION_XML).accept(MediaType.TEXT_PLAIN).post(Entity.xml(emp2));
      System.out.println(response.readEntity(String.class));

   }

   private static void testGetRequest()
   {
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target("http://localhost:8080/10SpringRestProj/rest/emp");
      Employees list = target.request().get(Employees.class);
      System.out.println(list);
   }
}
