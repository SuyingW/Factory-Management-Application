package ui;

import model.Event;
import model.EventLog;
import model.Worker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents an update tool which updates statistics for workers
public class Update implements ActionListener {
    private JLabel name;
    private JLabel hours;
    private JLabel tasks;
    private JTextField nameUpdate;
    private JTextField hoursMore;
    private JTextField tasksMore;
    private JButton update;

    //EFFECTS: constructs a update tool
    public Update() {
        label();
        textField();
        addButton();
    }

    //MODIFIES: this
    //EFFECTS: display labels on panel
    public void label() {
        name = new JLabel("Name");
        name.setBounds(10, 370,200,25);
        GUI.panel.add(name);
        hours = new JLabel("How Many More Hours Worked");
        hours.setBounds(10,400,200,25);
        GUI.panel.add(hours);
        tasks = new JLabel("How Many More Tasks Completed");
        tasks.setBounds(10,430,250,25);
        GUI.panel.add(tasks);
    }

    //MODIFIES: this
    //EFFECTS: display "Update Statistics for Worker" button on panel
    public void addButton() {
        update = new JButton("Update Statistics for Worker");
        update.setBounds(10,460,250,25);
        update.addActionListener(this);
        GUI.panel.add(update);
    }

    //MODIFIES: this
    //EFFECTS: display text fields on panel
    public void textField() {
        nameUpdate = new JTextField();
        nameUpdate.setBounds(260,370,165,25);
        GUI.panel.add(nameUpdate);
        hoursMore = new JTextField();
        hoursMore.setBounds(260,400,165,25);
        GUI.panel.add(hoursMore);
        tasksMore = new JTextField();
        tasksMore.setBounds(260,430,165,25);
        GUI.panel.add(tasksMore);
    }

    //EFFECTS: add the given hours and number of tasks for the input worker
    //        and display the new statistics for input worker
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = this.nameUpdate.getText();
        Double hoursWorked = Double.parseDouble(this.hoursMore.getText());
        Integer numTasks = Integer.parseInt(this.tasksMore.getText());
        for (Worker worker : GUI.factory.getWorkers()) {
            if (worker.getName().equals(name)) {
                GUI.factory.selectWorker(worker);
                worker.addHoursWorked(hoursWorked);
                worker.addNumOfTasksCompleted(numTasks);
                EventLog.getInstance().logEvent(new Event("Updated statistics for worker"));
            }
        }
        ShowProfile.name.setText("Name: " + GUI.factory.getSelectedWorker().getName());
        ShowProfile.hours.setText("Hours Worked: " + GUI.factory.getSelectedWorker().getHours());
        ShowProfile.tasks.setText("Number of Tasks Completed: " + GUI.factory.getSelectedWorker().getNumOfTasks());
        CalculateWage.wage.setText("Wage: $");
    }
}
