import java.time.*;
import java.util.concurrent.*;

public class Scheduler {
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final SmartHomeController controller;

    public Scheduler(SmartHomeController controller) {
        this.controller = controller;
    }

    public void scheduleYearlyUpdate() {
        long initialDelay = computeInitialDelay();
        long oneYear = Duration.ofDays(365).toMillis(); // approx yearly

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("[" + LocalDateTime.now() + "] Running scheduled system update.");
            controller.turnOffAll();
        }, initialDelay, oneYear, TimeUnit.MILLISECONDS);
    }

    private long computeInitialDelay() {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime nextRun = now.withMonth(1).withDayOfMonth(1)
                .withHour(1).withMinute(0).withSecond(0).withNano(0);

        if (now.compareTo(nextRun) >= 0) {
            nextRun = nextRun.plusYears(1);
        }

        return Duration.between(now, nextRun).toMillis();
    }

    public void shutdown() {
        scheduler.shutdown();
    }
    public void scheduleOnce(long delayMillis) {
        scheduler.schedule(() -> {
            System.out.println("Running single scheduled task (test mode).");
            controller.turnOffAll(); // this is what we want to verify
        }, delayMillis, TimeUnit.MILLISECONDS);
    }

}
