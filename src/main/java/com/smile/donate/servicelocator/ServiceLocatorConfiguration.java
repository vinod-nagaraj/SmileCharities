package com.smile.donate.servicelocator;


import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smile.donate.service.PaymentRegistery;

@Configuration
public class ServiceLocatorConfiguration {
  
	@Bean
	public FactoryBean<?> getBean(){
		ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
		bean.setServiceLocatorInterface(PaymentRegistery.class);
		return bean;
	}
}
