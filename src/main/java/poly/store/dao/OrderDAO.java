package poly.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.store.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {

}
