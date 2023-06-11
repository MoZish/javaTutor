package fact.it.restaurantappstart.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "table_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "orderdate")
    private LocalDate date;
    private boolean payed;

    @ManyToOne
    private Waiter waiter;
    @ManyToOne
    private Table table;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @Transient
    private PaymentStrategy paymentStrategy;

    public Order() {
        paymentStrategy = new NormalPayment();
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<OrderItem> getOrderItems() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void addItem(Dish dish, int quantity){
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(this);
        orderItem.setQuantity(quantity);
        orderItem.setDish(dish);
        orderItem.setAppliedPrice(this.paymentStrategy.getAppliedPrice(dish.getCurrentPrice()));
        orderItemList.add(orderItem);
    }

    public double getTotal(){
        double total = 0;
        for (OrderItem orderItem : orderItemList){
            total += orderItem.getAppliedPrice() * orderItem.getQuantity();
        }
        return total;
    }
}
