package com.gus.makeandsell;

public class Ingredient {

    private int id;
    private String name;
    private double qty;
    private double price;

    //constructors
    public Ingredient(int id, String name, double qty, double price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public Ingredient() {
    }

    // toString is necessary for printing the contents of a class object
    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
