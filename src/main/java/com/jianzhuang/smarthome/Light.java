public class Light implements Appliance {
    private boolean isSwitchOn = false;

    @Override
    public void turnOn() {
        isSwitchOn = true;
    }

    @Override
    public void turnOff() {
        isSwitchOn = false;
    }

    @Override
    public boolean isOn() {
        return isSwitchOn;
    }

    @Override
    public String getName() {
        return "Light";
    }

    @Override
    public String getStatus() {
        return getName() + " is " + (isSwitchOn ? "ON" : "OFF");
    }
}
