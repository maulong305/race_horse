package training.race_horse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.race_horse.model.Account;
import training.race_horse.model.Horse;
import training.race_horse.model.Trainer;
import training.race_horse.repository.HorseRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HorseServiceImpl implements HorseService{
    @Autowired
    private HorseRepository horseRepository;
    @Override
    public Iterable<Horse> findAll() {
        Iterable<Horse> horses = horseRepository.findAll();
        return horses;
    }

    @Override
    public Horse findById(Long id) {
        return horseRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        horseRepository.deleteById(id);
    }

    @Override
    public Horse save(Horse horse) {
        return horseRepository.save(horse);
    }

    @Override
    public Iterable<Horse> findByTrainerId(Long id, String name) {
//        Set<Long> objects = new HashSet<>();
//        objects.add(id);
//        List<Horse> trainers =  horseRepository.findAllByTrainerId(ids);
//        return trainers.stream().map(Account::getHorses).flatMap(Collection::stream).collect(Collectors.toList());
        return horseRepository.findAllByTrainerId(id, name);
    }
}
