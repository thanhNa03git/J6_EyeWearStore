package poly.store.cart;

import poly.store.entity.Product;

import java.util.Collection;

public interface CartService {
	void add(Integer id);
	void remove(Integer id);
	void update(Integer id, int qty);
	void clear();
	Collection<CartItem> getItems();
	int getTotalCount();
	double getTotalAmount();
}