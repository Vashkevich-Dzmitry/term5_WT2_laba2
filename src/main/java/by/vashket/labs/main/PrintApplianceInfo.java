package by.vashket.labs.main;

import java.util.List;

import by.vashket.labs.entity.Appliance;

public class PrintApplianceInfo {

    public static void print(List<Appliance> appliances) {
        for (Appliance appliance : appliances) {
            System.out.println(appliance.toString());
        }
    }

}
