package es.homeapp.marketsms.market.service;

import es.homeapp.marketsms.market.model.MarketCommand;
import es.homeapp.marketsms.market.model.MarketDTO;

public interface MarketService {

	
	MarketDTO createMarket(MarketCommand market);
	
	MarketDTO updateMarket(MarketCommand market);
	
	boolean deleteMarket(String idMarketStr);
	
	MarketDTO getMarket(String idMarketStr);
	
}
