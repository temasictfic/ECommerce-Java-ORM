package com.tobeto.pairwork_orm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.pairwork_orm.entities.ProductPhoto;

public interface ProductPhotoRepository extends JpaRepository<ProductPhoto, Integer>{
	List<ProductPhoto> getProductPhotosByProduct_ProductId(int productId);
}
