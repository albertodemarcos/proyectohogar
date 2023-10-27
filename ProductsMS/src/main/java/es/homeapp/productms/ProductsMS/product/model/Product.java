package es.homeapp.productms.ProductsMS.product.model;

import java.io.Serializable;

import es.homeapp.productms.ProductsMS.product.api.ProductRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Table(name = "products", schema = "products")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5887654380005576427L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
	@SequenceGenerator(name = "product_sequence", sequenceName = "sequence_product", allocationSize = 1)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Lob
	@Column(name = "description", nullable = true, columnDefinition = "TEXT")
	private String description;
	
	
	public Product() {
		super();
	}
	
	public Product(ProductRequest data) {
		super();
		this.setId(data.getId());
		this.setDescription(data.getDescription());
		this.setName(data.getName());
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
