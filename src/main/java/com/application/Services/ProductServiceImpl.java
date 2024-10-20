package com.application.Services;


import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.application.Dto.ProductDTO;
import com.application.Model.Categories;
import com.application.Model.Product;
import com.application.Repository.CategoriesRopository;
import com.application.Repository.ProdcutRepository;

@Service
public class ProductServiceImpl implements ProductServiceInterface {

	@Autowired
	private ProdcutRepository proRepo;
	
	@Autowired
	CategoriesRopository catRepo; 
	
	@Override
	public boolean addProductDetails(ProductDTO productDTO) {
		try {
			Categories category =  catRepo.findById(productDTO.getCategoriesId()).get();	
			Product p = new Product(productDTO.getBookName(), productDTO.getReleaseDate(), productDTO.getPrice(), productDTO.getAuthorName(), category);
			proRepo.save(p);
			return true;
		} 
		catch (Exception ex) {
			System.out.println("Repository Exception is " + ex);
			return false;
		}
	}

	@Override
	public List<Product> viewProductList() {
		return proRepo.findAll();
	}
	
	

	@Override
	public Optional<Product> findByProductId(long id) {
		Optional<Product> product = proRepo.findById(id);
		return product;
	}

	@Override
	public boolean deleteProductById(long id) {
		try {
			proRepo.deleteById(id);
			return true;
		} 
		catch (Exception ex) {
			return false;
		}
	}
	
	@Override
	public boolean updateProductById(ProductDTO productDTO, long id) {
		try {
			Product p = proRepo.findById(id).get();
			p.setBookName(productDTO.getBookName());
			p.setAuthorName(productDTO.getAuthorName());
			p.setPrice(productDTO.getPrice());
			p.setReleaseDate(productDTO.getReleaseDate());
			proRepo.save(p);
			return true;
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Page<Product> getProducts(int pageSize) {
		return proRepo.findAll(PageRequest.ofSize(pageSize));
		
		/*@Override
	public Page<Product> getProducts(int pageSize) {
		return proRepo.findAll(PageRequest.ofSize(pageSize));
	}*/
	}
}