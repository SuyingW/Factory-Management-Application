package model;

import org.json.JSONObject;
import persistence.Writable;

import java.nio.file.Watchable;

//represents a worker with name, hourly rate, hours worked, number of tasks completed, and current wage.
public class Worker implements Writable {
    public static final int NUM_TASKS_COMPLETED_FOR_BONUS = 150; // get bonus money for every 150 tasks completed
    public static final double PIECE_WAGE = 0.75; //  money for every task done in dollars
    public static final int BONUS = 100; // bonus in dollars

    private String name;
    private double hoursWorked;
    private int numOfTasksCompleted;
    private double hourlyRate;
    private double currentWage;


    // REQUIRES: hoursWorked, numOfTasksCompleted, hourlyRate, and currentWage are >= 0;
    // EFFECTS: construct a worker who have not started working yet with a name and hourly rate
    public Worker(String name, double hourlyRate, double hoursWorked, int numOfTasksCompleted) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.numOfTasksCompleted = numOfTasksCompleted;
        this.hourlyRate = hourlyRate;
        this.currentWage = 0;


    }

    // REQUIRES: time >= 0
    // MODIFIES: this
    // EFFECTS: add the number of hoursWorked worked
    public void addHoursWorked(double time) {
        this.hoursWorked = this.hoursWorked + time;
    }

    // REQUIRES: amount >= 0
    // MODIFIES: this
    // EFFECTS: add the number of tasks completed
    public void addNumOfTasksCompleted(int amount) {
        this.numOfTasksCompleted = this.numOfTasksCompleted + amount;
    }


    // MODIFIES: this
    // EFFECTS: calculate the wage we should pay to the worker at this moment
    public double calculateWage() {
        this.currentWage = this.hourlyRate * hoursWorked + PIECE_WAGE * numOfTasksCompleted
                + this.numOfTasksCompleted / NUM_TASKS_COMPLETED_FOR_BONUS * BONUS;
        return this.currentWage;
    }


    // EFFECTS: return the name of the worker
    public String getName() {
        return this.name;
    }

    // EFFECTS: return the number of hours this worker worked
    public double getHours() {
        return this.hoursWorked;
    }

    // EFFECTS: return the number of tasks the worker completed
    public int getNumOfTasks() {
        return this.numOfTasksCompleted;
    }

    // EFFECTS: return the hourly rate of the worker
    public double getHourlyRate() {
        return this.hourlyRate;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("hourly rate", hourlyRate);
        json.put("hours worked", hoursWorked);
        json.put("number of tasks completed", numOfTasksCompleted);
        return json;
    }
}





