package ui;

import persistence.JsonReader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//represents a load tool that load the whole factory from data
public class Load implements ActionListener {
    private JButton load;
    private static final String JSON_STORE = "./data/factory.json";
    private JsonReader jsonReader;

    //EFFECTS: construct a load tool
    public Load() {
        loadButton();
        jsonReader = new JsonReader(JSON_STORE);
    }

    //MODIFIES: this
    //EFFECTS: display "Load" button on panel
    public void loadButton() {
        load = new JButton("Load");
        load.setBounds(400,80,165,25);
        load.addActionListener(this);
        GUI.panel.add(load);
    }

    //EFFECTS: save the whole factory to data when clicking on "Load" button
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            GUI.factory = jsonReader.read();
            GUI.workerList.setText("Workers in Factory: " + GUI.factory.getNames());
        } catch (IOException exception) {
            GUI.workerList.setText("Unable to read from file: " + JSON_STORE);
        }
    }
}
