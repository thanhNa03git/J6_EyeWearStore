package poly.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.OrderDetailDAO;

@Service
public class OrderDetailService {
	@Autowired
	OrderDetailDAO dao;
}
