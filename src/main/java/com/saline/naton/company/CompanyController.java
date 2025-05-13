package com.saline.naton.company;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
public class CompanyController {
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Return list of companies")})
    @GetMapping(value = "/companies", produces = "application/json")
    @CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
    public ResponseEntity<Collection<Company>> listProducts() {
        return ResponseEntity.ok((Collection<Company>) this.companyRepository.findAll());
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Return Company by ID")})
    @GetMapping(value = "/company/{id}", produces = "application/json")
    @CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
    public ResponseEntity<Company> companyById(@PathVariable Long id) {
        Optional<Company> optCompany = this.companyRepository.findById(id);
        if (optCompany.isPresent())
            return ResponseEntity.ok(optCompany.get());
        else
            return ResponseEntity.ok(new Company());
    }

}
