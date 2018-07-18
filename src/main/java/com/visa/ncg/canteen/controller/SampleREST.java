package com.visa.ncg.canteen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visa.ncg.canteen.model.Car;
import com.visa.ncg.canteen.model.Part;
import com.visa.ncg.canteen.service.IService;

@RestController
public class SampleREST {
//	@Autowired
//	@Qualifier("svc2")
//	IService svc;
	
	@RequestMapping("/")
	public String helloRest() {
		return "Hey yo";
	}
	
	@RequestMapping(value = "/second", method = RequestMethod.GET)
	public String secondPage(@RequestParam("id") String name) {
		return "this is " + name;
	}
	
	@RequestMapping(value = "/third", method = RequestMethod.GET)
	public ResponseEntity<String> thirdPage(@RequestParam("id") String name) {
		HttpHeaders heads = new HttpHeaders();
		heads.add("omg bubba", "bubba value");
		return new ResponseEntity("third rest method " + name, heads, HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
	public Car m3() {
		
		Car car = new Car("BMW", "i8", 2018);
		List<Part> parts = new ArrayList<>();
		parts.add(new Part("door", 2));
		parts.add(new Part("panomara", 1));
		car.setParts(parts);
		return car;
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	public String m5(@RequestBody Car c) {
		return c.getModel();
	}
	
//	@RequestMapping("/svc")
//	public String m6() {
//		return svc.hello();
//	}
}
