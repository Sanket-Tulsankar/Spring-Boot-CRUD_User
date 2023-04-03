package com.project1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.entities.UserEntities;
import com.project1.exceptionhandler.NotFoundException;
import com.project1.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<UserEntities> createUser(@RequestBody UserEntities user)throws Exception{
	 UserEntities createuser = this.userService.createuser(user);
		return new ResponseEntity<UserEntities>(createuser, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Optional<UserEntities>> getUserById(@PathVariable long id) throws NotFoundException{
		Optional<UserEntities> getUser = this.userService.GetUser(id);
		return new ResponseEntity<Optional<UserEntities>>(getUser,HttpStatus.OK);
	}
	
	//Revisit this API
	@PutMapping("/update/{id}")
	public ResponseEntity<UserEntities> UpdateUser(@RequestBody UserEntities user,@PathVariable long id) throws NotFoundException{
		UserEntities updateuser = this.userService.Updateuser(user,id);
		return new ResponseEntity<UserEntities>(updateuser,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<UserEntities>> getAllUsers() throws NotFoundException{
		List<UserEntities> all = this.userService.getAll();
		return new ResponseEntity<List<UserEntities>>(all,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id) throws NotFoundException{
		String deleteUser = this.userService.deleteUser(id);
		return new ResponseEntity<String>(deleteUser,HttpStatus.OK);
	}
	
}
