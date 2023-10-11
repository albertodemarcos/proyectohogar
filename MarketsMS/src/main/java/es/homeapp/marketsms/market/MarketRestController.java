package es.homeapp.marketsms.market;


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
	public ResponseEntity<MarketDTO> getHello(){
		log.debug("getHello()");
		return new ResponseEntity<MarketDTO>(new MarketDTO(), HttpStatus.OK);
	}

	
	@GetMapping(value="/markets/{idIncidenceStr}")
	public ResponseEntity<MarketDTO> getMarket(@PathVariable @Pattern(regexp = Constant.ENTITIES_ID_REGEX) String idIncidenceStr){
		log.debug("getMarket(idIncidenceStr={})", idIncidenceStr);
		MarketDTO newMarketDTO = this.marketService.getMarket(idIncidenceStr);
		return new ResponseEntity<MarketDTO>(newMarketDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/markets")
	public ResponseEntity<MarketDTO> createMarket( @RequestBody final MarketDTO market, BindingResult result) {
		log.debug("createMarket(market={})", market!=null?market.toString():null);
		validator.validate(market, result);
		if( result.hasErrors() ) {
			return new ResponseEntity<>(market, HttpStatus.OK);
		}
		MarketDTO newMarketDTO = marketService.createMarket(market);
		return new ResponseEntity<>(newMarketDTO, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/markets")
	public ResponseEntity<MarketDTO> updateMarket(@RequestBody final MarketDTO market, BindingResult result){
		log.debug("createMarket(market={})", market!=null?market.toString():null);
		validator.validate(market, result);
		if( result.hasErrors() ) {
			return new ResponseEntity<>(market, HttpStatus.OK);
		}
		MarketDTO newMarketDTO = marketService.createMarket(market);
		return new ResponseEntity<>(newMarketDTO, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/markets/{idIncidenceStr}")
	public ResponseEntity<Boolean> deleteMarket(@PathVariable @Pattern(regexp = Constant.ENTITIES_ID_REGEX) String idIncidenceStr){
		log.debug("deleteMarket(idIncidenceStr={})", idIncidenceStr);
		boolean deleted = this.marketService.deleteMarket(idIncidenceStr);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	
}
