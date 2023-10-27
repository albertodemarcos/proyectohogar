package es.homeapp.productms.ProductsMS.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.homeapp.productms.ProductsMS.product.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>  {

	 boolean existsByName(String name);
	
	
	
}
