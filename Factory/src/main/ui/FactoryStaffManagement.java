package ui;


import model.Factory;
import model.Worker;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




// Factory staff management application
// Reference: TellerApp
public class FactoryStaffManagement {
    private static final String JSON_STORE = "./data/factory.json";
    private Factory factory;
    private Scanner input;
    private List<String> names;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;



    // EFFECTS: runs the factory staff management application
    public FactoryStaffManagement() throws FileNotFoundException {
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        this.names = new ArrayList<>();
        runFactory();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runFactory() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);
        init();

        while (keepGoing) {
            displayMenu1();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addWorkerToFactory();
        } else if (command.equals("r")) {
            removeWorkerFromFactory();
        }  else if (command.equals("v")) {
            viewListOfWorkers();
        } else if (command.equals("u")) {
            updateStatistics();
        } else if (command.equals("w")) {
            calculateWageForAWorker();
        } else if (command.equals("s")) {
            showProfile();
        } else if (command.equals("save")) {
            saveFactory();
        } else if (command.equals("load")) {
            loadFactory();
        } else {
            System.out.println("Selection not valid");
        }
    }

    // MODIFIES: this
    // EFFECTS: start a new factory
    private void init() {
        this.factory = new Factory("MyFactory");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu1() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add a new worker to the factory");
        System.out.println("\tr -> remove a worker from the factory");
        System.out.println("\tu -> update statistics for a worker");
        System.out.println("\tw -> calculate wage for a worker");
        System.out.println("\ts -> show the profile of a worker");
        System.out.println("\tv -> view the list of workers");
        System.out.println("\tsave -> save factory to file");
        System.out.println("\tload -> load factory from file");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: add a worker to factory
    private void addWorkerToFactory() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter worker's name: ");
        String name = input.nextLine();
        this.names.add(name);
        System.out.println("Enter worker's hourly rate: ");
        double hourlyRate = input.nextDouble();
        System.out.println("Enter how many hours the worker worked: ");
        double hoursWorked = input.nextDouble();
        System.out.println("Enter how many tasks the worker completed: ");
        int numOfTasksCompleted = input.nextInt();
        Worker worker = new Worker(name, hourlyRate, hoursWorked, numOfTasksCompleted);
        this.factory.addWorker(worker);
    }

    // MODIFIES: this
    // EFFECTS: remove a worker from factory
    private void removeWorkerFromFactory() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter worker's name: ");
        String name = input.nextLine();
        this.names.remove(name);
        for (Worker worker : this.factory.getWorkers()) {
            if (worker.getName().equals(name)) {
                this.factory.removeWorker(worker);
                return;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: view the list of workers names in factory
    private void viewListOfWorkers() {
        System.out.println(this.factory.getNames());
    }

    // MODIFIES: this
    // EFFECTS: update statistics for a worker
    private void updateStatistics() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter worker's name: ");
        String name = input.nextLine();
        System.out.println("Enter how many more hours worked: ");
        double time = input.nextDouble();
        System.out.println("Enter how many more tasks completed: ");
        int amount = input.nextInt();
        for (Worker worker : this.factory.getWorkers()) {
            if (worker.getName().equals(name)) {
                this.factory.getWorker(worker).addHoursWorked(time);
                this.factory.getWorker(worker).addNumOfTasksCompleted(amount);
                return;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: calculate the wage of a worker
    private void calculateWageForAWorker() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter worker's name: ");
        String name = input.nextLine();
        for (Worker worker : this.factory.getWorkers()) {
            if (worker.getName().equals(name)) {
                double wage = this.factory.getWorker(worker).calculateWage();
                System.out.println(wage);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: show the profile of a worker
    private void showProfile() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter worker's name: ");
        String name = input.nextLine();
        for (Worker worker : this.factory.getWorkers()) {
            if (worker.getName().equals(name)) {
                System.out.println("Hours worked: " + this.factory.getWorker(worker).getHours());
                System.out.println("Tasks completed: " + this.factory.getWorker(worker).getNumOfTasks());
            }
        }
    }

    //EFFECTS: saves the factory to file
    private void saveFactory() {
        try {
            jsonWriter.open();
            jsonWriter.write(factory);
            jsonWriter.close();
            System.out.println("Saved " + factory.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads factory from file
    private void loadFactory() {
        try {
            factory = jsonReader.read();
            System.out.println("Loaded " + factory.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
