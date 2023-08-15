package poly.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import poly.store.dao.AccountDAO;
import poly.store.entity.Account;

@Service
public class AccountService {
	@Autowired
	AccountDAO dao;
//	@Autowired
//	PasswordEncoder passwordEncoder;

	public void create(Account account) {
		dao.save(account);
	}
	public Account findByUsername(String username) {
		return dao.findById(username).get();
	}
//	public void changePassword(Account account, String newPassword) {
//		account.setPassword(passwordEncoder.encode(newPassword));
//		dao.save(account);
//	}
	public void update(Account account) {
		dao.save(account);
	}
}
