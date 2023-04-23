package com.upao.apifood.modelo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Table(name = "menu")
@Data
@NoArgsConstructor
@ToString

public class Food {
    private String name;
    private String description;
    private double price;


    public Food(String name, String description, double price) {
        setName(name);
        setDescription(description);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        name = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripcion no puede estar vacia");
        }
        description = descripcion;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double precio) {
        if (price < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        price = precio;
    }

}
