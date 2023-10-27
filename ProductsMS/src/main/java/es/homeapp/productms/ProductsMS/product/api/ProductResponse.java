package es.homeapp.productms.ProductsMS.product.api;

import java.io.Serializable;

import es.homeapp.productms.ProductsMS.product.model.Product;

public class ProductResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7151016094282112899L;

	private Long id;
	private String name;
	private String description;
	
	public ProductResponse() {
		super();
	}

	public ProductResponse(Product product) {
		super();
		this.setId(product.getId());
		this.setName(product.getName());
		this.setDescription(product.getDescription());		
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
