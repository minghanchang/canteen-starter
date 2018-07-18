package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.visa.ncg.canteen.service.IService;
import com.visa.ncg.canteen.service.IService2Impl;
import com.visa.ncg.canteen.service.IServiceImpl;

@Configuration
public class AppConfig {
	
	@Value("${svc.conf}")
	private String svcconf;
	
	@Bean(name = "svcLALA", initMethod="init")
	public IService m1() {
		
		if(svcconf.equals("this is svc2")) {
			return new IService2Impl();
		}
		else {
			return new IServiceImpl();
		}
	}
}

