package com.visa.ncg.canteen.service;
import java.util.Collection;

import com.visa.ncg.canteen.model.Car;

public interface IService {
	public String hello();
	public void init();
	public Collection<Car> getCars();
}
