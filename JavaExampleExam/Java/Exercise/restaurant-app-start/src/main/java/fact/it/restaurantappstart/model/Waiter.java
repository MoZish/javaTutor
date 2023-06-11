package fact.it.restaurantappstart.model;

import javax.persistence.Entity;

@Entity
public class Waiter extends Staff{
    public Waiter() {

    }
    public Waiter(String name) {
        this.setName(name);
    }

    public void update(){
        System.out.printf("I am %s and I start preparing the table for %s customers.\n", this.getName(), EntranceCounter.getInstance().getNumber());
    }
}
