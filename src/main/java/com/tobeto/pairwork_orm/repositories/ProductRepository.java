package com.tobeto.pairwork_orm.repositories;

import com.tobeto.pairwork_orm.entities.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Optional<Product> findByProductNameIgnoreCase(String productName);

    // Filter and list products by name
    @Query("SELECT p FROM Product p WHERE LOWER(p.productName) = LOWER(:name)")
    List<Product> findByName(@Param("name") String name);

    // Filter and list products by price range
    @Query("SELECT p FROM Product p WHERE p.unitPrice BETWEEN :minPrice AND :maxPrice")
    List<Product> findByPriceRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);

    // Filter and list products by category
    @Query("SELECT p FROM Product p WHERE p.category.categoryId = :categoryId")
    List<Product> findByCategory(@Param("categoryId") Integer categoryId);

	// List best-selling products
	@Query("SELECT p FROM Product p ORDER BY p.sales DESC")
	List<Product> findBestSellingProducts();

	// List newly added products
	@Query("SELECT p FROM Product p ORDER BY p.addedDate DESC")
	List<Product> findNewlyAddedProducts();
}
