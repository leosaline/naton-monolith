package com.saline.naton.purchase;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;

@RestController
public class PurchaseController {
	private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return list of purchase") })
	@GetMapping(value="/purchases", produces = "application/json")
	public ResponseEntity<Collection<Purchase>> listPurchase() {
		return ResponseEntity.ok(this.purchaseService.listPurchase());
	}
	
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return a single purchase") })
	@GetMapping(value="/purchase/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Purchase> getPurchaseById(@PathVariable Long id) {
		return ResponseEntity.ok(this.purchaseService.getPurchaseById(id));
	}
	
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Return a new purchase") })
	@PostMapping(value = "/purchase", produces = "application/json")
	@CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
	public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
		purchase.setDatePurchase(new Date());
		purchase.setUserPurchase(1L);
		
		return ResponseEntity.ok(this.purchaseService.save(purchase));
	}

}
