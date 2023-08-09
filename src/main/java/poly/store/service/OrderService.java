package poly.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.OrderDAO;

@Service
public class OrderService {
	@Autowired
	OrderDAO dao;
}
