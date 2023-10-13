package es.homeapp.marketsms.market.model;

import java.io.Serializable;

public class MarketCommand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8710008309458767528L;
	private Long id;
	private String name;
	private String description;

	
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
