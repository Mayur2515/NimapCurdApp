package com.application.Services;

import java.util.List;

import org.hibernate.query.Page;

import com.application.Dto.CategoriesDTO;
import com.application.Model.Categories;

public interface CategoriesServiceInterface {
	public List<Categories> viewCategoryList();
	
	public Page getCategories(int pageSize);
	
	public boolean addCategories(CategoriesDTO dCtegoriesDTO);

	public boolean deleteCategoriesById(long id);

	public boolean updateCategories(CategoriesDTO categoriesDTO, long id);

	public Categories findbyCategoriesId(long id);
}