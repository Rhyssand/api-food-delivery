package com.upao.apifood.service;

import com.upao.apifood.modelo.Order;
import com.upao.apifood.request.OrderRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public Order createOrder(OrderRequest orderRequest) {
        if (orderRequest.getItems().isEmpty()) {
            throw new IllegalArgumentException("La lista no puede estar vacía");
        }

        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("Procesando");
        order.setCreationTime(LocalDateTime.now());
        order.setEstimatedDeliveryTime(LocalDateTime.now().plusMinutes(30));
        order.setItems(orderRequest.getItems());
        orders.add(order);
        return order;
    }

    public String getOrderStatus(String orderId) {
        Order order = findOrderById(orderId);
        if (order != null) {
            return order.getStatus();
        } else {
            throw new OrderNotFoundException("Error, no se encontro el pedido");
        }
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order findOrderById(String orderNumber) {
        return orders.stream().filter(order -> orderNumber.equals(order.getId())).findFirst().orElse(null);
    }

    public static class OrderNotFoundException extends RuntimeException {
        public OrderNotFoundException(String message) {
            super(message);
        }
    }
}
