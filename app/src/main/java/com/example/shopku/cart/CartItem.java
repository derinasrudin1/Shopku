package com.example.shopku.cart;

public class CartItem {
    private String name;
    private String details;
    private int price;
    private int quantity;
    private boolean isSelected;
    private int imageResource;

    public CartItem(String name, String details, int price, int quantity, boolean isSelected,int imageResource) {
        this.name = name;
        this.details = details;
        this.price = price;
        this.quantity = quantity;
        this.isSelected = isSelected;
        this.imageResource = imageResource;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { isSelected = selected; }
    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
