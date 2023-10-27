package es.homeapp.productms.ProductsMS.product.service.impl;

import org.springframework.stereotype.Service;

import es.homeapp.productms.ProductsMS.product.api.ProductRequest;
import es.homeapp.productms.ProductsMS.product.api.ProductResponse;
import es.homeapp.productms.ProductsMS.product.model.Product;
import es.homeapp.productms.ProductsMS.product.repository.ProductRepository;
import es.homeapp.productms.ProductsMS.product.service.ProductService;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
		
	}
	
	@Override
	public ProductResponse createProduct(ProductRequest product) {
		// TODO Auto-generated method stub
		Product entity = new Product(product);
		entity = this.productRepository.save(entity);
		return new ProductResponse(entity);
	}

	@Override
	public ProductResponse updateProduct(ProductRequest product) {
		// TODO Auto-generated method stub
		try {
			return this.update(product);
		}catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public boolean deleteProduct(String idProductStr) {
		// TODO Auto-generated method stub
		try {
			return this.delete(idProductStr);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ProductResponse getProduct(String idProductStr) {
		// TODO Auto-generated method stub
		try {
			return this.get(idProductStr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}


	private ProductResponse update(ProductRequest product) throws Exception {
		Product entity = this.productRepository.findById(product.getId()).orElse( null );
		
		if( entity == null ) {
			return null;
		}
		
		entity.setName(product.getName());
		entity.setDescription(product.getDescription());
		
		this.productRepository.findById(product.getId());
		
		return new ProductResponse(entity);
	}
	
	private boolean delete(String idProductStr) throws Exception  {
		Long idProduct = Long.parseLong(idProductStr);
		this.productRepository.deleteById(idProduct);
		return true;
	}
	
	private ProductResponse get(String idProductStr) throws Exception {
		Long idProduct = Long.parseLong(idProductStr);
		Product entity = this.productRepository.findById(idProduct).orElse(null);
		if( entity == null ) {
			return null;
		}
		return new ProductResponse(entity);
	}
}
