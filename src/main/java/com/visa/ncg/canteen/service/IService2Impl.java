package com.visa.ncg.canteen.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.visa.ncg.canteen.model.Car;
import com.visa.ncg.canteen.model.Part;

//@Service("svc2")
public class IService2Impl implements IService{
	
	@Override
	public String hello() {
		return " Yo from IService 2 ";
	}
	
	@PostConstruct
	public void init() {
		System.out.println("INIT CALLED ON SVC2");
	}

	@Override
	public Collection<Car> getCars() {
		Collection<Car> cars = new ArrayList<>();
		
		Car car = new Car("BMW", "i8", 2018);
		List<Part> parts = new ArrayList<>();
		parts.add(new Part("door", 2));
		parts.add(new Part("panomara", 1));
		car.setParts(parts);
		
		Car car1 = new Car("Porsche", "911", 2019);
		List<Part> parts1 = new ArrayList<>();
		parts.add(new Part("door", 2));
		parts.add(new Part("panomara", 1));
		car1.setParts(parts);
		
		cars.add(car);
		cars.add(car1);
		
		return cars;
	}
}
