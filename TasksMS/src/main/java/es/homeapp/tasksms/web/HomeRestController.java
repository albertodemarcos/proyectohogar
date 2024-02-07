package es.homeapp.tasksms.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.homeapp.tasksms.services.ViewData;

@RestController
public class HomeRestController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ViewData viewData;
	
	@GetMapping(value = {"", "/", "/inicio"})
	public ResponseEntity<?> getInit(){
		
		logger.debug("getHello()");
		
		viewData.viewData();
		
		return new ResponseEntity<String>("Esto es una prueba", HttpStatus.OK);
	}
	
	
	
}
