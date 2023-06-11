package fact.it.startproject.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import fact.it.startproject.model.Training;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    //@Query("select b from Training b order by b.theme ASC")
    //List<Training> giveListOfAllTrainingsOrderedByTheme();
    List<Training> findAllByOrderByThemeAsc();
}
