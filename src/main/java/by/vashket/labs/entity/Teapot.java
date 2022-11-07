package by.vashket.labs.entity;

import java.util.ArrayList;

public class Teapot extends Appliance {

    private int powerConsumption;
    private int capacity;
    private String material;
    private String color;

    public Teapot(int powerConsumption, int capacity, String material, String color, int price) {
        this.powerConsumption = powerConsumption;
        this.capacity = capacity;
        this.material = material;
        this.color = color;
        this.setPrice(price);
    }

    public static Teapot createInstance(ArrayList<String> params) {
        return new Teapot(
                Integer.parseInt(params.get(0)),
                Integer.parseInt(params.get(1)),
                params.get(2),
                params.get(3),
                Integer.parseInt(params.get(4))
        );
    }

    public Object getFieldByName(String name) {
        return switch (name) {
            case "POWER_CONSUMPTION" -> powerConsumption;
            case "CAPACITY" -> capacity;
            case "MATERIAL" -> material;
            case "COLOR" -> color;
            case "PRICE" -> getPrice();
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "Teapot{" +
                "powerConsumption=" + powerConsumption +
                ", capacity=" + capacity +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", price=" + getPrice() +
                '}';
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
