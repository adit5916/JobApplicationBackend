package com.capgemini.JobApplication.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.capgemini.JobApplication.entity.enums.UserRole;
import com.capgemini.JobApplication.entity.enums.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name", length = 255, nullable = false)
	private String first_name;
	
	@Column(name = "last_name", length = 255, nullable = false)
	private String last_name;
	
	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email;
	
	@Column(name = "phone", length = 10, nullable = false, unique = true)
	private String number;
	
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false, columnDefinition = "ENUM('jobseeker', 'employer','admin) DEFAULT 'jobseeker'")
	private UserRole user_role = UserRole.jobseeker;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_status", nullable = false, columnDefinition = "ENUM('active', 'inactive') DEFAULT 'active'")
	private UserStatus user_status = UserStatus.active;
	
	@Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(Long id, String first_name, String last_name, String email, String number, String password,
			UserRole user_role, UserStatus user_status, LocalDate dateCreated) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.number = number;
		this.password = password;
		this.user_role = user_role;
		this.user_status = user_status;
		this.dateCreated = dateCreated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUser_role() {
		return user_role;
	}

	public void setUser_role(UserRole user_role) {
		this.user_role = user_role;
	}

	public UserStatus getUser_status() {
		return user_status;
	}

	public void setUser_status(UserStatus user_status) {
		this.user_status = user_status;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(user_role.name()));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	
	
}
