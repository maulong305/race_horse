package training.race_horse.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private Long status;
//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<Account> accounts;
//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(
//            name = "horse_account",
//            joinColumns = {@JoinColumn(name = "account_id")},
//            inverseJoinColumns = {@JoinColumn (name = "horse_id")}
//    )
//    Set<Horse> horses = new HashSet<>();
}
