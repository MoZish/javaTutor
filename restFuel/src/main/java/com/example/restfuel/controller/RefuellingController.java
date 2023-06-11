package com.example.restfuel.controller;

import com.example.restfuel.model.Refuelling;
import com.example.restfuel.model.RefuellingService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class RefuellingController {
    RefuellingService refuellingService;

    @PostConstruct
    public void init() {
        refuellingService = new RefuellingService();
        Refuelling refuelling1 = new Refuelling(1, 0, 1000, 55.0);
        Refuelling refuelling2 = new Refuelling(2, 1000, 1987, 52.0);
        Refuelling refuelling3 = new Refuelling(3, 1987, 2050, 57.0);

        refuellingService.addRefuelling(refuelling1);
        refuellingService.addRefuelling(refuelling2);
        refuellingService.addRefuelling(refuelling3);
    }

    @GetMapping("/refuellings")
    public List<Refuelling> getAllRefuellings() {
        return refuellingService.getRefuellingList();
    }

    //@PathVariable("id") int productId
    @GetMapping("/refuelling/{id}")
    public ResponseEntity<Refuelling> getRefuellingById(@PathVariable("id") int id) {
        Optional<Refuelling> refuellingOptional = refuellingService.getOptionalRefuellingById(id);
        if (refuellingOptional.isPresent()) {
            return new ResponseEntity<>(refuellingOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/refuelling/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Refuelling addNewRefuelling(@RequestBody Refuelling newRefuelling) {
        //int id = refuellingService.getRefuellingList().get(refuellingService.getRefuellingList().size()-1).getId() + 1;

        //addRefuelling(newRefuelling)
        //Refuelling addedRefuelling = new Refuelling(id, newRefuelling.getPreviousMilage(), newRefuelling.getCurrentMilage(), newRefuelling.getAmountInLitres());
        return refuellingService.addRefuelling(newRefuelling);

        //return refuellingService.getRefuellingList().get(refuellingService.getRefuellingList().size()-1);
    }

    @PutMapping("/refuelling/update/{id}")
    public ResponseEntity<Refuelling> updateOldRefuelling(@RequestBody Refuelling updateRefuelling, @PathVariable("id") int id){
        Refuelling updatingRefuelling = refuellingService.updateRefuellingById(updateRefuelling, id);
        if (updatingRefuelling == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatingRefuelling, HttpStatus.OK);
    }

    @DeleteMapping("/refuelling/delete/{id}")
    public ResponseEntity<Integer> deleteRefuelling(@PathVariable("id") int id) {
        Optional<Refuelling> refuellingOptional = refuellingService.getOptionalRefuellingById(id);
        if (refuellingOptional.isPresent()) {
            refuellingService.getRefuellingList().remove(refuellingOptional.get());
            return new ResponseEntity<>(refuellingService.getRefuellingList().size(), HttpStatus.OK);
        }
        return new ResponseEntity<>(refuellingService.getRefuellingList().size(),HttpStatus.NOT_FOUND);
    }

}
