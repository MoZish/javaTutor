package fact.it.restaurantappstart.repository;

import fact.it.restaurantappstart.model.Staff;
import fact.it.restaurantappstart.model.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findAllByOrderById();

    @Query("select w from Staff w where w.class = Waiter")
    List<Staff> findAllWaiter();

}
