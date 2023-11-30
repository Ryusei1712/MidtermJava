package com.example.midtermjava;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String productName;
    private float price;
    private String illustration;
    private String description;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", illustration='" + illustration + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}