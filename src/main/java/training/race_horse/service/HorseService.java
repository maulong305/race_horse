package training.race_horse.service;

import training.race_horse.model.Horse;

import java.util.Set;

public interface HorseService extends IService<Horse> {
    Iterable<Horse> findByTrainerId(Long id, String name);
}
