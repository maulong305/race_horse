package training.race_horse.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date foaled;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Account> accounts;
//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(
//            name = "horse_account",
//            joinColumns = {@JoinColumn(name = "horse_id")},
//            inverseJoinColumns = {@JoinColumn (name = "account_id")}
//    )
//    @ManyToMany(mappedBy = "horses")
//    Set<Trainer> trainers = new HashSet<>();

}
