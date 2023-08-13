package poly.store.cart;

import lombok.Data;
import lombok.NoArgsConstructor;
import poly.store.entity.Product;

@NoArgsConstructor
@Data
public class CartItem {
	Integer id;
	String name;
	double price;
	String image;
	int quantity = 1;
	//tinh thanh tien soluong*gia
	public double getAmount() {
		return quantity*price;
	}
	public CartItem(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.image = product.getImage();
	}
}
