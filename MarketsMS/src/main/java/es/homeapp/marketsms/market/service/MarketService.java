package es.homeapp.marketsms.market.service;

import es.homeapp.marketsms.market.api.MarketRequest;
import es.homeapp.marketsms.market.api.MarketResponse;

public interface MarketService {

	
	MarketResponse createMarket(MarketRequest market);
	
	MarketResponse updateMarket(MarketRequest market);
	
	boolean deleteMarket(String idMarketStr);
	
	MarketResponse getMarket(String idMarketStr);
	
}
