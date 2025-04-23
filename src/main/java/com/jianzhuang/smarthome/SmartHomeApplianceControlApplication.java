public class SmartHomeApplianceControlApplication {
    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();
        controller.addAppliance(new Light());
        controller.addAppliance(new Fan());
        controller.addAppliance(new AirConditioner());

        controller.turnOnAll();
        controller.printStatus();

        Scheduler scheduler = new Scheduler(controller);
        scheduler.scheduleYearlyUpdate();

        // Keep main thread alive (optional in real apps you'd use GUI/Daemon)
        System.out.println("Smart Home System is running. Waiting for yearly update...");
    }
}
