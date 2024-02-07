package es.homeapp.tasksms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.homeapp.tasksms.services.FakeViewDataService;
import es.homeapp.tasksms.services.ViewData;
import es.homeapp.tasksms.services.ViewDataService;
import io.micrometer.common.util.StringUtils;

@Configuration
@ConfigurationProperties(prefix = "view")
public class Config {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String TIPO_FAKE = "FAKE"; 
	
	@Value("${tipo:#{FAKE}}")
	private String tipoView;
	
	@Bean
	public ViewData viewDataConfiguration() {
		
		logger.info("Entramos en la configuracion del BEAN=viewDataConfiguration" );
		
		if( StringUtils.isBlank(tipoView) || TIPO_FAKE.equalsIgnoreCase(tipoView) ) {
			
			logger.info("Estoy creando un BEAN={}", FakeViewDataService.class );
			
			return new FakeViewDataService();
		}

		logger.info("Estoy creando un BEAN={}", ViewDataService.class );
		
		return new ViewDataService();
	}
	
	
	
}
