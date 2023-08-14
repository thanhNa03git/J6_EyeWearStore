package poly.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.OrderDetailDAO;
import poly.store.entity.OrderDetail;

@Service
public class OrderDetailService {
	@Autowired
	OrderDetailDAO dao;

    public void create(OrderDetail detail) {
        dao.save(detail);
    }
}
