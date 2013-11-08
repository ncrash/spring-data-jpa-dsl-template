package com.tistory.devyongsik.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;


@Configuration
@ImportResource({"classpath:test-spring-root.xml"})
@PropertySource({"classpath:test-application.properties"})
public class AbstractRepositoryTestApplicationContextConfig {

	@Autowired
	private ConfigurableEnvironment configurableEnvironment;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
