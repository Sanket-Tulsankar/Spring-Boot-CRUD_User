package com.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.entities.UserEntities;
import com.project1.exceptionhandler.NotFoundException;
import com.project1.repository.AuthInfoRepository;
import com.project1.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AuthInfoRepository authRepo;
	
	
	//Add new User
	@Override
	public UserEntities createuser(UserEntities user) {
		UserEntities userEntities = this.userRepo.save(user);
	//	System.out.println(userEntities);
		return userEntities;
	}

	//get user by id
	@Override
	public Optional<UserEntities> GetUser(long id) throws NotFoundException {
		Optional<UserEntities> findById = this.userRepo.findById(id);
		//Optional<AuthenticationInfo> findById2 = this.authRepo.findById(id);
		this.userRepo.findById(id).orElseThrow(()-> new NotFoundException("User not found with id "+id+" not found, Please enter the correct id"));
		//Object obj=findById+findById2;
		return findById;
		
	}

	//update user by id
	@Override
	public UserEntities Updateuser(UserEntities user,long id)
			throws NotFoundException {
		this.userRepo.findById(id).orElseThrow(
				()-> new NotFoundException("User with Id "
								+id+" not found, Please enter the correct id"));	
		user.setId(id);
		UserEntities userEntities = this.userRepo.save(user);
		return userEntities;
	}

	//get all users
	@Override
	public List<UserEntities> getAll() throws NotFoundException{
		List<UserEntities> list = this.userRepo.findAll();
		if(list.isEmpty()) {
			throw new NotFoundException("No users found");
		}
		return list;
	}

	//delete user by id
	@Override
	public String deleteUser(long id) throws NotFoundException{
		this.userRepo.findById(id).orElseThrow(()->new NotFoundException("User with id "+id+" not found, Please enter the correct id"));
		this.userRepo.deleteById(id);
		return "User deleted successfully";
	}

	
	//get user by name
	@Override
	public String getInfoByName(String fname,String lname) {
		UserEntities findByFname = this.userRepo.findByFname(fname);
		boolean equals = findByFname.getLname().equals(lname);
		if(equals)
			return "TRUE";
		else
			return "FALSE";
	}

}
