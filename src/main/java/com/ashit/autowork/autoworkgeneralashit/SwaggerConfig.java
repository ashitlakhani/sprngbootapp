package com.ashit.autowork.autoworkgeneralashit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Laks", "www.ashit.com", "98979875");
	private static final ApiInfo DEFAULT_API_INFO_A = new ApiInfo(" Ashit Lakhani - Auto and Work General Test", " Api Documentation", "01.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	
	private static final Set<String> DEF_PROD_N_CONS = new HashSet<>();
	
	static {
		DEF_PROD_N_CONS.add("application/json");
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ashit.autowork.autoworkgeneralashit.controller")).build()
				.apiInfo(DEFAULT_API_INFO_A).produces(DEF_PROD_N_CONS).consumes(DEF_PROD_N_CONS);
	}
	
}
