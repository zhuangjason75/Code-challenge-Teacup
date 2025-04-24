import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SmartHomeControllerTest {

    @Test
    public void testTurnOffAllDevices() {
        SmartHomeController controller = new SmartHomeController();
        Appliance light = new Light();
        Appliance fan = new Fan();
        Appliance ac = new AirConditioner();

        controller.addAppliance(light);
        controller.addAppliance(fan);
        controller.addAppliance(ac);

        controller.turnOnAll();
        Assertions.assertTrue(light.isOn());
        Assertions.assertTrue(fan.isOn());
        Assertions.assertTrue(ac.isOn());

        controller.turnOffAll();

        Assertions.assertFalse(light.isOn());
        Assertions.assertFalse(fan.isOn());
        Assertions.assertFalse(ac.isOn());
    }

    @Test
    public void testTurnOnTurnOffOneDevice() {
        SmartHomeController controller = new SmartHomeController();

        Appliance light = new Light();
        Appliance fan = new Fan();
        Appliance ac = new AirConditioner();

        controller.addAppliance(light);
        controller.addAppliance(fan);
        controller.addAppliance(ac);

        Assertions.assertFalse(light.isOn());
        controller.turnOnAppliance(light.getName());
        Assertions.assertTrue(light.isOn());
        controller.turnOffAppliance(light.getName());
        Assertions.assertFalse(light.isOn());

        Assertions.assertFalse(fan.isOn());
        Assertions.assertEquals(0, ((Fan)fan).getSpeed());
        controller.turnOnAppliance(fan.getName());
        Assertions.assertEquals(1, ((Fan)fan).getSpeed());
        controller.setFanSpeed(fan.getName(), 2);
        Assertions.assertEquals(2, ((Fan)fan).getSpeed());
        Assertions.assertTrue(fan.isOn());
        controller.turnOffAppliance(fan.getName());
        Assertions.assertFalse(fan.isOn());
        Assertions.assertEquals(0, ((Fan)fan).getSpeed());

        Assertions.assertFalse(ac.isOn());
        Assertions.assertEquals(AirConditioner.AC_MODE.OFF, ((AirConditioner)ac).getMode());
        controller.turnOnAppliance(ac.getName());
        Assertions.assertEquals(AirConditioner.AC_MODE.COOL, ((AirConditioner)ac).getMode());
        controller.setAirConditionerMode(ac.getName(), AirConditioner.AC_MODE.HEAT);
        Assertions.assertEquals(AirConditioner.AC_MODE.HEAT, ((AirConditioner)ac).getMode());
        controller.turnOffAppliance(ac.getName());
        Assertions.assertEquals(AirConditioner.AC_MODE.OFF, ((AirConditioner)ac).getMode());
    }

    @Test
    public void testIncreaseDecreaseFanSpeed() {
        Fan fan= new Fan();
        fan.turnOn();
        Assertions.assertTrue(fan.isOn());
        Assertions.assertEquals(1, fan.getSpeed());
        fan.increaseSpeed();
        Assertions.assertEquals(2, fan.getSpeed());
        fan.increaseSpeed();
        Assertions.assertEquals(2, fan.getSpeed());
        fan.decreaseSpeed();
        Assertions.assertEquals(1, fan.getSpeed());
        fan.decreaseSpeed();
        Assertions.assertEquals(0, fan.getSpeed());
        Assertions.assertFalse(fan.isOn());
    }
}
