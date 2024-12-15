package com.saline.naton.user;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "Return list of users")})
    @GetMapping(value = "/users", produces = "application/json")
    @CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
    public ResponseEntity<Collection<UserNaton>> listUsers() {
        return ResponseEntity.ok((Collection<UserNaton>) this.userRepository.findAll());
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "Return User by ID")})
    @GetMapping(value = "/user/{id}", produces = "application/json")
    @CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
    public ResponseEntity<UserNaton> userById(@PathVariable Long id) {
        return ResponseEntity.ok(userRepository.findById(id).orElseGet(UserNaton::new));
    }

}
