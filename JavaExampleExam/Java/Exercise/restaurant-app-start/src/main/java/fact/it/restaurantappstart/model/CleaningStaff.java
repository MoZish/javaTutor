package fact.it.restaurantappstart.model;

public class CleaningStaff extends ExtraTask{

    public void clean(){
        System.out.printf("I am %s and now I start also with cleaning.\n", super.getStaff().getName());
    }
}
