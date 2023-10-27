package es.homeapp.productms.ProductsMS.product.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.homeapp.productms.ProductsMS.product.api.ProductRequest;
import es.homeapp.productms.ProductsMS.product.repository.ProductRepository;
import io.micrometer.common.util.StringUtils;



@Component
public class ProductValidator implements Validator {

	private final ProductRepository repository;

	public ProductValidator(ProductRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ProductRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ProductRequest productDTO = ( ProductRequest ) target;
		
		if( productDTO == null ) {
			errors.reject("", "The market is null");
			return;
		}
		
		if( StringUtils.isBlank( productDTO.getName() ) ) {
			errors.reject("name", "The field \"name\" is null");
		}
		else {
			boolean exitsMarket = this.repository.existsByName( productDTO.getName() );
			if( exitsMarket ) {
				errors.reject("name", "The product name already exists");
				return;
			}
		}
		
		if( StringUtils.isBlank( productDTO.getDescription() ) ){
			errors.reject("description", "The field \"description\" is null");
			
		}else if( productDTO.getDescription().length() < 50  ) {
			errors.reject("description", "The field \"description\"  is less than 50 characters");
		}
	}

}
