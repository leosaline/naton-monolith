package com.saline.naton.product;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceimp implements ProductService{
	@Autowired
	ProductRepository productRepository;
	private String companyURL = "http://localhost:9003/company/";

	@Override
	public Collection<Product> listProducts() {
		List<Product> listProduct = (List<Product>) productRepository.findAll();
		
		for(Product product : listProduct) {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.getForEntity(companyURL + product.getId().toString(), String.class);
			
			JSONObject jsonObject = new JSONObject(response.getBody());
			String name = (String) jsonObject.get("name");
			product.setCompanyName(name);
		}
		
		return listProduct;
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> optProduct = productRepository.findById(id);
		if(optProduct.isPresent())
			return optProduct.get();
		else
			return new Product();
	}

}
