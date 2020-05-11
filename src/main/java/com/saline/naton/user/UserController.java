package com.saline.naton.user;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return list of users") })
	@GetMapping(value = "/users", produces = "application/json")
	@CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
	@ResponseBody
	public ResponseEntity<Collection<UserNaton>> listUsers() {
		return ResponseEntity.ok((Collection<UserNaton>)this.repo.findAll());
	}
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return User by ID") })
	@GetMapping(value = "/user/{id}", produces = "application/json")
	@CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
	@ResponseBody
	public ResponseEntity<UserNaton> userById(@PathVariable Long id) {
		Optional<UserNaton> optUser = this.repo.findById(id);
		if(optUser.isPresent())
			return ResponseEntity.ok(optUser.get());
		else
			return ResponseEntity.ok(new UserNaton());
	}

}
