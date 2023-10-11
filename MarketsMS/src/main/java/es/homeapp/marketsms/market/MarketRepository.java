package es.homeapp.marketsms.market;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {

	
	 boolean existsByName(String name);
}
