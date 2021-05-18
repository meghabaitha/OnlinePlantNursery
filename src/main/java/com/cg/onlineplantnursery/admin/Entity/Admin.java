package com.cg.onlineplantnursery.admin.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name="admin_tbl")
@Table(name="admin_tbl")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE8")
	@SequenceGenerator(name="SEQUENCE8", sequenceName = "SEQUENCE8",allocationSize = 1,initialValue = 2021)
	private int id;
	
	@NotBlank
	@Size(min=8, max=25)
	private String Adminname;
	@NotBlank
	@Size(min=10, max=64)
	@Pattern(regexp = "[a-zA-Z]*")
	private String username;
	
	@NotBlank
	@Size(min=8, max= 16)
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$")
	private String password;
	public Admin() {
		super();
	}
	
	public Admin(int id, @NotBlank @Size(min = 8, max = 25) String adminname,
			@NotBlank @Size(min = 10, max = 64) String username, @NotBlank @Size(min = 8, max = 16) String password) {
		super();
		this.id = id;
		Adminname = adminname;
		this.username = username;
		this.password = password;
	}



	public String getAdminname() {
		return Adminname;
	}
	public void setAdminname(String adminname) {
		Adminname = adminname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Admin [id=" + id + ", Adminname=" + Adminname + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
}
