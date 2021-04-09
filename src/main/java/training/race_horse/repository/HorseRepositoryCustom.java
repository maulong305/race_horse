package training.race_horse.repository;

import training.race_horse.model.Account;
import training.race_horse.model.Horse;

import java.util.List;
import java.util.Set;

public interface HorseRepositoryCustom {
//    List<Horse> findAllByTrainerId(Set<Long> ids);
    List<Horse> findAllByTrainerId(Long id, String name);

}
