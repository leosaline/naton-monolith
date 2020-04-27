package com.saline.naton.purchase;

import java.util.Collection;

public interface PurchaseService {
	public Collection<Purchase> listPurchase();
	public Purchase save(Purchase purchase);
	public Purchase getPurchaseById(Long id);
}
