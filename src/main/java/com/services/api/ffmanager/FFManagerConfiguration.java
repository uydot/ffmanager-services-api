package com.services.api.ffmanager;



import org.modelmapper.ModelMapper;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
//	@Bean
//	  public GroupedOpenApi publicPerfilesServicesApi() {
//	      return GroupedOpenApi.builder()
//	              .group("ffmanager-public-PerfilesServices")
//	              .pathsToMatch("/perfiles-services/")
//	              .build();
//	  }
}
