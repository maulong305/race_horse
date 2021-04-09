package training.race_horse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.race_horse.model.Horse;
import training.race_horse.model.Trainer;
import training.race_horse.service.HorseService;
import training.race_horse.service.TrainerService;

import java.util.*;

@RestController
@RequestMapping("/horses/")
public class HorseController {
    @Autowired
    HorseService horseService;
    @Autowired
    TrainerService trainerService;

//    show all horse
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Horse>> listHorses(){
        Iterable<Horse> horses = horseService.findAll();
        if (horses.equals(null)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(horses, HttpStatus.OK);
        }
    }

//    Create Horse
    Date currentTime = Calendar.getInstance().getTime();
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Horse> createHorse(@RequestBody Horse horse){
        horse.setFoaled(currentTime);
        horseService.save(horse);
        return new ResponseEntity<>(horse, HttpStatus.OK);
    }

//    Update Horse
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Horse> updateHorse(@RequestBody Horse horse){
        if (horse.equals(null)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            horse.setFoaled(currentTime);
            horseService.save(horse);
            return new ResponseEntity<>(horse, HttpStatus.OK);
        }
    }


//    Remove Horse
    @RequestMapping(value = "remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> remove(@PathVariable Long id){
        Horse horse = horseService.findById(id);
        if (horse.equals(null)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            horseService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @RequestMapping(value = "showAllHorseOfTrainer", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Horse>> showAllHorseOfTrainerById(@RequestParam("trainerId") Long id, @RequestParam("horseName") String name){
        Trainer trainer = trainerService.findById(id);
//        Set<Long> ids = new HashSet<>();
//        ids.add(id);
        //Collections.singleton(id);
        Iterable<Horse> horses = horseService.findByTrainerId(id, name);
        if (trainer == null || horses == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(horses, HttpStatus.OK);
        }

    }

}
