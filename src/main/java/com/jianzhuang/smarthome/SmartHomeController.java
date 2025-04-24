import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartHomeController {
    private final Map<String, Appliance> appliances = new HashMap<>();

    public void addAppliance(Appliance appliance) {
        appliances.put(appliance.getName(), appliance);
    }

    public void turnOffAll() {
        appliances.values().forEach(Appliance::turnOff);
        System.out.println("All appliances are turned off.");
    }

    public void turnOnAll() {
        appliances.values().forEach(Appliance::turnOn);
        System.out.println("All appliances are turned on.");
    }

    public List<Appliance> getAppliances() {
        return appliances.values().stream().toList();
    }

    public void turnOnAppliance(String name) {
        if (appliances.containsKey(name)) {
            appliances.get(name).turnOn();
        }
        else {
            throw new IllegalArgumentException(name + " does not exist in this smart home.");
        }
    }

    public void turnOffAppliance(String name) {
        if (appliances.containsKey(name)) {
            appliances.get(name).turnOff();
        }
        else {
            throw new IllegalArgumentException(name + " does not exist in this smart home.");
        }
    }

    public String getStatus(String name) {
        if (appliances.containsKey(name)) {
            return appliances.get(name).getStatus();
        }
        else {
            throw new IllegalArgumentException(name + " does not exist in this smart home.");
        }
    }

    public void setFanSpeed(String name, int speed) {
        Appliance appliance = appliances.get(name);
        if (appliance instanceof Fan) {
            ((Fan) appliance).setSpeed(speed);
        }
        else {
            throw new IllegalArgumentException(name + " does not exist or is not Fan.");
        }
    }

    public void setAirConditionerMode(String name, AirConditioner.AC_MODE mode) {
        Appliance appliance = appliances.get(name);
        if (appliance instanceof AirConditioner) {
            ((AirConditioner) appliance).setMode(mode);
        }
        else {
            throw new IllegalArgumentException(name + " does not exist or is not Air Conditioner.");
        }
    }

    public void printStatus() {
        appliances.values().forEach(appliance -> System.out.println(appliance.getName()  + " is " + (appliance.isOn() ? "On" : "Off" + ".")));
    }
}
