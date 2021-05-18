package com.cg.onlineplantnursery.admin.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.admin.Entity.Admin;
import com.cg.onlineplantnursery.admin.Service.AdminService;
import com.cg.onlineplantnursery.admin.Service.AdminServiceImpl;
import com.cg.onlineplantnursery.customer.entity.Customer;

import lombok.Delegate;

@RestController
public class AdminController {

	@Autowired
	AdminService service;
	
	/************************************************************************************
	 * Method: addadmin 
	 * Description: It is used to add admin into admins table
	 * @param admin: admin's reference variable.
	 * @returns admin It add admin details/registration
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 
	 ************************************************************************************/
    @PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin)
	{
		return service.saveAdmin(admin);
	}
	
    /************************************************************************************
	 * Method: getAlladmins 
	 * Description: It is used to view all admins in admins table
	 * @returns admin It returns admin with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	
	 ************************************************************************************/
	@GetMapping("/getadmins")
	public List<Admin> findAllAdmins()
	{
		return service.getAdmins();
	}
	
	
	/************************************************************************************
	 * Method: Deleteadmin 
	 * Description: It is used to remove admin from admins table
	 * @param admin: int id
	 * @returns admin Itdelete admin details of specific idreturns admin with details
	 * @DELETEMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type. 
	 * 
	 ************************************************************************************/

	
	@DeleteMapping(path="/deleteadmin/{id}")
	
	public String  removeAdmin(@PathVariable int id)
	{
		
		service.deleteAdmin(id);
		return ("Admin with customerId ; "+id +"deleted successfully");
	}
	/************************************************************************************
	 * Method: updateadmin 
	 * Description: It is used to update admin into admins table
	 * @param admin: admin's reference variable.
	 * @returns admin it updates admin details and return with details(updated)
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	  
	 ************************************************************************************/
	
	@PutMapping(path="/updateadmin/{id}")
	public Admin updateAdmin(@PathVariable int id, @RequestBody Admin admin)
	{
		
		admin.setId(id);
		return (service.updateAdmin(admin));
	}
	
	/************************************************************************************
	 * Method: loginAdmin 
	 * Description: It is used to update admin into admins table
	 * @param admin: admin's reference variable.
	 * @returns admin It returns admin with details
	 * @GetMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	  
	 ************************************************************************************/
	@GetMapping(path="/loginbyAdmin/{username}/{password}")
	public Admin loginByAdmin(@PathVariable String username, @PathVariable String password)
	{
		
		return (service.loginByAdmin(username, password));
	}
	
	
	
}
