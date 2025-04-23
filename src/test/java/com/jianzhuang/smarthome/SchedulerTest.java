import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import static org.mockito.Mockito.*;

public class SchedulerTest {

    @Test
    public void testScheduledTaskCallsTurnOffAll() throws InterruptedException {
        // Arrange
        SmartHomeController mockController = mock(SmartHomeController.class);
        Scheduler scheduler = new Scheduler(mockController); // using real Scheduler

        // Act
        scheduler.scheduleOnce(500); // schedule after 0.5s
        TimeUnit.MILLISECONDS.sleep(1000); // wait 1s to ensure task has run

        // Assert
        verify(mockController, times(1)).turnOffAll();

        scheduler.shutdown(); // clean up
    }
}
