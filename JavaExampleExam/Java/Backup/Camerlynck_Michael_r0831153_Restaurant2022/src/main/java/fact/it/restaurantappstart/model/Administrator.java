package fact.it.restaurantappstart.model;

public class Administrator extends ExtraTask {

    public void update() {
        super.update();
        System.out.printf("Next, I register the %s customers in the customer file.\n", new EntranceCounter().getNumber());
    }
}
