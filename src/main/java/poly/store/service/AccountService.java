package poly.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.AccountDAO;
import poly.store.entity.Account;

@Service
public class AccountService {
	@Autowired
	AccountDAO dao;

	public void create(Account account) {
		dao.save(account);
	}
	public Account findByUsername(String username) {
		return dao.findById(username).get();
	}

	public void update(Account account) {
		dao.save(account);
	}
}
