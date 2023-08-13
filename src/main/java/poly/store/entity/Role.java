package poly.store.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "role")
    List<Authority> authorities;
}
