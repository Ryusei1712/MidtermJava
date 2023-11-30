package com.example.midtermjava.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@NoArgsConstructor
@AllArgsConstructor
@Getter  @Setter
@Table(name = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private String brand;
    private String color;
    private int fan;
    private String power;
    private String accessory;
    private int cartQuantity;

    public Product(Long id, String name, int price, String brand, String color, int fan, String power, String accessory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.color = color;
        this.fan = fan;
        this.power = power;
        this.accessory = accessory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", fan=" + fan +
                ", powerSupply='" + power + '\'' +
                ", accessories='" + accessory + '\'' +
                '}';
    }
}