package es.homeapp.marketsms.market;

public interface MarketService {

	
	MarketDTO createMarket(MarketDTO market);
	
	MarketDTO updateMarket(MarketDTO market);
	
	boolean deleteMarket(String idMarketStr);
	
	MarketDTO getMarket(String idMarketStr);
	
}
