package com.saline.naton.product;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
public class PackageTypeController {

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return list of products") })
	@GetMapping(value = "/packagetypes", produces = "application/json")
	@CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
	public ResponseEntity<Collection<PackageTypeEnum>> listPackageType() {
		return ResponseEntity.ok(Arrays.asList(PackageTypeEnum.values()));
	}
}
