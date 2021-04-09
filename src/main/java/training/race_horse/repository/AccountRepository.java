package training.race_horse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import training.race_horse.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
