package by.vashket.labs.entity;

import java.util.ArrayList;

public class Speakers extends Appliance {
    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private int cordLength;

    public Speakers(int powerConsumption, int numberOfSpeakers, String frequencyRange, int cordLength, int price) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
        this.setPrice(price);
    }

    public static Speakers createInstance(ArrayList<String> params) {
        return new Speakers(
                Integer.parseInt(params.get(0)),
                Integer.parseInt(params.get(1)),
                params.get(2),
                Integer.parseInt(params.get(3)),
                Integer.parseInt(params.get(4))
        );
    }

    public Object getFieldByName(String name) {
        return switch (name) {
            case "POWER_CONSUMPTION" -> powerConsumption;
            case "NUMBER_OF_SPEAKERS" -> numberOfSpeakers;
            case "FREQUENCY_RANGE" -> frequencyRange;
            case "CORD_LENGTH" -> cordLength;
            case "PRICE" -> getPrice();
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRange='" + frequencyRange + "'" +
                ", cordLength=" + cordLength +
                ", price=" + getPrice() +
                '}';
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }
}