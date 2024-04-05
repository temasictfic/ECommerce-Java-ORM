package com.tobeto.pairwork_orm.repositories;

import com.tobeto.pairwork_orm.entities.ProductPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductPhotoRepository extends JpaRepository<ProductPhoto, Integer>{
	List<ProductPhoto> getProductPhotosByProduct_ProductId(int productId);
}
