package com.cnbr.service.api.app;

import java.util.TimeZone;

import org.springframework.context.ConfigurableApplicationContext;

import com.cnbr.service.api.resources.CustomExceptionManager;
import com.cnbr.service.api.resources.DummyHealthCheck;
import com.cnbr.service.api.resources.SpringAppBundle;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class ServiceApp extends Application<ServiceAppConfiguration> {

	public static void main(String[] args) throws Exception {
		TimeZone.setDefault(TimeZone.getTimeZone("EST"));
		new ServiceApp().run(args);
	}
	
	@Override
	public void initialize(final Bootstrap<ServiceAppConfiguration> bootstrap) {
		
		bootstrap.addBundle( new SwaggerBundle<ServiceAppConfiguration>() {
			@Override
			protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(ServiceAppConfiguration configuration) {
				return configuration.getSwaggerBundleConfiguration();
			}
		});
		
		bootstrap.addBundle(new SpringAppBundle<ServiceAppConfiguration>() {
			@Override
			protected void registerAdditionalBeans(ServiceAppConfiguration configuration,
					ConfigurableApplicationContext context) {
				// Additional Beans
			}
		});
	}
	
	@Override
	public void run(ServiceAppConfiguration configuration, Environment environment) throws Exception {
		environment.healthChecks().register("DummyHealthCheck", new DummyHealthCheck());
		environment.jersey().register(new CustomExceptionManager());
	}

}
