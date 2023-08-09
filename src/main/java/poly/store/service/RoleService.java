package poly.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.store.dao.RoleDAO;

@Service
public class RoleService {
    @Autowired
    RoleDAO dao;
}
