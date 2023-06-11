package fact.it.restaurantappstart.model;

import javax.persistence.Entity;

@Entity
public class KitchenStaff extends Staff{
    public KitchenStaff() {

    }

    public KitchenStaff(String name) {
        this.setName(name);
    }

    public void update(){
        System.out.printf("I am %s and I start now with preparing %s appetizers!\n", this.getName(), EntranceCounter.getInstance().getNumber());
    }
}
