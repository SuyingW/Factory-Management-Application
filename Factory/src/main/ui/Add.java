package ui;

import model.Event;
import model.EventLog;
import model.Worker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents an add tool that can add workers to the factory
public class Add implements ActionListener {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private  JLabel label4;
    private JTextField addName;
    private JTextField hourlyRate;
    private JTextField hoursWorked;
    private JTextField numTasks;
    private JButton add;

    //EFFECTS: construct an add tool
    public Add() {
        labels();
        textField();
        addButton();
    }

    //MODIFIES: this
    //EFFECTS: display labels on panel
    public void labels() {
        label1 = new JLabel("Name");
        label1.setBounds(10, 20, 200, 25);
        label2 = new JLabel("Hourly Rate");
        label2.setBounds(10, 50, 200, 25);
        label3 = new JLabel("Hours Worked");
        label3.setBounds(10, 80, 200, 25);
        label4 = new JLabel("Number of Tasks Completed");
        label4.setBounds(10, 110, 200, 25);
        GUI.panel.add(label1);
        GUI.panel.add(label2);
        GUI.panel.add(label3);
        GUI.panel.add(label4);
    }

    //MODIFIES: this
    //EFFECTS: display text fields on panel
    public void textField() {
        addName = new JTextField();
        addName.setBounds(210, 20, 165, 25);
        GUI.panel.add(addName);
        hourlyRate = new JTextField();
        hourlyRate.setBounds(210,50,165,25);
        GUI.panel.add(hourlyRate);
        hoursWorked = new JTextField();
        hoursWorked.setBounds(210,80,165,25);
        GUI.panel.add(hoursWorked);
        numTasks = new JTextField();
        numTasks.setBounds(210,110,165,25);
        GUI.panel.add(numTasks);
    }

    //MODIFIES: this
    //EFFECTS: display "Add Worker to Factory" button on panel
    public void addButton() {
        add = new JButton("Add Worker to Factory");
        add.setBounds(10, 140, 250, 25);
        add.addActionListener(this);
        GUI.panel.add(add);
    }

    //EFFECTS: construct and add a worker to the factory when click on "Add" button,
    //         display all the workers names on panel
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = this.addName.getText();
        Double hourlyRate = Double.parseDouble(this.hourlyRate.getText());
        Double hoursWorked = Double.parseDouble(this.hoursWorked.getText());
        Integer numTasks = Integer.parseInt(this.numTasks.getText());
        Worker worker = new Worker(name, hourlyRate, hoursWorked, numTasks);
        GUI.factory.addWorker(worker);
        GUI.workerList.setText("Workers in Factory: " + GUI.factory.getNames());
        EventLog.getInstance().logEvent(new Event("worker added to factory"));

    }
}
