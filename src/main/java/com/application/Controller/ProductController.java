package com.application.Controller;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.application.Dto.ProductDTO;
import com.application.Model.Product;
import com.application.Services.ProductServiceInterface;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

	@Autowired
	private ProductServiceInterface serv;

	@GetMapping
	public List<Product> viewProduct() {
		return serv.viewProductList();
	}

	@GetMapping("/pagination/{pageSize}")
	public org.springframework.data.domain.Page<Product> getProducts(@PathVariable int pageSize) {
		return serv.getProducts(pageSize);		
	}
	
	@PostMapping("/add")
	public ProductDTO addProducts(@RequestBody ProductDTO productDTO) {
		System.out.println(productDTO.toString());
		boolean b = serv.addProductDetails(productDTO);
		if (b)
			return productDTO;
		else
			return null;
	}

	@GetMapping("/getById/{id}")
	public Optional<Product> findByProductId(@PathVariable("id") long id) {
		Optional<Product> product = serv.findByProductId(id);
		if (product.isEmpty())
			return null;
		else
			return product;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteByProductId(@PathVariable("id") long id) {
		boolean b = serv.deleteProductById(id);
		if (b)
			return id + "product deleted.........";
		else
			return id + "product not deleted..........";
	}
	
	@PutMapping("/update/{id}")
	public String updateProduct(@PathVariable("id") long id, @RequestBody ProductDTO productDTO) {
		System.out.println(productDTO.toString());
		System.out.println(id);
		boolean b = serv.updateProductById(productDTO, id);
		if (b)
			return "product updated....";
		else
			return "product not updated....";
	}
}