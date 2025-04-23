public class AirConditioner implements Appliance {
    private String mode = "off";

    @Override
    public void turnOn() {
        mode = "cool";
    }

    @Override
    public void turnOff() {
        mode = "off";
    }

    @Override
    public boolean isOn() {
        return !"off".equalsIgnoreCase(mode);
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String getName() {
        return "Air Conditioner";
    }
}
