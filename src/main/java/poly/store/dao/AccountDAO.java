package poly.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import poly.store.entity.Account;
@Repository
public interface AccountDAO extends JpaRepository<Account, String> {

}
