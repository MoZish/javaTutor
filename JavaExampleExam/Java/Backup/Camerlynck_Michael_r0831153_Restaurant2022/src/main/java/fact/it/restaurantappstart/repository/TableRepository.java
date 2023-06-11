package fact.it.restaurantappstart.repository;

import fact.it.restaurantappstart.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}
