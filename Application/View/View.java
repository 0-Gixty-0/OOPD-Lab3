package Application.View;
import java.awt.Dimension;

import javax.swing.*;

import Application.Controller.Controller;
import Application.Model.Model;
import Application.Observer.Events;
import Application.Observer.IObserver;
import java.awt.*;

public class View extends JFrame implements ModelObserver, IObserver{

    private JPanel controlPanel;
    private JPanel gasPanel;
    private Model model;

    private static final int X = 800;
    private static final int Y = 800;
    private DrawPanel drawPanel;

    private Controller controller;
    JLabel gasLabel = new JLabel("Amount of gas");

    public View(Controller controller, Model model) {
        this.controller = controller;
        this.initComponents("Car Application");
        this.model = model;
        this.drawPanel = new DrawPanel(X, Y-240, model);
    }

    @Override
    public void handleEvent(Events.Event e){
        switch (e) {
            case UPDATESCREEN:
                this.update();
                break;
            default:
                break;
        }
    }
    
    @Override
    public void update(){
        this.repaint();
    }

    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        gasPanel = controller.createGasPanel(gasLabel);

        this.add(gasPanel);

        controlPanel = controller.createControlPanel(X);

        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        this.add(controller.setupStartButton(X));

        this.add(controller.setupStopButton(X));


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}