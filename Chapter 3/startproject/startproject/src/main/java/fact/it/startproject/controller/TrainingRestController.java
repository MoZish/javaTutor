package fact.it.startproject.controller;

import fact.it.startproject.model.Training;
import fact.it.startproject.model.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class TrainingRestController {

    @Autowired
    TrainingRepository repository;

    @GetMapping("/training")
    public List<Training> getTrainings() {
        return repository.findAllByOrderByThemeAsc();
    }

    @GetMapping("/training/{id}")
    public ResponseEntity<Training> getTrainingById(@PathVariable("id") Long id) {

        Optional<Training> trainingOptional = repository.findById(id);
        if (trainingOptional.isPresent()) {
            return new ResponseEntity<> (trainingOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<> (HttpStatus.NOT_FOUND);
    }

    @GetMapping("/training/title")
    public List<Training> getTrainingByTitle (@RequestBody String title) {
        return repository.findAll().stream().filter(training -> training.getTitle().contains(title)).collect(Collectors.toList());
    }

    @PostMapping("/training")
    public Training createNewTraining(@RequestBody Training training) {
        return repository.save(training);
    }

    @DeleteMapping("/training/{id}")
    public ResponseEntity<Integer> deleteTraining (@PathVariable("id") Long id) {
        Optional<Training> trainingOptional = repository.findById(id);
        if (trainingOptional.isPresent()) {
            repository.delete(trainingOptional.get());
            return new ResponseEntity<>(repository.findAll().size(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/training/{id}")
    public ResponseEntity<Training> changeTraining ( @RequestBody Training updateTraining, @PathVariable("id") Long id) {
        Optional<Training> trainingOptional = repository.findById(id);
        if (trainingOptional.isPresent()) {
            Training training = trainingOptional.get();
            training.setTitle(updateTraining.getTitle());
            training.setTheme(updateTraining.getTheme());
            training.setCode(updateTraining.getCode());
            training.setMax(updateTraining.getMax());
            training.setDuration(updateTraining.getDuration());

            repository.save(training);

            return new ResponseEntity<>(training,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
