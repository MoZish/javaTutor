package fact.it.restaurantappstart.controller;

import fact.it.restaurantappstart.model.*;
import fact.it.restaurantappstart.repository.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class MainController {
    private final DishRepository dishRepository;
    private final TableRepository tableRepository;
    private final StaffRepository staffRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public MainController(DishRepository dishRepository,
                          TableRepository tableRepository,
                          StaffRepository staffRepository,
                          OrderRepository orderRepository,
                          OrderItemRepository orderItemRepository) {
        this.dishRepository = dishRepository;
        this.tableRepository = tableRepository;
        this.staffRepository = staffRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @RequestMapping("/manage_staff")
    public String manageStaff(Model model) {
        List<Staff> list = staffRepository.findAllByOrderById();
        model.addAttribute("allStaff", list);

        return "manage_staff";
    }

    @RequestMapping("/add_staff")
    public String addStaff(HttpServletRequest request, Model model) {
        String staffName = request.getParameter("name");
        String type = request.getParameter("type");

        if (Objects.equals(type, "waiter")) {
            Waiter waiter = new Waiter();
            waiter.setName(staffName);
            staffRepository.save(waiter);
        } else {
            KitchenStaff kitchenStaff = new KitchenStaff();
            kitchenStaff.setName(staffName);
            staffRepository.save(kitchenStaff);
        }

        List<Staff> list = staffRepository.findAllByOrderById();
        model.addAttribute("allStaff", list);

        return "manage_staff";
    }

    @RequestMapping("/manage_orders")
    public String manageOrders(Model model) {
        List<Order> list = orderRepository.findAllByOrderById();
        model.addAttribute("allOrders", list);

        return "manage_orders";
    }

    @RequestMapping("/search")
    public String search(Model model){
        List<Table> tables = tableRepository.findAll();
        model.addAttribute("tables", tables);
        return "/search";
    }

    @RequestMapping("process_search")
    public String processSearch(HttpServletRequest request, Model model) {
//        Long tableId = Long.valueOf(request.getParameter("table"));
//        LocalDate date = LocalDate.parse(request.getParameter("date"));
//        int total = Integer.parseInt(request.getParameter("parameter"));
//
//        Table table = tableRepository.findById(tableId).get();
        List<Order> list = orderRepository.findAllByOrderById();
//        list = list.stream().filter(o -> o.getTable() == table).toList();

//        if (request.getParameterMap().containsKey("table")) {
//            System.out.println("Test");
//        }

        if (!Objects.equals(request.getParameter("table"), "all")) {
            Long tableId = Long.valueOf(request.getParameter("table"));
            Table table = tableRepository.findById(tableId).get();
            list = list.stream().filter(o -> o.getTable() == table).toList();
        }

        if (!Objects.equals(request.getParameter("date"), "")) {
            LocalDate date = LocalDate.parse(request.getParameter("date"));

            // Search feature not done
//            switch (request.getParameter("dateParam")) {
//                case ""
//            }

        } else {
            System.out.println("EMPTY");
        }

        model.addAttribute("allOrders", list);

        return "manage_orders";
    }

    @RequestMapping("/details")
    public String detail(HttpServletRequest request, Model model) {
        Long orderId = Long.valueOf(request.getParameter("orderId"));
        Order order = orderRepository.findById(orderId).get();
        List<Dish> dishes = dishRepository.findAllByOrderByName();

        model.addAttribute("order", order);
        model.addAttribute("dishes", dishes);

        return "details";
    }

    @RequestMapping("/add_order_item")
    public String addOrderItem(HttpServletRequest request, Model model) {
        Long orderLongId = Long.valueOf(request.getParameter("orderId"));
        Long dishId = Long.valueOf(request.getParameter("dish"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Dish dish = dishRepository.findById(dishId).get();
        Order order = orderRepository.findById(orderLongId).get();

        if (Objects.equals(request.getParameter("happyHour"), "on")) {
            order.setPaymentStrategy(new HappyHourPayment());
        } else {
            order.setPaymentStrategy(new NormalPayment());
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setDish(dish);
        orderItem.setQuantity(quantity);
        orderItem.setAppliedPrice(order.getPaymentStrategy().getAppliedPrice(dish.getCurrentPrice()));

        orderRepository.save(order);
        order.addItem(dish, quantity);
        orderItemRepository.save(orderItem);

        List<Dish> dishes = dishRepository.findAllByOrderByName();

        model.addAttribute("order", order);
        model.addAttribute("dishes", dishes);

        return "details";
    }

    @RequestMapping("/add_order")
    public String addOrder(Model model) {
        List<Staff> waiters = staffRepository.findAllWaiter();
        List<Table> tables = tableRepository.findAll();

        model.addAttribute("waiters", waiters);
        model.addAttribute("tables", tables);

        return "new_order";
    }

    @RequestMapping("/process_new_order")
    public String processNewOrder(HttpServletRequest request, Model model) {
        Long tableId = Long.valueOf(request.getParameter("table"));
        Long waiterId = Long.valueOf(request.getParameter("waiter"));
        Waiter waiter = (Waiter) staffRepository.findById(waiterId).get();
        Table table = tableRepository.findById(tableId).get();

        Order order = new Order();
        order.setPayed(false);
        order.setDate(LocalDate.now());
        order.setWaiter(waiter);
        order.setTable(table);
        orderRepository.save(order);

        List<Dish> dishes = dishRepository.findAllByOrderByName();

        model.addAttribute("order", order);
        model.addAttribute("dishes", dishes);

        return "details";
    }

    @RequestMapping("/pay")
    public String pay(HttpServletRequest request, Model model) {
        Long orderLongId = Long.valueOf(request.getParameter("orderId"));
        Order order = orderRepository.findById(orderLongId).get();

        order.setPayed(true);
        orderRepository.save(order);

        List<Dish> dishes = dishRepository.findAllByOrderByName();

        model.addAttribute("dishes", dishes);
        model.addAttribute("order", order);

        return "details";
    }

    @RequestMapping("/dummy_data")
    public String dummyData(Model model) {

        // Make dishes
        Dish dish1 = new Dish();
        Dish dish2 = new Dish();
        Dish dish3 = new Dish();
        Dish dish4 = new Dish();
        Dish dish5 = new Dish();
        dish1.setName("Fries");
        dish2.setName("Fried Chicken");
        dish3.setName("Pizza");
        dish4.setName("Sandwich");
        dish5.setName("Lobster");
        dish1.setCurrentPrice(3.20);
        dish2.setCurrentPrice(4);
        dish3.setCurrentPrice(6.10);
        dish4.setCurrentPrice(3.50);
        dish5.setCurrentPrice(10.90);
        dishRepository.save(dish1);
        dishRepository.save(dish2);
        dishRepository.save(dish3);
        dishRepository.save(dish4);
        dishRepository.save(dish5);

        // Make tables
        Table table1 = new Table();
        Table table2 = new Table();
        Table table3 = new Table();
        Table table4 = new Table();
        Table table5 = new Table();
        table1.setCode("A1");
        table2.setCode("A2");
        table3.setCode("A3");
        table4.setCode("A4");
        table5.setCode("A5");
        tableRepository.save(table1);
        tableRepository.save(table2);
        tableRepository.save(table3);
        tableRepository.save(table4);
        tableRepository.save(table5);

        // Make waiter
        Waiter waiter1 = new Waiter();
        Waiter waiter2 = new Waiter();
        Waiter waiter3 = new Waiter();
        Waiter waiter4 = new Waiter();
        Waiter waiter5 = new Waiter();
        waiter1.setName("WaiterBob");
        waiter2.setName("WaiterJoe");
        waiter3.setName("WaiterMarry");
        waiter4.setName("WaiterJenny");
        waiter5.setName("WaiterJohn");
        staffRepository.save(waiter1);
        staffRepository.save(waiter2);
        staffRepository.save(waiter3);
        staffRepository.save(waiter4);
        staffRepository.save(waiter5);
        // Make kitchen staff
        KitchenStaff kitchenStaff1 = new KitchenStaff();
        KitchenStaff kitchenStaff2 = new KitchenStaff();
        KitchenStaff kitchenStaff3 = new KitchenStaff();
        KitchenStaff kitchenStaff4 = new KitchenStaff();
        KitchenStaff kitchenStaff5 = new KitchenStaff();
        kitchenStaff1.setName("CookRick");
        kitchenStaff2.setName("CookTom");
        kitchenStaff3.setName("CookJane");
        kitchenStaff4.setName("CookMike");
        kitchenStaff5.setName("CookDaryl");
        staffRepository.save(kitchenStaff1);
        staffRepository.save(kitchenStaff2);
        staffRepository.save(kitchenStaff3);
        staffRepository.save(kitchenStaff4);
        staffRepository.save(kitchenStaff5);

        // Make order
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();
        Order order5 = new Order();

        order1.setDate(LocalDate.of(2022, 5, 16));
        order2.setDate(LocalDate.of(2022, 5, 16));
        order3.setDate(LocalDate.of(2022, 5, 16));
        order4.setDate(LocalDate.of(2022, 5, 16));
        order5.setDate(LocalDate.of(2022, 5, 16));

        order1.setPaymentStrategy(new NormalPayment());
        order2.setPaymentStrategy(new HappyHourPayment());
        order3.setPaymentStrategy(new HappyHourPayment());
        order4.setPaymentStrategy(new NormalPayment());
        order5.setPaymentStrategy(new HappyHourPayment());

        order1.setPayed(true);
        order2.setPayed(false);
        order3.setPayed(false);
        order4.setPayed(false);
        order5.setPayed(true);

        order1.setTable(table1);
        order2.setTable(table2);
        order3.setTable(table3);
        order4.setTable(table4);
        order5.setTable(table5);

        order1.setWaiter(waiter1);
        order2.setWaiter(waiter1);
        order3.setWaiter(waiter2);
        order4.setWaiter(waiter1);
        order5.setWaiter(waiter4);

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        orderRepository.save(order4);
        orderRepository.save(order5);

        order1.addItem(dish1, 2);
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setDish(dish1);
        orderItem1.setQuantity(2);
        orderItem1.setOrder(order1);
        orderItem1.setAppliedPrice(order1.getPaymentStrategy().getAppliedPrice(dish1.getCurrentPrice()));
        orderItemRepository.save(orderItem1);

        order2.addItem(dish2, 3);
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setDish(dish2);
        orderItem2.setQuantity(3);
        orderItem2.setOrder(order2);
        orderItem2.setAppliedPrice(order2.getPaymentStrategy().getAppliedPrice(dish2.getCurrentPrice()));
        orderItemRepository.save(orderItem2);

        order2.addItem(dish4, 1);
        OrderItem orderItem3 = new OrderItem();
        orderItem3.setDish(dish4);
        orderItem3.setQuantity(1);
        orderItem3.setOrder(order2);
        orderItem3.setAppliedPrice(order2.getPaymentStrategy().getAppliedPrice(dish4.getCurrentPrice()));
        orderItemRepository.save(orderItem3);

        order3.addItem(dish1, 4);
        OrderItem orderItem4 = new OrderItem();
        orderItem4.setDish(dish1);
        orderItem4.setQuantity(4);
        orderItem4.setOrder(order3);
        orderItem4.setAppliedPrice(order3.getPaymentStrategy().getAppliedPrice(dish1.getCurrentPrice()));
        orderItemRepository.save(orderItem4);

        order5.addItem(dish2, 2);
        OrderItem orderItem5 = new OrderItem();
        orderItem5.setDish(dish2);
        orderItem5.setQuantity(2);
        orderItem5.setOrder(order5);
        orderItem5.setAppliedPrice(order5.getPaymentStrategy().getAppliedPrice(dish2.getCurrentPrice()));
        orderItemRepository.save(orderItem5);

        model.addAttribute("message", "Dummy Data has been created");
        return "index";
    }
}
