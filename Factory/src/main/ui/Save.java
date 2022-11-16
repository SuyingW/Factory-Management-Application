package ui;

import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

//represents a save tool
public class Save implements ActionListener {
    private JButton save;
    private static final String JSON_STORE = "./data/factory.json";
    private JsonWriter jsonWriter;

    //EFFECTS: construct a save tool
    public Save() {
        saveButton();
        jsonWriter = new JsonWriter(JSON_STORE);
    }

    //MODIFIES: this
    //EFFECTS: display "Save" button on panel
    public void saveButton() {
        save = new JButton("Save");
        save.setBounds(400, 50, 165,25);
        save.addActionListener(this);
        GUI.panel.add(save);
    }

    //EFFECTS: save the whole factory to data when click on "Save" button
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            jsonWriter.open();
            jsonWriter.write(GUI.factory);
            jsonWriter.close();
            GUI.workerList.setText("Saved " + GUI.factory.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException exception) {
            GUI.workerList.setText("Unable to write to file: " + JSON_STORE);
        }
    }

}
