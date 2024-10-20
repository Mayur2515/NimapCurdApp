package com.application.Services;

import java.util.List;
import org.springframework.data.domain.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.application.Dto.CategoriesDTO;
import com.application.Model.Categories;
import com.application.Repository.CategoriesRopository;

@Service
public class CategoriesServiceImpl implements CategoriesServiceInterface {

	@Autowired
	CategoriesRopository catRepo;

	@Override
	public boolean addCategories(CategoriesDTO CtegoriesDTO) {
		Categories c = new Categories(CtegoriesDTO.getName());
		try {
			catRepo.save(c);
			return true;
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@Override
	public List<Categories> viewCategoryList() {
		return catRepo.findAll();
	}
	
	public Page<Categories> getCategories1(int pageSize) {
		return catRepo.findAll(PageRequest.ofSize(pageSize));
	}

	@Override
	public boolean deleteCategoriesById(long id) {
		try {
			catRepo.deleteById(id);
			return true;
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean updateCategories(CategoriesDTO categoriesDTO, long id) {
		try {
			Categories c = catRepo.findById(id).get();
			c.setName(categoriesDTO.getName());
			catRepo.save(c);
			return true;
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Categories findbyCategoriesId(long id) {		
		return catRepo.findById(id).get();
	}

	@Override
	public org.hibernate.query.Page getCategories(int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
}
