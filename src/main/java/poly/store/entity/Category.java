package poly.store.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity 
@Table(name = "Categories")
public class Category{
	@Id
	Integer id;
	String name;

	@OneToMany(mappedBy = "category")
	List<Product> products;
}