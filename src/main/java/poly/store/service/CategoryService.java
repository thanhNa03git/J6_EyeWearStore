package poly.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.CategoryDAO;
import poly.store.entity.Category;

@Service
public class CategoryService {
	@Autowired
	CategoryDAO dao;
//trả về toàn bộ danh mục hàng hóa
	public List<Category> findAll() {
		return dao.findAll();
	}
}
