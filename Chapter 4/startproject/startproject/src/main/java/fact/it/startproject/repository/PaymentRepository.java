package fact.it.startproject.repository;


import fact.it.startproject.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAllOrderByAmountAsc();

    //@Query("select p from Payment p where p.dtype == 'CashPayment'")
    //List<Payment> findAllCashPayments();
    @Query("select p from Payment p where p.amount > :amount")
    List<Payment> getByAmountGreaterThan(@Param("amount") double amount);

}
