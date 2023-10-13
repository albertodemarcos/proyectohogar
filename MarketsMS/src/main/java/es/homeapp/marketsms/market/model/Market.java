package es.homeapp.marketsms.market.model;

import java.io.Serializable;
import java.util.Objects;

import es.homeapp.marketsms.market.api.MarketRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "markets", schema = "markets")
public class Market implements Serializable {

	private static final long serialVersionUID = -6412789602443085861L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "market_sequence")
	@SequenceGenerator(name = "market_sequence", sequenceName = "sequence_market", allocationSize = 1)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Lob
	@Column(name = "description", nullable = true, columnDefinition = "TEXT")
	private String description;

	public Market() {
		super();
	}
	
	public Market(MarketRequest dto) {
		super();
		this.setId(dto.getId());
		this.setDescription(dto.getDescription());
		this.setName(dto.getName());
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
	public int hashCode() {
		return Objects.hash(description, getId(), getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Market other = (Market) obj;
		return Objects.equals(getDescription(), other.getDescription()) && Objects.equals(getId(), other.getId())
				&& Objects.equals(getName(), other.getName());
	}

	@Override
	public String toString() {
		return "Market [id=" + getId() + ", name=" + name + ", description=" + getDescription() + "]";
	}

}
