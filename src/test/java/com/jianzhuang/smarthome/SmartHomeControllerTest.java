import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
