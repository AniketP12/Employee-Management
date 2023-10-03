package com.qsp.springbootemployee.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name can't be Blank")
	@NotNull(message = "Name can't be Null")
	private String name;
	@Column(unique = true)
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phone;
	@NotBlank(message = "Address can't be blank")
	@NotNull(message = "Address can't be null")
	private String address;
	@Column(unique = true)
	@NotBlank(message = "Email can't be blank")
	@NotNull(message = "Email can't be null")
	@Email(regexp = "[a-z0-9._%$+-]+@[a-z0-9]+\\.[a-z]{2,3}" ,message = "invalid email")
	private String email;
	@Min(value = 1)
	private double salary;
	private char grade;
	
	
}
