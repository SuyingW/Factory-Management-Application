package ui;

import model.Event;
import model.EventLog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents the quit tool that closes the frame
public class Quit implements ActionListener {
    private JButton quit;

    //EFFECTS: construct a quit tool
    public Quit() {
        quitButton();
    }

    //MODIFIES: this
    //EFFECTS: display "Quit" button on panel
    public void quitButton() {
        quit = new JButton("Quit");
        quit.setBounds(400,110,165,25);
        quit.addActionListener(this);
        GUI.panel.add(quit);
    }

    //EFFECTS: close the frame when the "Quit" button is clicked on
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Event next : EventLog.getInstance()) {
            System.out.println(next.toString() + "\n\n");
        }
        System.exit(0);
    }


}
