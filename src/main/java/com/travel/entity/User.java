package com.travel.entity;


import java.time.Instant;

import jakarta.persistence.*;



@Entity
@Table(name = "users")

public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column
    private String name;

    @Column
    private String email;
@Column
    private String password; // store hashed in production (we keep plain for simplicity here)


public User(Long id, String name, String email, String password) {
	
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
}

public User() {
	
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password ;
}

public void setCreatedAt(Instant now) {
	// TODO Auto-generated method stub
	
}


}
   

