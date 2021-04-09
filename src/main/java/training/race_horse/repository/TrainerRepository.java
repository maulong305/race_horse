package training.race_horse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import training.race_horse.model.Trainer;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Long> {
}
