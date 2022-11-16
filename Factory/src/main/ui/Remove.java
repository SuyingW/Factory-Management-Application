package ui;

import model.Event;
import model.EventLog;
import model.Worker;

import javax.swing.*;
import java.awt.event.ActionEvent;

//represent a remove tool
public class Remove implements java.awt.event.ActionListener {
    private JLabel label;
    protected static JTextField removeName;
    private JButton remove;



    //EFFECTS: construct a remove tool
    public Remove() {
        label();
        textField();
        removeButton();
    }

    //MODIFIES: this
    //EFFECTS: display labels on panel
    public void label() {
        label = new JLabel("Name");
        label.setBounds(10, 210, 40, 25);
        GUI.panel.add(label);
    }

    //MODIFIES: this
    //EFFECTS: display text fields on panel
    public void textField() {
        removeName = new JTextField();
        removeName.setBounds(60, 210, 165,25);
        GUI.panel.add(removeName);
    }

    //MODIFIES: this
    //EFFECTS: display "Remove Worker from Factory" button on panel
    public void removeButton() {
        remove = new JButton("Remove Worker from Factory");
        remove.setBounds(10, 240, 250, 25);
        remove.addActionListener(this);
        GUI.panel.add(remove);
    }

    //EFFECTS: remove worker with the input name from the factory when clicking on "Remove" button,
    //         display all the workers names on panel
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = this.removeName.getText();
        for (Worker worker : GUI.factory.getWorkers()) {
            if (worker.getName().equals(name)) {
                GUI.factory.removeWorker(worker);
                EventLog.getInstance().logEvent(new Event("Worker removed from factory"));
                return;
            }
        }
        GUI.workerList.setText("Workers in Factory: " + GUI.factory.getNames());
    }

}
