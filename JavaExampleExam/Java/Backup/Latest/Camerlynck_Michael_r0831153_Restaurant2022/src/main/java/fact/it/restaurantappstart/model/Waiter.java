package fact.it.restaurantappstart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Waiter extends Staff{
    public Waiter() {
    }

    public Waiter(String name) {
        setName(name);
    }

    public void update() {
        System.out.printf("I am %s and I start preparing the table for %s customers.\n", getName(), EntranceCounter.getInstance().getNumber());
    }
}
