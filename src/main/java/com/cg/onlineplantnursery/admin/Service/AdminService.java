package com.cg.onlineplantnursery.admin.Service;

import java.util.List;

import com.cg.onlineplantnursery.admin.Entity.Admin;
import com.cg.onlineplantnursery.customer.entity.Customer;


public interface AdminService {
	
	 public Admin saveAdmin(Admin admin);
	 public List<Admin> getAdmins();
	 public void deleteAdmin(int id);
	 public Admin updateAdmin(Admin admin);
	 public Admin loginByAdmin(String username,String password);

}
