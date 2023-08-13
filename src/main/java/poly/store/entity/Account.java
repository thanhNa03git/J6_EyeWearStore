package poly.store.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity 
@Table(name = "Accounts")
public class Account{
	@Id
	String username;
	String password;
	String fullname;
	String email;
	String photo;

	@OneToMany(mappedBy = "account")
	List<Order> orders;
}
