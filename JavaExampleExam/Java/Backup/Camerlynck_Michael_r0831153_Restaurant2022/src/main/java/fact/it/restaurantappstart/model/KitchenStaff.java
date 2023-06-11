package fact.it.restaurantappstart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KitchenStaff extends Staff{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public KitchenStaff() {
    }

    public KitchenStaff(String name) {
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
        System.out.printf("I am %s and I start now with preparing %s appetizers!\n", getName(), new EntranceCounter().getNumber());
    }
}
