package fact.it.restaurantappstart.repository;

import fact.it.restaurantappstart.model.Dish;
import fact.it.restaurantappstart.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findAllByOrderByName();

    @Query("select d from Dish d where d.name like ':letter%'")
    List<Dish> findDishStartsWithLetter(@Param("letter") char letter);

    List<Dish> findByNameStartsWith(String search);
}
