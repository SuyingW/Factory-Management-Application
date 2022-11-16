package ui;

import model.Worker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represent a tool to calculate wage for worker
public class CalculateWage implements ActionListener {
    protected static JLabel wage;
    private JButton calculate;

    //EFFECTS: construct a calculate wage tool
    public CalculateWage() {
        label();
        calculateButton();
    }

    //MODIFIES: this
    //EFFECTS: display labels on panel
    public void label() {
        wage = new JLabel("Wage: $");
        wage.setBounds(400, 330, 200, 25);
        GUI.panel.add(wage);
    }

    //MODIFIES: this
    //EFFECTS: display "Calculate Wage" button on panel
    public void calculateButton() {
        calculate = new JButton("Calculate Wage");
        calculate.setBounds(10, 300, 250, 25);
        calculate.addActionListener(this);
        GUI.panel.add(calculate);
    }

    //EFFECTS: calculate wage for worker when click on "Calculate Wage" button
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = Remove.removeName.getText();
        for (Worker worker : GUI.factory.getWorkers()) {
            if (worker.getName().equals(name)) {
                GUI.factory.selectWorker(worker);
            }
            ShowProfile.name.setText("Name: " + GUI.factory.getSelectedWorker().getName());
            ShowProfile.rate.setText("Hourly Rate: $" + GUI.factory.getSelectedWorker().getHourlyRate());
            ShowProfile.hours.setText("Hours Worked: " + GUI.factory.getSelectedWorker().getHours());
            ShowProfile.tasks.setText("Number of Tasks Completed: " + GUI.factory.getSelectedWorker().getNumOfTasks());
            this.wage.setText("Wage: $" + GUI.factory.getSelectedWorker().calculateWage());
        }
    }
}

