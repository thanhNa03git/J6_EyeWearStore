package poly.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.store.dao.AuthorityDAO;
@Service
public class AuthorityService {
    @Autowired
    AuthorityDAO dao;
}
