package fact.it.restaurantappstart.model;

import javax.persistence.*;

@Entity
public class KitchenStaff extends Staff{

    public KitchenStaff() {
    }

    public KitchenStaff(String name) {
        setName(name);
    }

    public void update() {
        System.out.printf("I am %s and I start now with preparing %s appetizers!\n", getName(), EntranceCounter.getInstance().getNumber());
    }
}
