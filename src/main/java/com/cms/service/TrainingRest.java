package com.cms.service;

//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cms.connection.DbConnection;
import com.cms.model.Cart;
import com.cms.model.DBStatus;
import com.cms.model.Employee;
import com.cms.model.Menu_Item;
@Path("cms")

public class TrainingRest {
	public DbConnection db = new DbConnection();
	 
	
	 
	 @GET
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	 @Path("login/{username}/{password}") //http://localhost:8080/CMS/api/cms/login/49104/ankitha104
	 public List<Employee> getMembers(@PathParam("username") String username, @PathParam("password") String password){
	 EmployeeService es = new EmployeeService();
	 return es.Login(username, password);
	 }
	 
	 @GET
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	 @Path("loginV/{username}/{password}") //http://localhost:8080/CMS/api/cms/login/49104/ankitha104
	 public DBStatus getMembersV(@PathParam("username") String username, @PathParam("password") String password){
	 VendorService vs = new VendorService();
	 return vs.Login(username, password);
	 }

	 @GET
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	 @Path("menu") //http://localhost:8080/CMS/api/cms/menu
	 public List<Menu_Item> getMenu(){
	 EmployeeService es = new EmployeeService();
	 return es.showMenu();
	 }
	 
	 @POST
	 @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	 @Path("order/addToCart/{userId}") //http://localhost:8080/CMS/api/cms/order/addToCart/49104
	 public boolean addToCart(Menu_Item item, @PathParam("userId") String userId){
	 EmployeeService es = new EmployeeService();
	 return es.addToCart(item, userId);
	 }
	 
	 @GET
	 @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	 @Path("getCart/{userId}") //http://localhost:8080/CMS/api/cms/order/addToCart/49104
	 public List<Cart> viewCart(@PathParam("userId") int userId){
		 System.out.println(userId);
	 EmployeeService es = new EmployeeService();
	 return es.viewCart(userId);
	 }
	 
	 @POST
	 @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	 @Path("deleteItem/{userId}") //http://localhost:8080/CMS/api/cms/order/addToCart/49104
	 public List<Cart> deleteItem(int item, @PathParam("userId") String userId){
		 System.out.println(item+""+userId);
	 EmployeeService es = new EmployeeService();
	 return es.deleteItem(item, userId);
	 }
}
