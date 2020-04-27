package com.saline.naton.company;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyRepository repo;
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return list of companies") })
	@RequestMapping(value = "/companies", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
	@ResponseBody
	public ResponseEntity<Collection<Company>> listProducts() {
		return ResponseEntity.ok((Collection<Company>)this.repo.findAll());
	}
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return Company by ID") })
	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
	@ResponseBody
	public ResponseEntity<Company> companyById(@PathVariable Long id) {
		Optional<Company> optCompany = this.repo.findById(id);
		if(optCompany.isPresent())
			return ResponseEntity.ok(optCompany.get());
		else
			return ResponseEntity.ok(new Company());
	}	

}
