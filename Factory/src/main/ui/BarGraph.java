package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents a bar graph that shows workers' statistics
public class BarGraph extends JFrame implements ActionListener {
    private JButton barGraph;
    protected static Graphics graphics;
    private JLabel l1;
    private JLabel l2;


    //EFFECTS: construct a bar graph with the frame as its graphics
    public BarGraph() {
        label();
        graphButton();
        graphics = GUI.frame.getGraphics();
    }

    //MODIFIES: this
    //EFFECTS: display "Bar Graph" button on panel
    public void graphButton() {
        barGraph = new JButton("Bar Graph");
        barGraph.setBounds(400, 140,165,25);
        barGraph.addActionListener(this);
        GUI.panel.add(barGraph);
    }


    //EFFECTS: draw the bars represent each worker's working time on panel
    public void drawHours(Graphics g) {
        int num = GUI.factory.getWorkers().size();
        for (int i = 0; i < num; i++) {
            int h = (int)Math.round(GUI.factory.getWorkers().get(i).getHours());
            g.setColor(Color.BLUE);
            g.drawRect(250 + 60 * i, 730 - h,20, h);
        }
    }

    //EFFECTS: draw the bars represent each worker's number of tasks completed on panel
    public void drawTasks(Graphics g) {
        int num = GUI.factory.getWorkers().size();
        for (int i = 0; i < num; i++) {
            int h = GUI.factory.getWorkers().get(i).getNumOfTasks();
            g.setColor(Color.PINK);
            g.drawRect(272 + 60 * i, 730 - h, 20, h);
        }
    }

    //EFFECTS: remove bars represent each worker's working time from panel
    public void removeHours(Graphics g) {
        int num = GUI.factory.getWorkers().size();

        for (int i = 0; i < num; i++) {
            int h = (int)Math.round(GUI.factory.getWorkers().get(i).getHours());
            g.clearRect(250 + 60 * i, 730 - h,20, h);
        }
    }

    //EFFECTS: remove bars represent each worker's number of tasks completed from panel
    public void removeTasks(Graphics g) {
        int num = GUI.factory.getWorkers().size();

        for (int i = 0; i < num; i++) {
            int h = GUI.factory.getWorkers().get(i).getNumOfTasks();
            g.clearRect(272 + 60 * i, 730 - h, 20, h);
        }
    }

    //EFFECTS: construct legend for the bar graph
    public void legend() {
        graphics.setColor(Color.BLUE);
        graphics.drawRect(130,580,15,10);
        graphics.setColor(Color.PINK);
        graphics.drawRect(130,610,15,10);
    }

    //MODIFIES: this
    //EFFECTS: display labels on panel
    public void label() {
        l1 = new JLabel("Hours Worked");
        l2 = new JLabel("Tasks Completed");
        l1.setBounds(10, 550,120, 25);
        l2.setBounds(10,580,120,25);
        GUI.panel.add(l1);
        GUI.panel.add(l2);
    }

    //EFFECTS: draw each worker's name on panel
    public void names(Graphics g) {
        int num = GUI.factory.getWorkers().size();
        for (int i = 0; i < num; i++) {
            String name = GUI.factory.getWorkers().get(i).getName();
            g.setColor(Color.BLACK);
            g.drawString(name,250 + 60 * i, 750);
        }
    }

    //EFFECTS: generate a bar graph when "Bar Graph" button is clicked on
    @Override
    public void actionPerformed(ActionEvent e) {
        legend();
        names(graphics);
        removeTasks(graphics);
        removeHours(graphics);
        drawHours(graphics);
        drawTasks(graphics);
    }
}
