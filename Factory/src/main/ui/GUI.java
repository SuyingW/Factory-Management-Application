package ui;


import model.Factory;

import javax.swing.*;

//represents the frame for FactoryStaffManagement application
public class GUI extends JFrame {
    protected static Factory factory;
    protected static JFrame frame;
    protected static JPanel panel;
    protected static JLabel workerList;

    //EFFECTS: construct a frame for the application
    public GUI() {
        background();
        display();
        new Add();
        new Remove();
        new ShowProfile();
        new CalculateWage();
        new Update();
        new Save();
        new Load();
        new Quit();
        new BarGraph();
        frame.setVisible(true);
        BarGraph.graphics = frame.getGraphics();
        this.factory = new Factory("My Factory");
    }

    //MODIFIES: this
    //EFFECTS: construct a frame and a panel
    public void background() {
        this.panel = new JPanel();
        this.frame = new JFrame();
        frame.setSize(700, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
    }

    //MODIFIES: this
    //EFFECTS: construct a label that displays the names of workers in this factory
    public void display() {
        workerList = new JLabel("Workers in Factory: ");
        workerList.setBounds(400, 20, 1000, 25);
        panel.add(workerList);
    }



}




