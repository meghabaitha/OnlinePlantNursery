package com.cg.onlineplantnursery.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.exception.CustomerNotFoundException;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT ud FROM CUSTOMER_TBL ud WHERE ud.username=?1 AND ud.password=?2 ")
	Optional<Customer> findByUsernameAndPassword(String username, String password);

}
