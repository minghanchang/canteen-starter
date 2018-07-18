package com.visa.ncg.canteen.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.visa.ncg.canteen.model.Car;
import com.visa.ncg.canteen.service.IService;

@Controller
public class CarController {
	@Autowired
	//@Qualifier("svc2")
	private IService svc;
	
	@GetMapping("/carindex.html")
	public String getIndex() {
		return "carindex";
	}
	
	@GetMapping("/")
	public String getRoot() {
		return "redirect:/carindex.html";
	}
	
	@RequestMapping("/carbrowse")
	public ModelAndView browse() {
		Collection<Car> cars = svc.getCars();
		return new ModelAndView("carbrowse", "carlist", cars);
	}
	
	@ModelAttribute("date")
	public Date getDate() {
		return new Date();
	}
}
