package com.gaoby.java8;

import lombok.Data;

@Data
public class Apple {
    private String color;
    private Double weight;

    public Apple(String color, Double weight) {
        this.color = color;
        this.weight = weight;
    }
}
