package ua.lviv.iot.rest_for_web_labs.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String model;
    private Integer price;

    public Car(int id, String name, String model, int price) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public Car(){}
}
