package com.capgemini.librarymanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;


/*
 * 
 * author Bhaskar VA 
 * 
 */

@Configuration
public class JPAConfig {
	@Bean
	public LocalEntityManagerFactoryBean getEMF() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("LibraryPersistence");
		return factoryBean;
	}// end of getEMF()

}
