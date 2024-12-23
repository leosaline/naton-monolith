package com.saline.naton.product;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ProductController {
	private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Return list of products") })
	@GetMapping(value = "/products", produces = "application/json")
	@CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
	public ResponseEntity<Collection<Product>> listProducts() {
		return ResponseEntity.ok(this.productService.listProducts());
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return a new product") })
	@PostMapping(value = "/product", produces = "application/json")
	@CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.ok(this.productService.save(product)); 
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return a single product") })
	@GetMapping(value = "/product/{id}", produces = "application/json")
	@CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		return ResponseEntity.ok(this.productService.getProductById(id));
	}
}
