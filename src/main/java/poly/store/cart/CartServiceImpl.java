package poly.store.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import poly.store.entity.Product;
import poly.store.service.ProductService;

@SessionScope
@Service("cart")
public class CartServiceImpl implements CartService{
	@Autowired
	ProductService productService;

	//Chứa các mặt hàng trong map
	Map<Integer, CartItem> map = new HashMap<>();
	@Override
	public void add(Integer id) {
		CartItem item = map.get(id);
		if (item != null){
			item.setQuantity(item.getQuantity() + 1);
		}
		else {
			//lay san pham tu data base
			Product product = productService.findById(id);
			item = new CartItem(product);
			map.put(id, item);
		}
	}

	@Override
	public void remove(Integer id) {
		map.remove(id);
	}

	@Override
	public void update(Integer id, int qty) {
		CartItem item = map.get(id);
		item.setQuantity(qty);
	}

	@Override
	public void clear() {
		map.clear();
	}

	//lay cac mat hang trong gio hang
	@Override
	public Collection<CartItem> getItems() {
		return map.values();
	}

	//tongsoluong
	public int getTotalCount(){
		return this.getItems().stream().mapToInt(item -> item.quantity).sum();
	}
	//tong so tien
	public double getTotalAmount(){
		return this.getItems().stream().mapToDouble(item -> item.getAmount()).sum();
	}
}