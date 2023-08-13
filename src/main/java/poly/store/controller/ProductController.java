package poly.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.store.entity.Product;
import poly.store.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;

	//show tat ca sản phẩm
	@RequestMapping("/product/list/all")
	public String list(Model model) {
		List<Product> list = service.findAll();
		model.addAttribute("items",list);
		return "product/list";
	}
	//list category-show san pham theo loại hàng
	@RequestMapping("/product/list-by-category/{id}")
	public String listByCategory(Model model, @PathVariable("id") Integer id) {
		List<Product> list = service.findByCategoryId(id);
		model.addAttribute("items", list);
		return "product/list";
	}
	//gọi trang san phẩm chi tiết
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product product = service.findById(id);
		model.addAttribute("item", product);
		return "product/detail";
	}
}
