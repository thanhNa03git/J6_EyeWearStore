package poly.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.store.entity.Category;
import poly.store.service.CategoryService;

@Controller
public class HomeController {
	@Autowired
	CategoryService service;
	
	@RequestMapping("/home/index")
	public String index() {
		return "home/index";
	}
	
	@RequestMapping("/home/about")
	public String about() {
		return "home/about";
	}

	@RequestMapping("/home/contact")
	public String contact() {
		return "home/contact";
	}

	public List<Category> getCategories() {
		return service.findAll();
	}
}
