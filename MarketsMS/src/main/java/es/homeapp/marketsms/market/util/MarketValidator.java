package es.homeapp.marketsms.market.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.homeapp.marketsms.market.api.MarketRequest;
import es.homeapp.marketsms.market.repository.MarketRepository;
import io.micrometer.common.util.StringUtils;


@Component
public class MarketValidator implements Validator {
	
	private final MarketRepository repository;

	public MarketValidator(MarketRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return MarketRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		MarketRequest marketDTO = ( MarketRequest ) target;
		
		if( marketDTO == null ) {
			errors.reject("", "The market is null");
			return;
		}
		
		if( StringUtils.isBlank( marketDTO.getName() ) ) {
			errors.reject("name", "The field \"name\" is null");
		}
		else {
			boolean exitsMarket = this.repository.existsByName( marketDTO.getName() );
			if( exitsMarket ) {
				errors.reject("name", "The market name already exists");
				return;
			}
		}
		
		if( StringUtils.isBlank( marketDTO.getDescription() ) ){
			errors.reject("description", "The field \"description\" is null");
			
		}else if( marketDTO.getDescription().length() < 50  ) {
			errors.reject("description", "The field \"description\"  is less than 50 characters");
		}
	}

}
