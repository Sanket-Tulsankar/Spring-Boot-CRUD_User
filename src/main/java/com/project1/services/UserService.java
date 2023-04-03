package com.project1.services;

import java.util.List;
import java.util.Optional;

import com.project1.entities.UserEntities;
import com.project1.exceptionhandler.NotFoundException;

public interface UserService {

	public UserEntities createuser(UserEntities user);
	
	public Optional<UserEntities> GetUser(long id) throws NotFoundException;
	
	//public Optional<Object> GetUser(long id) throws Exception;
	
	public UserEntities Updateuser(UserEntities user,long id) throws NotFoundException;
	
	public List<UserEntities> getAll() throws NotFoundException;
	
	public String deleteUser(long id) throws NotFoundException;
	
	public String getInfoByName(String fname,String lname) throws Exception;
}
