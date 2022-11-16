package ui;

import model.Worker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents a tool that shows profiles of workers
public class ShowProfile implements ActionListener {
    protected static JLabel name;
    protected static JLabel hours;
    protected static JLabel tasks;
    protected static JLabel rate;
    private JButton profile;

    //EFFECTS: construct a show profile tool
    public ShowProfile() {
        label();
        profileButton();
    }

    //MODIFIES: this
    //EFFECTS: display labels on panel
    public void label() {
        name = new JLabel("Name: ");
        name.setBounds(400, 210, 200, 25);
        GUI.panel.add(name);
        rate = new JLabel("Hourly Rate: $");
        rate.setBounds(400,240,200,25);
        GUI.panel.add(rate);
        hours = new JLabel("Hours Worked: ");
        hours.setBounds(400, 270, 200, 25);
        GUI.panel.add(hours);
        tasks = new JLabel("Number of Tasks Completed: ");
        tasks.setBounds(400, 300, 250, 25);
        GUI.panel.add(tasks);
    }

    //MODIFIES: this
    //EFFECTS: display "Show Profile of this Worker" button on panel
    public void profileButton() {
        profile = new JButton("Show Profile of this Worker");
        profile.setBounds(10, 270, 250, 25);
        profile.addActionListener(this);
        GUI.panel.add(profile);
    }

    //EFFECTS: show the profile of the worker with the input name when click on "Show Profile of this Worker" button
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = Remove.removeName.getText();
        for (Worker worker : GUI.factory.getWorkers()) {
            if (worker.getName().equals(name)) {
                GUI.factory.selectWorker(worker);
            }
        }
        this.name.setText("Name: " + GUI.factory.getSelectedWorker().getName());
        this.rate.setText("Hourly Rate: $" + GUI.factory.getSelectedWorker().getHourlyRate());
        this.hours.setText("Hours Worked: " + GUI.factory.getSelectedWorker().getHours());
        this.tasks.setText("Number of Tasks Completed: " + GUI.factory.getSelectedWorker().getNumOfTasks());
        CalculateWage.wage.setText("Wage: $");
    }
}
