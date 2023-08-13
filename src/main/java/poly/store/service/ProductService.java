package poly.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.ProductDAO;
import poly.store.entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductDAO dao;

	public List<Product> findAll() {
		List<Product> list = dao.findAll();
		return list;
	}

	public Product findById(Integer id) {
		Product product = dao.findById(id).get();
		return product;
	}

	public List<Product> findByCategoryId(Integer id) {
		List<Product> list = dao.findByCategoryId(id);
		return list;
	}
}
