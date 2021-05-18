package com.cg.onlineplantnursery.admin.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.onlineplantnursery.admin.Entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Query("SELECT ud FROM admin_tbl ud WHERE ud.username=?1 AND ud.password=?2 ")
	Optional<Admin> findByUsernameAndPassword1(String username, String password);

}
