package es.homeapp.tasksms.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewDataService implements ViewData {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void viewData() {
		// TODO Auto-generated method stub
		logger.info("Estoy dentro del BEAN!! PODEMOS VER LA INFORMACION");
	}
	
	
	
	
}
