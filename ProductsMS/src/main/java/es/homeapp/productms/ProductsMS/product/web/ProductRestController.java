package es.homeapp.productms.ProductsMS.product.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.homeapp.productms.ProductsMS.config.Constant;
import es.homeapp.productms.ProductsMS.product.api.ProductRequest;
import es.homeapp.productms.ProductsMS.product.api.ProductResponse;
import es.homeapp.productms.ProductsMS.product.service.ProductService;
import es.homeapp.productms.ProductsMS.product.util.ProductValidator;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ProductRestController {

	
	private final ProductValidator validator;

	private final ProductService productService;
	
	public ProductRestController(ProductValidator validator, ProductService productService) {
		this.validator = validator;
		this.productService = productService;
	}
	
	@GetMapping(value="/hello")
	public ResponseEntity<?> getHello(){
		//log.debug("getHello()");
		return new ResponseEntity<String>("Esto es una prueba", HttpStatus.OK);
	}
	
	@GetMapping(value="/products/{idIncidenceStr}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable @Pattern(regexp = Constant.ENTITIES_ID_REGEX) String idIncidenceStr){
		//log.debug("getProduct(idIncidenceStr={})", idIncidenceStr);
		ProductResponse newProductDTO = this.productService.getProduct(idIncidenceStr);
		return new ResponseEntity<ProductResponse>(newProductDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/products")
	public ResponseEntity<ProductResponse> createProduct( @RequestBody final ProductRequest product, BindingResult result) {
		//log.debug("createProduct(product={})", product!=null?product.toString():null);
		validator.validate(product, result);
		if( result.hasErrors() ) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		ProductResponse newProductDTO = productService.createProduct(product);
		return new ResponseEntity<>(newProductDTO, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/products")
	public ResponseEntity<ProductResponse> updateProduct(@RequestBody final ProductRequest product, BindingResult result){
		//log.debug("createProduct(product={})", product!=null?product.toString():null);
		validator.validate(product, result);
		if( result.hasErrors() ) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		ProductResponse newProductDTO = productService.createProduct(product);
		return new ResponseEntity<>(newProductDTO, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/products/{idProductStr}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable @Pattern(regexp = Constant.ENTITIES_ID_REGEX) String idProductStr){
		//log.debug("deleteProduct(idProductStr={})", idProductStr);
		boolean deleted = this.productService.deleteProduct(idProductStr);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
}
