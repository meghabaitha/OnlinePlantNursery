package com.cg.onlineplantnursery.customer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name="CUSTOMER_TBL")
@Table(name="CUSTOMER_TBL")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE2")
	@SequenceGenerator(name="SEQUENCE2", sequenceName = "SEQUENCE2",allocationSize = 1,initialValue = 101)
	private Integer customerId;
	
	@NotBlank
	@Size(min=2, max=25)
	private String customerName;
	
	private String customerEmail;
	@NotBlank
	@Size(min=1, max=25)
	@Pattern(regexp = "[a-zA-Z]*")
	private String username;
	@NotBlank
	@Size(min=6, max=25)
	private String password;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="addressId")
	private Address address;
	public Customer()
	{
		super();
	}
	
	public Customer(Integer customerId, @NotBlank @Size(min = 2, max = 25) String customerName, String customerEmail,
			@NotBlank @Size(min = 1, max = 25) String username, @NotBlank @Size(min = 6, max = 25) String password,
			Address address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.username = username;
		this.password = password;
		this.address = address;
	}

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

}
