package poly.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.store.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, String> {

}
