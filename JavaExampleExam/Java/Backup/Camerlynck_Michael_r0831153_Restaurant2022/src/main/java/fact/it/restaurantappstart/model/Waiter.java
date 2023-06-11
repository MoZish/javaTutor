package fact.it.restaurantappstart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Waiter extends Staff{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Waiter() {
    }

    public Waiter(String name) {
        setName(name);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void update() {
        System.out.printf("I am %s and I start preparing the table for %s customers.\n", getName(), new EntranceCounter().getNumber());
    }
}
