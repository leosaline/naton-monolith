package com.saline.naton.purchase;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PurchaseServiceimp implements PurchaseService {
    private final PurchaseRepository purchaseRepository;

    public PurchaseServiceimp(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

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
        return purchaseRepository.findById(id).orElseGet(Purchase::new);
    }

}
