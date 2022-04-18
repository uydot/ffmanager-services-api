package com.services.api.ffmanager;



import org.modelmapper.ModelMapper;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class FFManagerConfiguration {

	@Bean
	public ModelMapper modelMapper() {
	 return new ModelMapper();
	}
	
	@Bean
	  public GroupedOpenApi publicInstitucionalServicesApi() {
	      return GroupedOpenApi.builder()
	              .group("ffmanager-public")
	              .pathsToMatch("/api-services/")
	              .build();
	  }
	 
//	@Bean
//	  public GroupedOpenApi publicPerfilesServicesApi() {
//	      return GroupedOpenApi.builder()
//	              .group("ffmanager-public-PerfilesServices")
//	              .pathsToMatch("/perfiles-services/")
//	              .build();
//	  }
}
