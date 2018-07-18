package com.visa.ncg.canteen.service;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.visa.ncg.canteen.model.Car;

//@Service("svc")
public class IServiceImpl implements IService{
	
	@Value("${greeting.msg}")
	private String msg;
	
	public String hello() {
		return msg;
	}
	
	@PostConstruct  //called when spring start
	public void init() {
		System.out.println("INIT Called ON SVC");
	}

	@Override
	public Collection<Car> getCars() {
		// TODO Auto-generated method stub
		return null;
	}
}
