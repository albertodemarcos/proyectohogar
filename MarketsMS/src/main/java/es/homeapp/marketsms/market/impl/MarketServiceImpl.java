package es.homeapp.marketsms.market.impl;

import org.springframework.stereotype.Service;

import es.homeapp.marketsms.market.Market;
import es.homeapp.marketsms.market.MarketDTO;
import es.homeapp.marketsms.market.MarketRepository;
import es.homeapp.marketsms.market.MarketService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MarketServiceImpl implements MarketService {
	
	private final MarketRepository marketRepository;
	
	public MarketServiceImpl(MarketRepository marketRepository) {
		this.marketRepository = marketRepository;
	}

	@Override
	public MarketDTO createMarket(final MarketDTO market) {
		// TODO Auto-generated method stub
		Market entity = new Market(market);
		entity = this.marketRepository.save(entity);
		return new MarketDTO(entity);
	}

	@Override
	public MarketDTO updateMarket(MarketDTO market) {
		// TODO Auto-generated method stub
		try {
			
			Market entity = this.marketRepository.findById(market.getId()).orElse( null );
			
			if( entity == null ) {
				
				return null;
			}
			
			entity.setName(market.getName());
			entity.setDescription(market.getDescription());
			
			this.marketRepository.findById(market.getId());
			
		}catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		return market;
	}

	@Override
	public boolean deleteMarket(String idMarketStr) {
		// TODO Auto-generated method stub
		try {
			Long idMarket = Long.parseLong(idMarketStr);
			this.marketRepository.deleteById(idMarket);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MarketDTO getMarket(String idMarketStr) {
		// TODO Auto-generated method stub
		try {
			Long idMarket = Long.parseLong(idMarketStr);
			Market entity = this.marketRepository.findById(idMarket).orElse(null);
			if( entity == null ) {
				return null;
			}
			return new MarketDTO(entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
