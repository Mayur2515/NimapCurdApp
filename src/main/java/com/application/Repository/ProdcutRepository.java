package com.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Model.Product;

public interface ProdcutRepository  extends JpaRepository<Product, Long>{

}
