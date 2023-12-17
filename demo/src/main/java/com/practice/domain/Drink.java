package com.practice.domain;

public class Drink {
    
    private String name;
    private String description;
    private int price;
    private int calories;

    public Drink() {
    }

    public Drink(String name, String description, int price, int calories) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.calories = calories;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrice() {
        return this.price;
    }

    public int getCalories() {
        return this.calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        if (description.length() > 100) {
            throw new IllegalArgumentException("Description must be less than 100 characters.");
        }
        this.description = description;
    }

    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }
        this.price = price;
    }

    public void setCalories(int calories) {
        if (calories < 0) {
            throw new IllegalArgumentException("Calories must be greater than 0.");
        }
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price='" + getPrice() + "'" +
            ", calories='" + getCalories() + "'" +
            "}";
    }

}
