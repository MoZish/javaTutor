package fact.it.restaurantappstart.repository;

import fact.it.restaurantappstart.model.Dish;
import fact.it.restaurantappstart.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findAllByOrderByName();
}
