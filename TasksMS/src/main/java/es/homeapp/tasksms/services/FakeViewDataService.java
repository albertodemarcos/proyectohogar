package es.homeapp.tasksms.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FakeViewDataService implements ViewData {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void viewData() {
		// TODO Auto-generated method stub
		logger.info("ERROR! NO SE VERA LA INFORMACION");
	}

}
