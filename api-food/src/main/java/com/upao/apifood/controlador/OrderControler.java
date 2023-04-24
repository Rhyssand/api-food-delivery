package com.upao.apifood.controlador;

import com.upao.apifood.modelo.Food;
import com.upao.apifood.modelo.Order;
import com.upao.apifood.request.OrderRequest;
import com.upao.apifood.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


public class OrderControler {
    private List<Food> menu = new ArrayList<>();

    public OrderControler() {
        menu.add(new Food("Ensala de frutas",
                "Ensala con manzanas, papaya, platano, mandarina, uvas", 4.00));
        menu.add(new Food("Pizza familiar",
                "Pizza con carne, champiñones y piña", 54.45));
        menu.add(new Food("Jugo",
                "Jugo de papaya", 1.50));
        menu.add(new Food("Jugo",
                "Jugo de piña", 2.00));
    }


    private OrderService orderService;

    @GetMapping( "/menu")
    public List<Food> getMenu() {
        return menu;
    }

    @PostMapping("/create")
    public Order createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping("/status")
    public String getOrderStatus(@PathVariable String orderId) {
        return orderService.getOrderStatus(orderId);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(@PathVariable String orderId, @RequestBody Order order) {
        Order orderobjet = orderService.findOrderById(orderId);

        if (orderobjet != null) {
            orderobjet.setStatus(order.getStatus());
            return ResponseEntity.ok().body(orderobjet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
