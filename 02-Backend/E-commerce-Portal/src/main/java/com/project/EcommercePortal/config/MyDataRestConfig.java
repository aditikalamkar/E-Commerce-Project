package com.project.EcommercePortal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.project.EcommercePortal.entity.Product;
import com.project.EcommercePortal.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements  RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
	
		config.getExposureConfiguration()
		.forDomainType(Product.class)
		.withItemExposure((metdata,hhtpMethods)-> hhtpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
		
		
		 config.getExposureConfiguration()
         .forDomainType(ProductCategory.class)
         .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
         .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

		
	}

}
