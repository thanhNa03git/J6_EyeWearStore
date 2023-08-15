package poly.store.entity;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import org.springframework.context.annotation.Lazy;

@SuppressWarnings("serial")
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

	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authority> authorities;

	@OneToMany(mappedBy = "account")
	List<Order> orders;
}
