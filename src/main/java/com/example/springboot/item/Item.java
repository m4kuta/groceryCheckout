package com.example.springboot.item;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Item {
    @Id
//    @SequenceGenerator(
//            name = "item_sequence",
//            sequenceName = "item_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            generator = "item_sequence",
//            strategy = GenerationType.SEQUENCE
//    )
    @Getter
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private Integer stock;
    @Getter @Setter
    private Double price;

    public Item(Long id, String name, String description, Integer stock, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public Item(String name, String description, Integer stock, Double price) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public Item() {

    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
