package fact.it.restaurantappstart.controller;

import fact.it.restaurantappstart.model.Dish;
import fact.it.restaurantappstart.repository.DishRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestaurantRestController {
    private final DishRepository dishRepository;

    public RestaurantRestController(DishRepository dishRepository){
        this.dishRepository = dishRepository;
    }

    @GetMapping("/dishes")
    public List<Dish> getAllDishes(){
        return dishRepository.findAll();
    }

    @GetMapping("/dishes/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable("id") int dishId){
        Optional<Dish> dishCheck = dishRepository.findById((long) dishId);
        return dishCheck.map(dish -> new ResponseEntity<>(dish, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/dishes/search")
    public List<Dish> getDishBySearch(@RequestBody String search){
        return dishRepository.findByNameStartsWith(search);
    }
}
