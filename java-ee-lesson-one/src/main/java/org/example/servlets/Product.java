package org.example.servlets;

public class Product {
    private static int count = 1;
    private int id;
    private int cost;
    private String title;

    public Product(int cost, String title) {
        id = count++;
        this.cost = cost;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }
}
