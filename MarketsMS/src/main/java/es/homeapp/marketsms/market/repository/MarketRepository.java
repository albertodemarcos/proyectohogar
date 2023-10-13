package es.homeapp.marketsms.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.homeapp.marketsms.market.model.Market;


@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {

	
	 boolean existsByName(String name);
}
