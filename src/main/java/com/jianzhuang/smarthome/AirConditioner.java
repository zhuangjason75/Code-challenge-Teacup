public class AirConditioner implements Appliance {

    public enum AC_MODE {
        OFF,
        COOL,
        HEAT
    };

    private AC_MODE mode = AC_MODE.OFF;

    @Override
    public void turnOn() {
        mode = AC_MODE.COOL;
    }

    @Override
    public void turnOff() {
        mode = AC_MODE.OFF;
    }

    @Override
    public boolean isOn() {
        return !AC_MODE.OFF.equals(mode);
    }

    public void setMode(AC_MODE mode) {
        this.mode = mode;
    }

    public AC_MODE getMode() {
        return mode;
    }

    @Override
    public String getName() {
        return "Air Conditioner";
    }

    @Override
    public String getStatus() {
        return getName() + " is in mode: " + mode;
    }
}
