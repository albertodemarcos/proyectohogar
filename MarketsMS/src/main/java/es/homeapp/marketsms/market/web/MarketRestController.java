package es.homeapp.marketsms.market.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.homeapp.marketsms.config.Constant;
import es.homeapp.marketsms.market.api.MarketRequest;
import es.homeapp.marketsms.market.api.MarketResponse;
import es.homeapp.marketsms.market.service.MarketService;
import es.homeapp.marketsms.market.util.MarketValidator;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api")
@Slf4j
public class MarketRestController {
	
	private final MarketValidator validator;

	private final MarketService marketService;
	
	public MarketRestController(MarketValidator validator, MarketService marketService) {
		this.validator = validator;
		this.marketService = marketService;
	}
	
	@GetMapping(value="/hello")
	public ResponseEntity<MarketResponse> getHello(){
		log.debug("getHello()");
		return new ResponseEntity<MarketResponse>(new MarketResponse(), HttpStatus.OK);
	}

	
	@GetMapping(value="/markets/{idIncidenceStr}")
	public ResponseEntity<MarketResponse> getMarket(@PathVariable @Pattern(regexp = Constant.ENTITIES_ID_REGEX) String idIncidenceStr){
		log.debug("getMarket(idIncidenceStr={})", idIncidenceStr);
		MarketResponse newMarketDTO = this.marketService.getMarket(idIncidenceStr);
		return new ResponseEntity<MarketResponse>(newMarketDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/markets")
	public ResponseEntity<MarketResponse> createMarket( @RequestBody final MarketRequest market, BindingResult result) {
		log.debug("createMarket(market={})", market!=null?market.toString():null);
		validator.validate(market, result);
		if( result.hasErrors() ) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		MarketResponse newMarketDTO = marketService.createMarket(market);
		return new ResponseEntity<>(newMarketDTO, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/markets")
	public ResponseEntity<MarketResponse> updateMarket(@RequestBody final MarketRequest market, BindingResult result){
		log.debug("createMarket(market={})", market!=null?market.toString():null);
		validator.validate(market, result);
		if( result.hasErrors() ) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		MarketResponse newMarketDTO = marketService.createMarket(market);
		return new ResponseEntity<>(newMarketDTO, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/markets/{idIncidenceStr}")
	public ResponseEntity<Boolean> deleteMarket(@PathVariable @Pattern(regexp = Constant.ENTITIES_ID_REGEX) String idIncidenceStr){
		log.debug("deleteMarket(idIncidenceStr={})", idIncidenceStr);
		boolean deleted = this.marketService.deleteMarket(idIncidenceStr);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	
}
