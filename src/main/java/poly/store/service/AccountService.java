package poly.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.AccountDAO;

@Service
public class AccountService {
	@Autowired
	AccountDAO dao;
}
