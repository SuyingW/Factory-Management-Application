package persistence;

import model.Worker;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkWorker(String name, double hourlyRate, double hoursWorked, int numOfTasksCompleted, Worker worker) {
        assertEquals(name, worker.getName());
        assertEquals(hourlyRate, worker.getHourlyRate());
        assertEquals(hoursWorked, worker.getHours());
        assertEquals(numOfTasksCompleted, worker.getNumOfTasks());
    }
}
