package training.race_horse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.race_horse.model.Trainer;
import training.race_horse.repository.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService{
    @Autowired
    private TrainerRepository trainerRepository;
    @Override
    public Iterable<Trainer> findAll() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer findById(Long id) {
        return trainerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        trainerRepository.deleteById(id);
    }

    @Override
    public Trainer save(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
}
