package com.cnbr.service.resources;

import java.util.Map;
import java.util.Objects;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.ws.rs.Path;

public abstract class SpringAppBundle<T extends ISpringLoaderConfiguration> implements ConfiguredBundle<T> {

	@Override
	public void run(T t, Environment environment) {
		this.initSpringServices(t, environment);
	}
	
	@SuppressWarnings("resource")
	private void initSpringServices(final T configuration, Environment environment) {
		final ConfigurableApplicationContext mainContext = new ClassPathXmlApplicationContext();
		mainContext.refresh();
		
		this.registerDataSources(configuration, environment, mainContext);
		mainContext.getBeanFactory().registerSingleton("DROP_WIZARD_APP_CONFIG", configuration);
		
		final String[] xmlConfigsPaths = configuration.getSpringAppConfiguration().getSpringFileLocations().toArray(
				new String[configuration.getSpringAppConfiguration().getSpringFileLocations().size()]);
		
		final ConfigurableApplicationContext childContext = new ClassPathXmlApplicationContext(xmlConfigsPaths, mainContext);
		childContext.refresh();
		childContext.registerShutdownHook();
		childContext.start();
		
		final Map<String, Object> resources = childContext.getBeansWithAnnotation(Path.class);
		for(Map.Entry<String, Object> entry : resources.entrySet()) {
			environment.jersey().register(entry.getValue());
		}
	}
	
	private void registerDataSources(final T configuration, final Environment environment, final ConfigurableApplicationContext parentContext) {
		if(Objects.nonNull(configuration.getSpringAppConfiguration().getJdbcDataSourcesConfigs())) {
			for(final JdbcDataSourceConfig source : configuration.getSpringAppConfiguration().getJdbcDataSourcesConfigs()) {
				parentContext.getBeanFactory().registerSingleton(source.getDataSourceName(), source.getBasicDataSource());
			}
		}
	}
	
	protected abstract void registerAdditionalBeans(final T configuration, final ConfigurableApplicationContext context);
	
	@Override
	public void initialize(Bootstrap<?> bootstrap) {
		
	}
}
