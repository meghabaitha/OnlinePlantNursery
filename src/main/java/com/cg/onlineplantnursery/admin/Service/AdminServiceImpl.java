package com.cg.onlineplantnursery.admin.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.admin.Entity.Admin;
import com.cg.onlineplantnursery.admin.Repository.AdminRepository;
import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.exception.AdminNotFoundException;
import com.cg.onlineplantnursery.exception.CustomerNotFoundException;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository repo;
	private Logger logger =LoggerFactory.getLogger(AdminServiceImpl.class);
	
	
	@Override
	public Admin saveAdmin(Admin admin) {
		
		logger.info("***************Account Created****************");
		Admin admin1 = repo.save(admin);
		return admin1;
	}

	@Override
	public List<Admin> getAdmins()
	{
		logger.info("**************Account for all Admins****************");
		return repo.findAll();	
	}

	@Override
	public void deleteAdmin(int id) {
		logger.info("***************Delete Account for Id****************");
		
		Optional<Admin>op = repo.findById(id);
		Admin admin=null;
		if(op.isPresent())
		{
			repo.deleteById(id);
		}
			
		else
		{
			throw new AdminNotFoundException("Admin not Found with given Id");
		}
		
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		logger.info("***************Updating Account****************");
		Admin existingadmin= repo.findById(admin.getId()).orElse(null);
		existingadmin.setAdminname(admin.getAdminname());
		existingadmin.setPassword(admin.getPassword());
		existingadmin.setUsername(admin.getUsername());
		
		return repo.save(existingadmin);
	}

	@Override
	public Admin loginByAdmin(String username, String password) {
		
		logger.info("***************Login into Account****************");
		
        Admin admin = null;
		
		Optional<Admin>op = repo.findByUsernameAndPassword1(username,password);
		if(op.isPresent())
		{
			admin= op.get();
		}
			
		else
		{
			throw new AdminNotFoundException("Admin not Found with given Id");
		}
		return admin;
		
	}
	
	
}
