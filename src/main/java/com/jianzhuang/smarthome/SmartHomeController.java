import java.util.ArrayList;
import java.util.List;

public class SmartHomeController {
    private final List<Appliance> appliances = new ArrayList<>();

    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    public void turnOffAll() {
        appliances.forEach(Appliance::turnOff);
        System.out.println("All appliances are turned off.");
    }

    public void turnOnAll() {
        appliances.forEach(Appliance::turnOn);
        System.out.println("All appliances are turned on.");
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    public void printStatus() {
        appliances.forEach(appliance -> System.out.println(appliance.getName()  + " is " + (appliance.isOn() ? "On" : "Off" + ".")));
    }
}
