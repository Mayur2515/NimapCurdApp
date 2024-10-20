package com.application.Services;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;

import com.application.Dto.ProductDTO;
import com.application.Model.Product;

public interface ProductServiceInterface {
	public boolean addProductDetails(ProductDTO productDTO);

	public List<Product> viewProductList();
	
	public org.springframework.data.domain.Page<Product> getProducts(int pageSize);

	public Optional<Product> findByProductId(long id);

	public boolean deleteProductById(long id);

	boolean updateProductById(ProductDTO productDTO, long id); 
}
