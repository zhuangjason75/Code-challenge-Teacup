public class Fan implements Appliance {
    private int speed = 0; // 0 = off

    @Override
    public void turnOn() {
        speed = 1;
    }

    @Override
    public void turnOff() {
        speed = 0;
    }

    @Override
    public boolean isOn() {
        return speed > 0;
    }

    @Override
    public String getName() {
        return "Fan";
    }

    public void setSpeed(int speed) {
        if (speed >= 0 && speed <= 2) {
            this.speed = speed;
        }
    }
}
