package fact.it.restaurantappstart.repository;

import fact.it.restaurantappstart.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
