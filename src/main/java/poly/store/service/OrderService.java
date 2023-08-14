package poly.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.OrderDAO;
import poly.store.entity.Order;

@Service
public class OrderService {
	@Autowired
	OrderDAO dao;

    public void creat(Order order) {
        dao.save(order);
    }

    public Order findById(Long id) {
        return dao.findById(id).get();
    }
}
