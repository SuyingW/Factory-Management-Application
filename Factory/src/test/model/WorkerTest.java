package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkerTest {
    private Worker testWorker;

    @BeforeEach
    void runBefore() {
        testWorker = new Worker("Suying", 20.2,0,0);
    }

    @Test
    void testConstructor() {
        assertEquals("Suying", testWorker.getName());
        assertEquals(20.2, testWorker.getHourlyRate());
        assertEquals(0, testWorker.getHours());
        assertEquals(0, testWorker.getNumOfTasks());
        assertEquals(0, testWorker.calculateWage());
    }

    @Test
    void testAddHours() {
        testWorker.addHoursWorked(5.5);
        assertEquals(5.5, testWorker.getHours());
        testWorker.addHoursWorked(8);
        assertEquals(13.5, testWorker.getHours());
    }

    @Test
    void testAddNumOfTasksCompleted() {
        testWorker.addNumOfTasksCompleted(40);
        assertEquals(40, testWorker.getNumOfTasks());
        testWorker.addNumOfTasksCompleted(18);
        assertEquals(58,testWorker.getNumOfTasks());
    }

    @Test
    void testCalculateSalaryNoBonus() {
        testWorker.addHoursWorked(8);
        testWorker.addNumOfTasksCompleted(40);
        testWorker.addNumOfTasksCompleted(2);
        assertEquals(193.1, testWorker.calculateWage());
    }

    @Test
    void testCalculateSalaryWithBonus() {
        testWorker.addHoursWorked(100);
        testWorker.addNumOfTasksCompleted(200);
        assertEquals(2270,testWorker.calculateWage());
        testWorker.addHoursWorked(100);
        testWorker.addNumOfTasksCompleted(200);
        testWorker.calculateWage();
        assertEquals(4540,testWorker.calculateWage());
    }

}





