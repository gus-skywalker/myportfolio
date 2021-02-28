package com.gus.makeandsell;

import java.util.ArrayList;

public class Pizza {

    private String name_pizza;
    private String ingredients;
    private String price;

    public String getName_pizza() {
        return name_pizza;
    }

    public void setName_pizza(String name_pizza) {
        this.name_pizza = name_pizza;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Pizza(String name_pizza, String ingredients, String price) {
        this.name_pizza = name_pizza;
        this.ingredients = ingredients;
        this.price = price;
    }
}
