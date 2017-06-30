package com.sid;

import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan
@EnableWebMvc
public class Application {
	public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**/*").allowedOrigins("http://mocker.egen.io")
	            .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS")
	            .allowedHeaders("Access-Control-Allow-Origin", "Content-Type","X-Requested-With","accept","Origin,Access-Control-Request-Method","Access-Control-Request-Headers")
	            .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
	            .allowCredentials(false).maxAge(3600);
	}
}