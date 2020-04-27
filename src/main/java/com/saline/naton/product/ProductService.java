package com.saline.naton.product;

import java.util.Collection;

public interface ProductService {
	public Collection<Product> listProducts();
	public Product save(Product product);
	public Product getProductById(Long id);

}
