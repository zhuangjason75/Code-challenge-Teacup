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
        else {
            throw new IllegalArgumentException("Speed can only be within 0 and 2");
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void increaseSpeed() {
        if (speed < 2) {
            speed++;
        }
    }

    public void decreaseSpeed() {
        if (speed > 0) {
            speed--;
        }
    }

    @Override
    public String getStatus() {
        return getName() + " is " + (isOn() ? "ON" : "OFF") + ", speed: " + speed;
    }
}
