package com.saline.naton.purchase;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceimp implements PurchaseService{
	@Autowired
	PurchaseRepository purchaseRepository;

	@Override
	public Collection<Purchase> listPurchase() {
		return (Collection<Purchase>) purchaseRepository.findAll();
	}

	@Override
	public Purchase save(Purchase purchase) {
		return purchaseRepository.save(purchase);
	}

	@Override
	public Purchase getPurchaseById(Long id) {
		Optional<Purchase> optPurchase = purchaseRepository.findById(id);
		if(optPurchase.isPresent())
			return optPurchase.get();
		else
		    return new Purchase();
	}

}
