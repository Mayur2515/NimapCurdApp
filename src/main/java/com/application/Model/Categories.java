package com.application.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.*;

@Entity
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoriesId;
	private String Name;
	@OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
	private Set<Product> product;

	public Categories(String name) {
		Name = name;
	}

	public Categories() {

	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "Categories [categoriesId=" + categoriesId + ", Name=" + Name + "]";
	}
}	
