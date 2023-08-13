package poly.store.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Authorities", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Username", "Roleid"})
})
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne @JoinColumn(name = "Username")
    private Account account;

    @ManyToOne  @JoinColumn(name = "Roleid")
    private Role role;
}
