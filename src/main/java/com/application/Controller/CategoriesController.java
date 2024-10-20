package com.application.Controller;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.application.Dto.CategoriesDTO;
import com.application.Model.Categories;
import com.application.Services.CategoriesServiceInterface;

@RestController
@RequestMapping("/api/categories/")

public class CategoriesController {

	@Autowired
	private CategoriesServiceInterface serv;

	@GetMapping
	public List<Categories> viewCategory() {
		return serv.viewCategoryList();
	}
	
	@GetMapping("/pagination/{pageSize}")
	public Page getCategoriess(@PathVariable int pageSize) {
		return serv.getCategories(pageSize);		
	}
	
	@PostMapping("add")
	public String addCategories(@RequestBody CategoriesDTO categoriesDTO) {
		boolean b = serv.addCategories(categoriesDTO);
		if (b)
			return "category added succesfully............";
		else
			return "category not added.............";
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<String> findbyCategoriesId(@PathVariable("id") long id){   
		Categories c = serv.findbyCategoriesId(id);
		return  new ResponseEntity<String>(c.toString(), HttpStatus.FOUND);
	}

	@DeleteMapping("delete/{id}")
	public String deleteCategories(@PathVariable("id") long id) {
		boolean b = serv.deleteCategoriesById(id);
		if (b)
			return "Category deleted";
		else
			return "Category not deleted";
	}

	@PutMapping("update/{id}")
	public String updateCategories(@PathVariable("id") long id, @RequestBody CategoriesDTO categoriesDTO) {
		System.out.println(categoriesDTO.toString());
		System.out.println(id);
		boolean b = serv.updateCategories(categoriesDTO, id);
		if (b)
			return "category updated....";
		else
			return "category not updated....";
	}
}