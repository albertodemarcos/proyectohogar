package es.homeapp.marketsms.market.service.impl;

import org.springframework.stereotype.Service;

import es.homeapp.marketsms.market.model.Market;
import es.homeapp.marketsms.market.model.MarketCommand;
import es.homeapp.marketsms.market.model.MarketDTO;
import es.homeapp.marketsms.market.repository.MarketRepository;
import es.homeapp.marketsms.market.service.MarketService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MarketServiceImpl implements MarketService {
	
	private final MarketRepository marketRepository;
	
	public MarketServiceImpl(MarketRepository marketRepository) {
		this.marketRepository = marketRepository;
	}

	@Override
	public MarketDTO createMarket(final MarketCommand market) {
		// TODO Auto-generated method stub
		Market entity = new Market(market);
		entity = this.marketRepository.save(entity);
		return new MarketDTO(entity);
	}

	@Override
	public MarketDTO updateMarket(MarketCommand market) {
		// TODO Auto-generated method stub
		
		MarketDTO dto = null;
		
		try {
			
			Market entity = this.marketRepository.findById(market.getId()).orElse( null );
			
			if( entity == null ) {
				
				return null;
			}
			
			entity.setName(market.getName());
			entity.setDescription(market.getDescription());
			
			this.marketRepository.findById(market.getId());
			
			dto = new MarketDTO(entity);
			
		}catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		return dto;
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
