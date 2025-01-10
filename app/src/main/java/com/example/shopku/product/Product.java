package com.example.shopku.product;
public class Product {
    private int imageResId;
    private String name;
    private String price;
    private String rate;
    private String description;

    public Product(int imageResId, String name, String price, String rate, String description) {
        this.imageResId = imageResId;
        this.name = name;
        this.price = price;
        this.rate = rate;
        this.description=description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getRate() {
        return rate;
    }
    public  String getDescription(){
        return description;
    }
}
