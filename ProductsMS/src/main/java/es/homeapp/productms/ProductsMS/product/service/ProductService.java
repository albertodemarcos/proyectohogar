package es.homeapp.productms.ProductsMS.product.service;

import es.homeapp.productms.ProductsMS.product.api.ProductRequest;
import es.homeapp.productms.ProductsMS.product.api.ProductResponse;

public interface ProductService {

	ProductResponse createProduct(ProductRequest product);
	
	ProductResponse updateProduct(ProductRequest product);
	
	boolean deleteProduct(String idProductStr);
	
	ProductResponse getProduct(String idProductStr);
	
}
