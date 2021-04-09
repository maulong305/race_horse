package training.race_horse.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import training.race_horse.model.Horse;

import java.util.List;

@Repository
public interface HorseRepository extends CrudRepository<Horse, Long>, HorseRepositoryCustom {
//    @Query(value = "select * from horse " +
//            "join horse_accounts ha on horse.id = ha.horse_id " +
//            "join trainer t on ha.accounts_id = t.account_id " +
//            "where t.id = ?1", nativeQuery = true)
//    Iterable<Horse> findAllByTrainerId(Long id);

//    @Query(value = "select h from Horse h " +
//            "inner join h.accounts a " +
//            "inner join Trainer t on t.account = a " +
//            "where t.id = ?1")
    //Iterable<Horse> findAllByABC(Long id);
//    Iterable<Horse> findAllByHorseOfTrainer(Long id);

}
