package org.example.abstractModel;

public class Metadata {

    private String name;
    private String description;
    private Float price;

    public Metadata(String name, String description, Float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name = '" + name + '\'' +
                ", description = '" + description + '\'' ;
    }



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }
}
