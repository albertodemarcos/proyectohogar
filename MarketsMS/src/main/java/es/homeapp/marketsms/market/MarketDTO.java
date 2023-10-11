package es.homeapp.marketsms.market;

import java.io.Serializable;

public class MarketDTO implements Serializable {

	private static final long serialVersionUID = -3438713904388741952L;
	
	private Long id;
	private String name;
	private String description;

	public MarketDTO() {
		super();
	}
	
	public MarketDTO(Market entity) {
		super();
		this.setId(entity.getId());
		this.setDescription(entity.getDescription());
		this.setName(entity.getName());
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

	@Override
	public String toString() {
		return "Market [id=" + getId() + ", name=" + name + ", description=" + getDescription() + "]";
	}

}
