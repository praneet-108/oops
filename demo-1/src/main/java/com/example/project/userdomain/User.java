package com.example.project.userdomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class User{
@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String username;
    public String email;
    public int age;
    public String userpassword;
    
 
    public User() {
}
 
public User( String name,String username, String email,int age,String userpassword) {
this.name = name;
this.username=username;
this.email =email;
this.age = age;
this.userpassword = userpassword;
}

public Long getId() {
	return id;
}

/*public void setId(Long id) {
	this.id = id;
}*/

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getUserpassword() {
	return userpassword;
}

public void setUserpassword(String userpassword) {
	this.userpassword = userpassword;
}
 


/*@Override
public String toString() {
return "Employee [id=" + id + ", name=" + name + ",userName=" + userName + ",emailId ="+ emailId + ",age= " + age + "]";
}*/
}
