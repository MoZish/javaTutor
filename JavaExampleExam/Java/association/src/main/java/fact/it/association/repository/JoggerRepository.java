package fact.it.association.repository;

import fact.it.association.model.Jogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoggerRepository extends JpaRepository<Jogger, Long> {
}
