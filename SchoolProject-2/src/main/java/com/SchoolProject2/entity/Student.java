package com.SchoolProject2.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data 
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class Student {
	
	@Id
	@GeneratedValue
	private int sid;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Student Name cannot be blank")
	private String sfname;
	
	@Column(length=25)
	private String slname;
	
	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "Student phone cannot be null")
	private long sphone;

	@Column(length=25, nullable = false, unique = true)
	@NotBlank(message = "Student Email cannot be blank")
	@Email(message = "Email is incorrect")
	private String semail;
	
	@Column(length=50, nullable = false)
	@NotBlank(message = "Student education cannot be blank")
	private String sedu;
	
	@Column(length=50, nullable = false)
	@NotBlank(message = "Student Address cannot be blank")
	private String sadd;

}

