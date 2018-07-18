package com.visa.ncg.canteen.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.visa.ncg.canteen.model.Car;
import com.visa.ncg.canteen.service.IService;

@Controller
public class CarController {
	@Autowired
	private IService svc;
	
	@GetMapping("/carindex.html")
	public String getIndex() {
		return "carindex";
	}
	
	@GetMapping("/")
	public String getRoot() {
		return "redirect:/carindex.html";
	}
	
	@RequestMapping("/browse")
	public ModelAndView browse() {
		Collection<Car> cars = svc.getCars();
		return new ModelAndView("browse", "carlist", cars);
	}
}
