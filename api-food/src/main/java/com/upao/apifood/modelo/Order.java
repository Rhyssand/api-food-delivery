package com.upao.apifood.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;



public class Order {

    private String id;
    private String customerName;
    private String customerEmail;
    private String status;
    private LocalDateTime creationTime;
    private LocalDateTime estimatedDeliveryTime;
    private List<Food> items;

    public Order() {
    }

    public Order(String id, String customerName, String customerEmail, List<Food> items) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.items = items;
        this.status = "Listo";
        this.creationTime = LocalDateTime.now();
        this.estimatedDeliveryTime = this.creationTime.plusMinutes(15);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime time) {
        creationTime = time;
    }

    public LocalDateTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(LocalDateTime DeliveryTime) {
        estimatedDeliveryTime = DeliveryTime;
    }

    public List<Food> getItems() {
        return items;
    }

    public void setItems(List<Food> items) {
        this.items = items;
    }

    public double getTotal() {
        double total = 0;
        for (Food item : items) {
        total = total + item.getPrice();
        }
        return total;
    }
}

