package com.cnbr.service.api.app;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.cnbr.service.api.resources.ISpringLoaderConfiguration;
import com.cnbr.service.api.resources.SpringAppConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class ServiceAppConfiguration extends Configuration implements ISpringLoaderConfiguration {

	@Valid
	@NotNull
	@JsonProperty("swagger")
	private final SwaggerBundleConfiguration swaggerBundleConfiguration = new SwaggerBundleConfiguration();
	
	@Valid
	@NotNull
	@JsonProperty("springAppConfiguration")
	private SpringAppConfiguration springAppConfiguration;

	public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
		return swaggerBundleConfiguration;
	}

	@Override
	public SpringAppConfiguration getSpringAppConfiguration() {
		return springAppConfiguration;
	}
	
}
