package fact.it.startproject.repository;

import fact.it.startproject.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

    @Query("select t from Tenant t where t.income < :income")
    List<Tenant> getTenantsWithIncome(@Param("income") double income);
}
