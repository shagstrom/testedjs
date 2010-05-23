package com.dreamchain.testedjs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = -4060739788760795254L;

	private Long id;
	private String name;
	private String email;
	private String address;

	@Id
	@GeneratedValue
	public Long getId() { return id;}
	public void setId(Long id) { this.id = id; }

	@Column
	@NotEmpty
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	@Column
	@Email
	@NotEmpty
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	@Column
	@NotNull
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
